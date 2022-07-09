package com.example.demo.web.`servlet-mvc`

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = ["/servlet-mvc/members/save"])
class MvcMemberSaveServlet: HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val viewPath = "/WEB-INF/view/save.jsp"

        val username = req.getParameter("username") ?: throw IllegalArgumentException("username not valid")
        val age = req.getParameter("age").toIntOrNull() ?: throw IllegalArgumentException("age not valid")
        val member = MemberRepository.save(Member(username, age))

        req.setAttribute("member", member)

        req.getRequestDispatcher(viewPath).forward(req, resp)
    }
}
