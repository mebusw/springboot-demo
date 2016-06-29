package demo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @RequestMapping(value = "/")
    List customers() {
        return Arrays.asList(1, 2, 3);
    }


    @RequestMapping(value = "/{customer}", method = RequestMethod.GET)
    String getCustomer(@PathVariable("customer") Long customer, HttpSession httpSession) {
        System.out.println("customer = [" + customer + "], httpSession = [" + httpSession + "]");
        return "CustomerController = " + customer;
    }


    @RequestMapping(value = "/objmap", method = RequestMethod.GET)
    String objmap() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{\"name\":\"mkyong\", \"age\":123}";
        try {
            Staff obj = mapper.readValue(jsonInString, Staff.class);
            System.out.println(obj.getName());
            System.out.println(obj.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "objmap";
    }

    @RequestMapping(value = "/commits", method = RequestMethod.GET)
    String getCommits() {
        String url = "https://api.github.com/repos/vuejs/vue/commits?per_page=3&sha=";
        try {
            InputStream resp = new URL(url).openStream();
            Scanner scanner = new Scanner(resp);
            String respBody = scanner.useDelimiter("\\A").next();
            return respBody;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error reading from github api";
    }

}

class Staff {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

