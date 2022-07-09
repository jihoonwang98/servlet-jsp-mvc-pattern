package com.example.demo.web.`front-controller`.v4

import com.example.demo.repository.MemberRepository

class MemberListControllerV4 : ControllerV4 {
    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {
        val members = MemberRepository.findAll()
        model["members"] = members
        return "members"
    }

}
