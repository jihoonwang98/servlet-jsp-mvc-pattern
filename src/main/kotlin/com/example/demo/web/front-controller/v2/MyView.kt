package com.example.demo.web.`front-controller`.v2

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MyView(
    val path: String,
) {

    fun render(request: HttpServletRequest, response: HttpServletResponse, model: Map<String, Any>? = null) {
        val dispatcher = request.getRequestDispatcher(path)

        model?.forEach { (key, value) -> request.setAttribute(key, value) }

        dispatcher.forward(request, response)
    }
}
