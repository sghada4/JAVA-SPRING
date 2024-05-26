package com.ghada.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ghada.fruityloops.Item;

@Controller
public class ItemController {
 
 @RequestMapping("/")
 public String index(Model model) {
     
     ArrayList<Item> fruits = new ArrayList<Item>();
     fruits.add(new Item("Kiwi", 1.5));
     fruits.add(new Item("Mango", 2.0));
     fruits.add(new Item("Goji Berries", 4.0));
     fruits.add(new Item("Guava", .75));
     fruits.add(new Item("Banana", 4.9));
     fruits.add(new Item("Apple", 1.75));
     fruits.add(new Item("Strawberry", 3.5));
     
     model.addAttribute("allFruits", fruits);
     
     
     return "index.jsp";
 }
}

