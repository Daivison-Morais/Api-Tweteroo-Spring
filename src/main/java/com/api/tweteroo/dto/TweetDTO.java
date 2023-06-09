package com.api.tweteroo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetDTO(

        @NotNull @Size(min = 3, max = 100) String username,

        @NotNull @Size(min = 2, max = 10000) String avatar,

        @NotNull @Size(min = 2, max = 12000) String tweet) {

}
