package com.ecommerce.adapter.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Se ha producido un error. Por favor, intenta nuevamente más tarde.";
    }

    // @Override
    public String getErrorPath() {
        return PATH;
    }
}
