package com.meowsic.meows.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "posts"
)
public class Post {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "spot_id", nullable = false)
    private String spot_id;

    @Column(name = "description", nullable = true)
    private String description;
}
