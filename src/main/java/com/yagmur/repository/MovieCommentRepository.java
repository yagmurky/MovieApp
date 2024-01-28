package com.yagmur.repository;

import com.yagmur.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {
}
