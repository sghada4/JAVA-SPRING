package com.ghada.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/home")
    public String index(@RequestParam(value="name") String name) {
        return "Hello " + name;
    }
	
	@RequestMapping("/")
    public String home() {
        return "Hello Human";
    }
}
