package com.api.tweteroo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetDTO2(
        @NotNull @Size(min = 3, max = 100) String username,

        @NotNull @Size(min = 2, max = 12000) String tweet

) {

}
