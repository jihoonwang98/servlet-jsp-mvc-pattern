package com.example.demo.web.`front-controller`.v3

import com.example.demo.web.`front-controller`.v2.MyView
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV3", urlPatterns = ["/front-controller/v3/*"])
class FrontControllerV3(private val controllerMap: MutableMap<String, ControllerV3>) : HttpServlet() {

    init {
        controllerMap["/front-controller/v3/members/new-form"] = MemberFormControllerV3()
        controllerMap["/front-controller/v3/members"] = MemberListControllerV3()
        controllerMap["/front-controller/v3/members/save"] = MemberSaveControllerV3()
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println("requestURI: ${req.requestURI}")
        println("req.parameterMap: ${req.parameterMap}")

        val controller = controllerMap[req.requestURI] ?: run {
            resp.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val modelView = controller.process(generateParamMap(req))
        val view = viewResolver(modelView.viewName)

        view.render(req, resp, modelView.model)
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
