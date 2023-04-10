package com.api.tweteroo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.models.TweetModel;

@Repository
public interface TweeterRepository
        extends PagingAndSortingRepository<TweetModel, Long>, JpaRepository<TweetModel, Long> {

    List<TweetModel> findByUsername(String userName);

    @Query(value = "SELECT new com.api.tweteroo.dto.TweetDTO(t.username, u.avatar, t.tweet) FROM TweetModel t JOIN UserModel u")
    Page<TweetDTO> findAllTweets(Pageable pageable);

}
