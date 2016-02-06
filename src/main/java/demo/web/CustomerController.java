package demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @RequestMapping("/")
    @ResponseBody
    List customers() {
        return Arrays.asList(1,2,3);
    }

    @RequestMapping(value = "/{customer}", method = RequestMethod.GET)
    String getCustomer(@PathVariable Long customer) {
        return "CustomerController = " + customer;
    }

}
