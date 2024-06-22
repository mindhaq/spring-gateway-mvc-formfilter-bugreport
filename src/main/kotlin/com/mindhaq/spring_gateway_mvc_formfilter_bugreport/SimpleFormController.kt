package com.mindhaq.spring_gateway_mvc_formfilter_bugreport

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SimpleFormController {
    @PostMapping("/form")
    @ResponseBody
    fun handleForm(
        @RequestParam name: String,
    ): String {
        return "Hello, $name!"
    }
}
