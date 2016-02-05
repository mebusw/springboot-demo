package demo.web;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/customers")
public class Customer {
    @RequestMapping("/")
    String customers() {
        Gson gson = new Gson();
        return gson.toJson(Arrays.asList(1,2,3));


    }

    @RequestMapping(value = "/{customer}", method = RequestMethod.GET)
    String getCustomer(@PathVariable Long customer) {
        return "Customer = " + customer;
    }

}
