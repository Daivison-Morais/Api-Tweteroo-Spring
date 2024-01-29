package com.api.tweteroo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TweetDTO2(
        @NotBlank 
        @Size(min = 3, max = 100) 
        String username,

        @NotBlank 
        @Size(min = 2, max = 12000) 
        String tweet

) {

}
