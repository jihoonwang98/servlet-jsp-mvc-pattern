package com.example.demo.web.`spring-mvc`.v1

import com.example.demo.repository.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SpringMemberListControllerV1 {

    @RequestMapping("/springmvc/v1/members")
    fun process(): ModelAndView {
        val members = MemberRepository.findAll()

        return ModelAndView("members", mapOf("members" to members))
    }
}
