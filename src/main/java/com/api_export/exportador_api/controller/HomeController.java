package com.api_export.exportador_api.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api_export.exportador_api.service.ApiService;

import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final ApiService apiService;

    public HomeController(ApiService apiService){
        this.apiService = apiService;
        
    }
    
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/search")
    public String searchApi(@RequestParam String url, @RequestParam(required = false) String key, 
            Model model) {
                List<Map<String,Object>> dados = apiService.searchApi(url, key);
                model.addAttribute("dados", dados);
        
        
        return "index";
    }
    
    

}
