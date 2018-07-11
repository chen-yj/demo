package com.example.demo.web;

import com.example.demo.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi() {
        return ribbonService.hi();
    }
}
