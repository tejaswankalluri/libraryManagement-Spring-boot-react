package me.tejaswan.LibraryManagement.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPage {
    @GetMapping("/")
    public String getHomePage(Model model){
        return "index";
    }
}
