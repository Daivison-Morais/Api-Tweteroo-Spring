package com.api.tweteroo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tweteroo.models.TweetModel;
import com.api.tweteroo.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long> {

    List<UserModel> findByUsername(String username);
   
}
