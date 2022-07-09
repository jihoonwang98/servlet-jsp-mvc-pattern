package com.example.demo.web.`front-controller`.v3

class MemberFormControllerV3 : ControllerV3 {
    override fun process(requestParams: Map<String, String>): ModelView {
        return ModelView(emptyMap(),"new-form")
    }
}
