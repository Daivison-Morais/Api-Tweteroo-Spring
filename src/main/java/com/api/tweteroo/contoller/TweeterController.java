package com.api.tweteroo.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.dto.UserDTO;
import com.api.tweteroo.models.TweetModel;
import com.api.tweteroo.models.UserModel;
import com.api.tweteroo.repository.UserRepository;
import com.api.tweteroo.service.TweeterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tweteroo")
public class TweeterController {

    @Autowired
    private TweeterService service;

   
    @Autowired
	private UserRepository repositoryUser;


    @GetMapping
    public List<TweetModel> getAll() {
        return service.findAll();
    }

    @GetMapping("/{userName}")
    public List<UserModel> getByUser(@PathVariable String userName) {
        return repositoryUser.findByUsername(userName);
    } 

    @PostMapping
    public void createTweete(@RequestBody @Valid TweetDTO req) {
        service.createTweete(new TweetModel(req));
    }

    @PostMapping
    public void createUser(@RequestBody @Valid UserDTO req) {
        service.createUser(new UserModel(req));
    }

}
