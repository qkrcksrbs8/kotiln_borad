package cg.park.kotlin_borad.comm

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/test")
    fun defaultPage(str: String? = ""): String {
        return "welcome :$str";
    }

}