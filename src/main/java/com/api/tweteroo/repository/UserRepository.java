package com.api.tweteroo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tweteroo.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long> {

    @Query(value = "select u from UserModel u where u.username like %?1%")
    List<UserModel>  findByUsername(String userName);
   
}
