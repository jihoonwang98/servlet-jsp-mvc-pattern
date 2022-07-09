package com.example.demo.web.`front-controller`.v4

class MemberFormControllerV4 : ControllerV4 {
    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {
        return "new-form"
    }

}
