package com.example.demo.web.`front-controller`.v3

interface ControllerV3 {
    fun process(paramMap: Map<String, String>): ModelView
}
