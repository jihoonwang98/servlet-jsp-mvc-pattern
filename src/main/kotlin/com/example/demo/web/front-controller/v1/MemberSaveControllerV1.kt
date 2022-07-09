package com.example.demo.web.`front-controller`.v1

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV1: ControllerV1 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse) {
        val viewPath = "/WEB-INF/view/save.jsp"

        val username = request.getParameter("username") ?: throw IllegalArgumentException("username not valid")
        val age = request.getParameter("age").toIntOrNull() ?: throw IllegalArgumentException("age not valid")
        val member = MemberRepository.save(Member(username, age))

        request.setAttribute("member", member)

        request.getRequestDispatcher(viewPath).forward(request, response)
    }
}
