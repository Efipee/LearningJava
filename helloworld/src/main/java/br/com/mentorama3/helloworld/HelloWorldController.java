package br.com.mentorama3.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    static String olaMundo = "Helloo World";

    @GetMapping("/OlaMundo")
    @ResponseBody
    public String digaOlaMundo() {
        return olaMundo;
    }
    
}
