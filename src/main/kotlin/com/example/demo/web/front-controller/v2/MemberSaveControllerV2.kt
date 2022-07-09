package com.example.demo.web.`front-controller`.v2

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV2 : ControllerV2 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        val username = request.getParameter("username") ?: throw IllegalArgumentException("username not valid")
        val age = request.getParameter("age").toIntOrNull() ?: throw IllegalArgumentException("age not valid")

        val member = MemberRepository.save(Member(username, age))
        request.setAttribute("member", member)

        return MyView("save")

    }

}
