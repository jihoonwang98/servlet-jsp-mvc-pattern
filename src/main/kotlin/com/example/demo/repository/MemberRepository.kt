package com.example.demo.repository

import com.example.demo.domain.Member

object MemberRepository {
    private val store = HashMap<Long, Member>()
    private var sequence = 0L

    fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id!!] = member
        return member
    }

    fun findById(id: Long): Member? {
        return store[id]
    }

    fun findAll(): List<Member> {
        return store.values.toList()
    }

    fun clearStore() {
        store.clear()
    }
}
