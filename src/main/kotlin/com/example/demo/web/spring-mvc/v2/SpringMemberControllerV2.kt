package com.example.demo.web.`spring-mvc`.v2

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/springmvc/v2/members")
class SpringMemberControllerV2 {

    @RequestMapping("/new-form")
    fun newForm(): ModelAndView {
        return ModelAndView("new-form")
    }

    @RequestMapping
    fun findAll(): ModelAndView {
        val members = MemberRepository.findAll()

        return ModelAndView("members", mapOf("members" to members))
    }

    @RequestMapping("/save")
    fun save(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val username = request.getParameter("username") ?: throw IllegalArgumentException("username not valid")
        val age = request.getParameter("age").toIntOrNull() ?: throw IllegalArgumentException("age not valid")
        val member = MemberRepository.save(Member(username, age))

        return ModelAndView("save", mapOf("member" to member))
    }

}
