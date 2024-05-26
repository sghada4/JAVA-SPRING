package com.ghada.hopperreceipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HopperController {
	
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Joe Doe";
        String itemName = "Other wire";
        double price = 10.5;
        String description = "Other description for testing!";
        String vendor = "Some text for test";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);
    
        return "index.jsp";
    }
    //...
    

}
