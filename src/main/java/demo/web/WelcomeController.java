package demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Note: this is a Controller not a RestController.
 * It will find relative template by name e.g.:'welcome(.ftl)'
 */
@Controller
public class WelcomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        String username = authentication.getName() + authentication.getPrincipal();
        model.put("time", new Date());
        model.put("message", this.message + " isAuthenticated=" + authentication.isAuthenticated() + "   " + username);
        return "welcome";
    }

    @RequestMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }
}
