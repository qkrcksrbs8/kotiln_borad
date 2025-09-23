package cg.park.kotlin_borad.comm

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class IndexController {

    @GetMapping("/test")
    @ResponseBody
    fun defaultPage(str: String? = ""): String {
        return "welcome :$str";
    }

    @GetMapping("")
    fun index(): String {
        return "index";
    }

}