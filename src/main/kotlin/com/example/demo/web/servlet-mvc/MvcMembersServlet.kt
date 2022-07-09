package com.example.demo.web.`servlet-mvc`

import com.example.demo.repository.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMembersServlet", urlPatterns = ["/servlet-mvc/members"])
class MvcMembersServlet: HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val viewPath = "/WEB-INF/view/members.jsp"

        val members = MemberRepository.findAll()
        req.setAttribute("members", members)

        req.getRequestDispatcher(viewPath).forward(req, resp)
    }
}
