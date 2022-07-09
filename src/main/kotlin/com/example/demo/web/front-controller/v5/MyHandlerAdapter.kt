package com.example.demo.web.`front-controller`.v5

import com.example.demo.web.`front-controller`.v3.ModelView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface MyHandlerAdapter {

    fun supports(handler: Any): Boolean

    fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView

    fun generateParamMap(request: HttpServletRequest): Map<String, String> {
        return request.parameterNames.asSequence().map {
            val parameterName = it
            val parameterValue = request.getParameter(parameterName)
            parameterName to parameterValue
        }.toMap()
    }
}
