package com.example.Task31.controller;

import com.example.Task31.entity.Item;
import com.example.Task31.repositoryies.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {
   @Autowired
   private ItemRepository itemRepository;
    @GetMapping(value = "/add-shop")
    public String openAddShop(){
        return "add-shop";
    }
    @PostMapping(value = "/add-shop")
    public String addShop(@RequestParam("shop_name") String name,
                          @RequestParam("shop_description") String description,
                          @RequestParam("shop_price") double price){
        Item item=new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:shop";
    }
    @GetMapping(value = "/shop")
         public String openShop(Model model){
        List<Item> items=itemRepository.findAll();
        model.addAttribute("items", items);
        return "shop";

    }
}
