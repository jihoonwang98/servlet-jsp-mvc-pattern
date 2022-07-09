package com.example.demo.web.`front-controller`.v2

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface ControllerV2 {
    fun process(request: HttpServletRequest, response: HttpServletResponse): MyView
}
