package com.example.demo.web.`front-controller`.v2

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV2", urlPatterns = ["/front-controller/v2/*"])
class FrontControllerV2(private val controllerMap: MutableMap<String, ControllerV2>) : HttpServlet() {

    init {
        controllerMap["/front-controller/v2/members/new-form"] = MemberFormControllerV2()
        controllerMap["/front-controller/v2/members"] = MemberListControllerV2()
        controllerMap["/front-controller/v2/members/save"] = MemberSaveControllerV2()
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println("requestURI: ${req.requestURI}")

        val controller = controllerMap[req.requestURI] ?: run {
            resp.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val view = controller.process(req, resp)
        view.render(req, resp)
    }
}
