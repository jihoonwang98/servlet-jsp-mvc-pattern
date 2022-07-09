package com.example.demo.web.`spring-mvc`.v3

import com.example.demo.domain.Member
import com.example.demo.repository.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/springmvc/v3/members")
class SpringMemberControllerV3 {

    @GetMapping("/new-form")
    fun newForm(): String {
        return "new-form"
    }

    @PostMapping("/save")
    fun saveMember(dto: SaveMemberDto, model: Model): String {
        val (username, age) = dto
        val member = MemberRepository.save(Member(username, age))

        model["member"] = member
        return "save"
    }

    @GetMapping
    fun members(model: Model): String {
        val members = MemberRepository.findAll()
        model["members"] = members
        return  "members"
    }
}


data class SaveMemberDto(
    val username: String,
    val age: Int,
)
