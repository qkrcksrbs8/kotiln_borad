package cg.park.kotlin_borad.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant
import java.util.*
import javax.crypto.spec.SecretKeySpec

@Component
class JwtProvider {

    val secretKey = "PCG_JWT_KEY";

    // token 생성
    fun create(subject: String): String {
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)                           // (1)
                .setIssuer("PCG")                                                       // 토큰 발급자(iss)
                .setSubject(subject)                                                    // 토큰 제목(sub)
                .setIssuedAt(Date.from(Instant.now()))                                  // 발급시간(iat)
                .setExpiration(Date.from(Instant.now().plus(Duration.ofDays(1)))) // 만료시간(exp)
                .signWith(SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), SignatureAlgorithm.HS256.jcaName), SignatureAlgorithm.HS256)
                .compact()
    }

    // bearer 제거
    fun bearerRemove(token: String): String {
        return token.removePrefix("Bearer ").trim()
    }

    // token 파싱
    fun parseJwtToken(token: String): Claims {
        val keyBytes = secretKey.toByteArray(Charsets.UTF_8)
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(keyBytes))
                .build()
                .parseClaimsJws(bearerRemove(token))
                .body
    }
}