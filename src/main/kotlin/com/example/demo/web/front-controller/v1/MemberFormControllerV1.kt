package com.example.demo.web.`front-controller`.v1

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV1: ControllerV1 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse) {
        val viewPath = "/WEB-INF/view/new-form.jsp"
        val dispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)
    }
}
