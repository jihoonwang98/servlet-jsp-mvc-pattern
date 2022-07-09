package com.example.demo.web

import com.example.demo.repository.MemberRepository
import java.io.PrintWriter
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberListServlet", urlPatterns = ["/servlet/members"])
class MemberListServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.apply {
            contentType = "text/html"
            characterEncoding = "utf-8"
        }

        resp.writer.run {
            write("""
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                <a href="/index.html">메인</a>
                <table>
                    <thead>
                    <th>id</th>
                    <th>username</th>
                    <th>age</th>
                    </thead>
                    <tbody>
            """.trimIndent())

            writeAllMembers()

            write("""
                    </tbody>
                </table>
                </body>
                </html>
            """.trimIndent())
        }
    }

    private fun PrintWriter.writeAllMembers() {
        val members = MemberRepository.findAll()

        for (member in members) {
            write("""
                <tr>
                    <td>${member.id}</td>
                    <td>${member.username}</td>
                    <td>${member.age}</td>
                </tr>
            """.trimIndent())
        }
    }
}
