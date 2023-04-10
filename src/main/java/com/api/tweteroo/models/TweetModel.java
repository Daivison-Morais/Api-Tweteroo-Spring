package com.api.tweteroo.models;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.dto.TweetDTO2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class TweetModel {

    public TweetModel(TweetDTO2 req){
        this.username = req.username();
        this.tweet = req.tweet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 100, nullable = false)
    String username;


    @Column(length = 10000, nullable = false)
    String tweet;
}
