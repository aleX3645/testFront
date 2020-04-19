package com.example.testSite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path="/test")
public class IndexController {

    @GetMapping(path="/index")
    public String indexHtml(Map<String,Object> model){
        return "index";
    }

    @PostMapping(path = "/index")
    public String getById(@RequestParam String idInput, @RequestParam String langInput, Map<String,Object> model){
        model.put("json",new WebApiDatabase().getJson(idInput, langInput));
        return "chart";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    String getAllUsers() {
        // This returns a JSON or XML with the users
        return "s";
    }
}
