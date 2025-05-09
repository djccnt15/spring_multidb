package com.djccnt15.spring_multidb.domain.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class IndexController {
    
    @GetMapping
    public String redirectIndex() {
        return "redirect:/swagger-ui/index.html";
    }
}
