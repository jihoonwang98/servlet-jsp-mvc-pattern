package com.example.demo.web.`front-controller`.v1

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV1", urlPatterns = ["/front-controller/v1/*"])
class FrontControllerV1(private val controllerMap: MutableMap<String, ControllerV1>) : HttpServlet() {

    init {
        controllerMap["/front-controller/v1/members/new-form"] = MemberFormControllerV1()
        controllerMap["/front-controller/v1/members"] = MemberListControllerV1()
        controllerMap["/front-controller/v1/members/save"] = MemberSaveControllerV1()
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println("requestURI: ${req.requestURI}")

        val controller = controllerMap[req.requestURI]

        controller?.process(req, resp) ?: run {
            resp.status = HttpServletResponse.SC_NOT_FOUND
        }
    }
}
