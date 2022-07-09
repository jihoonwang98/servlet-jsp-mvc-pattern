package com.example.demo.web.`front-controller`.v4

import com.example.demo.web.`front-controller`.v2.MyView
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV4", urlPatterns = ["/front-controller/v4/*"])
class FrontControllerV4(private val controllerMap: MutableMap<String, ControllerV4>) : HttpServlet() {

    init {
        controllerMap["/front-controller/v4/members/new-form"] = MemberFormControllerV4()
        controllerMap["/front-controller/v4/members"] = MemberListControllerV4()
        controllerMap["/front-controller/v4/members/save"] = MemberSaveControllerV4()
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println("requestURI: ${req.requestURI}")

        val controller = controllerMap[req.requestURI] ?: run {
            resp.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val model = mutableMapOf<String, Any>()
        val viewName = controller.process(generateParamMap(req), model)
        val view = viewResolver(viewName)

        view.render(req, resp, model)
    }

    private fun generateParamMap(req: HttpServletRequest): Map<String, String> {
        return req.parameterNames.asSequence().map {
            val paramName = it
            val paramValue = req.getParameter(paramName)
            paramName to paramValue
        }.toMap()
    }

    private fun viewResolver(viewName: String): MyView {
        return MyView("/WEB-INF/view/${viewName}.jsp")
    }
}
