package cg.park.kotlin_borad.comm

import cg.park.kotlin_borad.service.UserService
import cg.park.kotlin_borad.util.Param
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthController(private val userService: UserService) {

    @PostMapping("/login")
    fun login(@RequestBody param: Param): ResponseEntity<Param> {
        val user = userService.findByUser(param)

        return ResponseEntity.ok(Param())
    }

}