package com.api.tweteroo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
    @NotNull @Size(min = 3, max = 100) String username,

        @NotNull @Size(min = 6, max = 10000) String avatar

) {
    
}
