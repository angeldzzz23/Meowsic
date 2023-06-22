package com.meowsic.meows.repository;

import com.meowsic.meows.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NewsfeedRepository extends JpaRepository<Post, Long> {
}
