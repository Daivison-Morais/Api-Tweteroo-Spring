package com.api.tweteroo.contoller;

import java.util.List;

import javax.print.DocFlavor.READER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.dto.TweetDTO2;
import com.api.tweteroo.dto.UserDTO;
import com.api.tweteroo.models.TweetModel;
import com.api.tweteroo.models.UserModel;
import com.api.tweteroo.service.TweeterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TweeterController {

    @Autowired
    private TweeterService service;

    @GetMapping("/tweets")
    public List<TweetDTO> getAll(@RequestParam("page") int page) {

        Pageable pageable = PageRequest.of(page, 5);

        System.out.println(pageable);

        return service.findAll(pageable).getContent();
    }

    @GetMapping("/tweet/{userName}")
    public List<TweetModel> getByUser(@PathVariable String userName) {
        return service.findByUser(userName);
    }

    @PostMapping("/tweets")
    public void createTweet(@RequestBody @Valid TweetDTO2 req) {

        service.createTweet(new TweetModel(req));

    }

    @PostMapping("/auth/sign-up")
    public void createUser(@RequestBody @Valid UserDTO req) {

        service.createUser(new UserModel(req));
        ResponseEntity.ok("OK");
    }

    // , @RequestHeader("username") String reqt

}
