package gdsc.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
