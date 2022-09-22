package com.example.erpbackend.Swagger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class SwaggerController {
    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUI(){
        return "redirect:/swagger-ui.html";
    }
}
