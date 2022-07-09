package com.example.demo.web.`front-controller`.v4

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository

class MemberSaveControllerV4 : ControllerV4 {
    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {
        val username = paramMap["username"] ?: throw IllegalArgumentException("invalid username")
        val age = paramMap["age"]?.toIntOrNull() ?: throw IllegalArgumentException("invalid age")

        val member = Member(username, age)
        MemberRepository.save(member)
        model["member"] = member

        return "save"
    }

}
