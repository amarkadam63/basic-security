package com.amarkadam.basicsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String getPage(){
        return "Home Page";
    }

}

@RestController
class LoginController {

    @GetMapping("/login")
    public String login(){
        return "Home Page";
    }
}



@RestController
class SignUpController {

    @GetMapping("/signup")
    public String signUp(){
        return "SignUp";
    }
}

@RestController
class AdminController {

    @GetMapping("/admin")
    public String signUp(){
        return "Admin Page";
    }
}

@RestController
class ErrorController{

    @GetMapping("/403")
    public String errorHandler(){
        return "Error Occured";
    }
}