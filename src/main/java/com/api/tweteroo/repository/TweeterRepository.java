package com.api.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tweteroo.models.TweetModel;

@Repository
public interface TweeterRepository extends JpaRepository<TweetModel, Long> {
    
}


