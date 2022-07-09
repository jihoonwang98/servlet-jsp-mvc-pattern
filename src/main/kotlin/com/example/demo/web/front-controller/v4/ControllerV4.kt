package com.example.demo.web.`front-controller`.v4

interface ControllerV4 {
    fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String
}
