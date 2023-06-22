package com.meowsic.meows.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
    private Long id;

    @NotEmpty
    private String spot_id;

    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

}
