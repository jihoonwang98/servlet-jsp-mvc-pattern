package com.example.demo.web.`servlet-mvc`

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = ["/servlet-mvc/members/new-form"])
class MvcMemberFormServlet: HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val viewPath = "/WEB-INF/view/new-form.jsp"
        req.getRequestDispatcher(viewPath).forward(req, resp)
    }
}
