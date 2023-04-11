package com.api.tweteroo.service;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.models.TweetModel;
import com.api.tweteroo.models.UserModel;
import com.api.tweteroo.repository.TweeterRepository;
import com.api.tweteroo.repository.UserRepository;

@Service

public class TweeterService {

    @Autowired
    private TweeterRepository repositoryTweet;

    @Autowired
    private UserRepository repositoryUser;

    public TweeterService(TweeterRepository repositoryTweet) {
        this.repositoryTweet = repositoryTweet;
    }

    public Page<TweetDTO> findAll(Pageable pageable) {

        return (Page<TweetDTO>) repositoryTweet.findAllTweets(pageable);
    }

    public String createTweet(TweetModel tweet) {

        List<TweetModel> existUser = repositoryTweet.findByUsername(null);

        if (existUser.isEmpty()) {
            throw new Error("Usuário inexistente");

        }
        repositoryTweet.save(tweet);
        return "ok!";
    }

    public void createUser(UserModel user) {

        String username = user.getUsername();
        List<UserModel> existUser = repositoryUser.findByUsername(username);

        if (!existUser.isEmpty()) {
            throw new Error("Usuário já existente");
        }
        repositoryUser.save(user);
    }

    public List<TweetModel> findByUser(String userName) {
        return repositoryTweet.findByUsername(userName);
    }
}
