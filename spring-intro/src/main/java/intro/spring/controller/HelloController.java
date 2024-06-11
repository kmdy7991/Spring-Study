package intro.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello World");
        return "hello";
    }

    @GetMapping("mvc")
    public String mvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "mvc";
    }

    @GetMapping("api-string")
    @ResponseBody
    public String apiString(@RequestParam("name") String name) {
        return "api-string" + name;
    }
}
