package com.hansoleee.submitformjs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void create() throws Exception {
        Member member = memberRepository.save(new Member("lhs", 25));

        assertThat(member.getName()).isEqualTo("lhs");
        assertThat(member.getAge()).isEqualTo(25);
    }

}