package com.example.demo.web.`front-controller`.v2

import com.example.demo.repository.MemberRepository
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberListControllerV2 : ControllerV2 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        val members = MemberRepository.findAll()
        request.setAttribute("members", members)
        return MyView("/WEB-INF/view/members")
    }
}
