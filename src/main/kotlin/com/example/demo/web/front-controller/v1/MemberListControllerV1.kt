package com.example.demo.web.`front-controller`.v1

import com.example.demo.repository.MemberRepository
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberListControllerV1: ControllerV1 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse) {
        val viewPath = "/WEB-INF/view/members.jsp"

        val members = MemberRepository.findAll()
        request.setAttribute("members", members)

        request.getRequestDispatcher(viewPath).forward(request, response)
    }
}
