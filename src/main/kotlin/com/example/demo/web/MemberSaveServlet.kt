package com.example.demo.web

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberSaveServlet", urlPatterns = ["/servlet/members/save"])
class MemberSaveServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val username = req.getParameter("username") ?: throw IllegalArgumentException("username is null")
        val age = req.getParameter("age").toIntOrNull() ?: throw IllegalArgumentException("age is null")

        val member = Member(username, age)
        MemberRepository.save(member)

        resp.apply {
            contentType = "text/html"
            characterEncoding = "utf-8"
        }

        resp.writer.write("""
            <html>
            <head>
                <meta charset="UTF-8">
            </head>
            <body>
            성공
            <ul>
                <li>id=${member.id}</li>
                <li>username=${member.username}</li>
                <li>age=${member.age}</li>
            </ul>
            <a href="/index.html">메인</a>
            </body>
            </html>
        """.trimIndent())
    }
}
