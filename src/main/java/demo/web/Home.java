package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class Home {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}
