package com.example.moviereview.repository;

import com.example.moviereview.entity.Member;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .email("r"+i + "@kopo.ac.kr")
                    .pw("1234")
                    .nickname("reviewer" + i)
                    .build();
            memberRepository.save(member);
        });
    }
}
