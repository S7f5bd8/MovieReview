package com.example.moviereview.repository;

import com.example.moviereview.entity.Member;
import com.example.moviereview.entity.Movie;
import com.example.moviereview.entity.Review;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository; // ReviewRepository 객체를 자동 주입

    @Test
    public void insertReview() {
        IntStream.rangeClosed(1, 200).forEach(i -> {
            // 임의의 영화번호
            Long mno = (long) (Math.random() * 100) + 1;
            // 임의의 회원번호
            Long mid = (long) (Math.random() * 100) + 1;

            Member member = Member.builder()
                    .mid(mid)
                    .build();

            Movie movie = Movie.builder()
                    .mno(mno)
                    .build();

            int grade = (int) (Math.random() * 5) + 1;

            Review review = Review.builder()
                    .member(member)
                    .movie(movie)
                    .grade(grade)
                    .text("영화 리뷰 텍스트 " + i)
                    .build();

            reviewRepository.save(review);
        });
    }
}
