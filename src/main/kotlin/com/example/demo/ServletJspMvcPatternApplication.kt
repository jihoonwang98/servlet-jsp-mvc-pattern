package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan
@SpringBootApplication
class ServletJspMvcPatternApplication

fun main(args: Array<String>) {
    runApplication<ServletJspMvcPatternApplication>(*args)
}
