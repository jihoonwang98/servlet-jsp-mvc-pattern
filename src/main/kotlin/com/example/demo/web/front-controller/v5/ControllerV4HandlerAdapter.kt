package com.example.demo.web.`front-controller`.v5

import com.example.demo.web.`front-controller`.v3.ModelView
import com.example.demo.web.`front-controller`.v4.ControllerV4
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV4HandlerAdapter : MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return handler is ControllerV4
    }

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV4
        val model = mutableMapOf<String, Any>()
        val viewName = controller.process(generateParamMap(request), model)

        return ModelView(model, viewName)
    }
}
