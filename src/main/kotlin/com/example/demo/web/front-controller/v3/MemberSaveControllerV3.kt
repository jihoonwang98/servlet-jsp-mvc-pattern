package com.example.demo.web.`front-controller`.v3

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository

class MemberSaveControllerV3 : ControllerV3 {
    override fun process(paramMap: Map<String, String>): ModelView {
        val username = paramMap["username"] ?: throw IllegalArgumentException("invalid username")
        val age = paramMap["age"]?.toIntOrNull() ?: throw IllegalArgumentException("invalid age")

        val member = Member(username, age)
        MemberRepository.save(member)

        return ModelView(mapOf("member" to member), "save")
    }
}
