package Capstone.Petfinity.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello/yezi")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
// 혹시 보이나요?