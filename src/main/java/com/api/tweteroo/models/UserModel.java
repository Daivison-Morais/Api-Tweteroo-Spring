package com.api.tweteroo.models;

import com.api.tweteroo.dto.UserDTO;

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

public class UserModel {

    public UserModel(UserDTO req){
        this.username = req.username();
        this.avatar = req.avatar();
    } 

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 3000, nullable = false)
    private String avatar;
    
}
