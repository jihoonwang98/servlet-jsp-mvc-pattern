package com.example.demo.web.`front-controller`.v1

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface ControllerV1 {
    fun process(request: HttpServletRequest, response: HttpServletResponse)
}
