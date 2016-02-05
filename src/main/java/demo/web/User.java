package demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class User {
    @RequestMapping("/")
    String users() {
        return "1,2,3...";
    }

    @RequestMapping(value="/{user}", method= RequestMethod.GET)
    String getUser(@PathVariable Long user) {
        return "UserId = " + user;
    }

}
