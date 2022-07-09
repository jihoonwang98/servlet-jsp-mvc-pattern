package com.example.demo.web.`front-controller`.v5

import com.example.demo.web.`front-controller`.v3.ControllerV3
import com.example.demo.web.`front-controller`.v3.ModelView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV3HandlerAdapter: MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return handler is ControllerV3
    }

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV3
        return controller.process(generateParamMap(request))
    }
}
