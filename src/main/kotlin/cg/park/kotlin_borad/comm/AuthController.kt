package cg.park.kotlin_borad.comm

import cg.park.kotlin_borad.service.UserService
import cg.park.kotlin_borad.util.JwtProvider
import cg.park.kotlin_borad.util.Param
import cg.park.kotlin_borad.util.ResponseParam
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/auth")
@RestController
class AuthController(private val userService: UserService, private val jwtUtil : JwtProvider) {

    @PostMapping("/login")
    fun login(@RequestBody param: Param): ResponseEntity<Param> {
        return ResponseParam.success(userService.findByUser(param))
    }

    @GetMapping("/me")
    fun me(@RequestHeader("Authorizationn") authHeader: String = "") : ResponseEntity<Param> {
        return ResponseParam.of(authHeader.isNotBlank(), jwtUtil.parseJwtToken(authHeader))
    }

}