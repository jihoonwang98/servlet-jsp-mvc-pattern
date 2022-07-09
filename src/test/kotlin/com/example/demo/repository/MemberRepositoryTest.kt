package com.example.demo.repository

import com.example.demo.domain.Member
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MemberRepositoryTest {

    @AfterEach
    fun tearDown() {
        MemberRepository.clearStore()
    }

    @Test
    fun save() {
        val saved = MemberRepository.save(Member("mojo", 10))
        assertThat(MemberRepository.findAll()).containsExactly(saved)
    }

    @Test
    fun findById() {
        val member1 = MemberRepository.save(Member("member1", 10))
        val member2 = MemberRepository.save(Member("member2", 20))
        val member3 = MemberRepository.save(Member("member3", 30))
        val member4 = MemberRepository.save(Member("member4", 40))

        assertThat(MemberRepository.findById(member2.id!!)).isEqualTo(member2)
    }

    @Test
    fun `findById should return null when member not found`() {
        assertThat(MemberRepository.findById(1L)).isEqualTo(null)
    }

    @Test
    fun findAll() {
        val member1 = MemberRepository.save(Member("member1", 10))
        val member2 = MemberRepository.save(Member("member2", 20))
        val member3 = MemberRepository.save(Member("member3", 30))
        val member4 = MemberRepository.save(Member("member4", 40))

        assertThat(MemberRepository.findAll()).containsExactlyInAnyOrder(
            member1,
            member2,
            member3,
            member4
        )
    }

    @Test
    fun `findAll should return empty list when there are no members`() {
        assertThat(MemberRepository.findAll()).isEqualTo(emptyList<Member>())
    }

}
