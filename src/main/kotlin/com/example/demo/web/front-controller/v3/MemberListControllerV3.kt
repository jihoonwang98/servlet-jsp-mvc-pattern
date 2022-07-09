package com.example.demo.web.`front-controller`.v3

import com.example.demo.repository.MemberRepository

class MemberListControllerV3 : ControllerV3 {
    override fun process(requestParams: Map<String, String>): ModelView {
        val members = MemberRepository.findAll()
        val model = mapOf<String, Any>("members" to members)
        return ModelView(model, "members")
    }

}
