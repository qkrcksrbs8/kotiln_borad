package cg.park.kotlin_borad.util

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object ResponseParam {

    fun success(): ResponseEntity<Param> {
        return ResponseEntity.status(HttpStatus.OK).body(Param().success())
    }

    fun success(data: Any): ResponseEntity<Param> {
        return ResponseEntity.status(HttpStatus.OK).body(Param().success(data))
    }

    fun fail(): ResponseEntity<Param> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Param().fail())
    }

    fun fail(data: Any): ResponseEntity<Param> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Param().fail(data))
    }

    fun of(isSuccess: Boolean): ResponseEntity<Param> {
        return if (isSuccess) success() else fail()
    }

    fun of(isSuccess: Boolean, data: Any): ResponseEntity<Param> {
        return if (isSuccess) success(data) else fail(data)
    }

}