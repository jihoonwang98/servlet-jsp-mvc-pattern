package com.example.demo.web.`front-controller`.v2

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MyView(
    val path: String,
) {
    private val prefix = "/WEB-INF/view/"
    private val postfix = ".jsp"

    fun render(request: HttpServletRequest, response: HttpServletResponse) {
        val dispatcher = request.getRequestDispatcher("${prefix}${path}${postfix}")
        dispatcher.forward(request, response)
    }
}
