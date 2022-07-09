package com.example.demo.web.`front-controller`.v2

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV2 : ControllerV2 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        return MyView("new-form")
    }
}
