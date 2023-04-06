package com.api.tweteroo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

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

    public List<TweetModel> findAll(){
        return repositoryTweet.findAll();
    }

    public void createTweete(TweetModel tweet){
        repositoryTweet.save(tweet);
    }
    public void createUser(UserModel user){
        repositoryUser.save(user);
    }

    public List<UserModel>  findByUser(String userName) {
        return repositoryUser.findByUsername( userName);
    }
}
