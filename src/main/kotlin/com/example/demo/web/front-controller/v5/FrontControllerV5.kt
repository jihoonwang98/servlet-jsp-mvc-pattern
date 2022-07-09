package com.example.demo.web.`front-controller`.v5

import com.example.demo.web.`front-controller`.v2.MyView
import com.example.demo.web.`front-controller`.v3.MemberFormControllerV3
import com.example.demo.web.`front-controller`.v3.MemberListControllerV3
import com.example.demo.web.`front-controller`.v3.MemberSaveControllerV3
import com.example.demo.web.`front-controller`.v4.MemberFormControllerV4
import com.example.demo.web.`front-controller`.v4.MemberListControllerV4
import com.example.demo.web.`front-controller`.v4.MemberSaveControllerV4
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV5", urlPatterns = ["/front-controller/v5/*"])
class FrontControllerV5(
    private val handlerMappingMap: MutableMap<String, Any> = mutableMapOf(),
    private val handlerAdapters: MutableList<MyHandlerAdapter> = mutableListOf(),
) : HttpServlet() {

    init {
        handlerMappingMap["/front-controller/v5/v3/members/new-form"] = MemberFormControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members"] = MemberListControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members/save"] = MemberSaveControllerV3()
        handlerMappingMap["/front-controller/v5/v4/members/new-form"] = MemberFormControllerV4()
        handlerMappingMap["/front-controller/v5/v4/members"] = MemberListControllerV4()
        handlerMappingMap["/front-controller/v5/v4/members/save"] = MemberSaveControllerV4()

        handlerAdapters += ControllerV3HandlerAdapter()
        handlerAdapters += ControllerV4HandlerAdapter()
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println("requestURI: ${req.requestURI}")

        val handler = handlerMappingMap[req.requestURI] ?: run {
            resp.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val handlerAdapter = handlerAdapters.firstOrNull { it.supports(handler) } ?: throw IllegalStateException("there is no handlerAdapter")
        val modelView = handlerAdapter.handle(req, resp, handler)

        val view = viewResolver(modelView.viewName)
        view.render(req, resp, modelView.model)
    }

    private fun viewResolver(viewName: String): MyView {
        return MyView("/WEB-INF/view/${viewName}.jsp")
    }
}
