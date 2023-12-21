package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column (unique = true, nullable = false)
    private String userName;
    @Column (nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.DETACH) // if we use CascadeType.ALL then we cannot create an object with role object passed to it
    @JoinColumn(name = "role_id")
    private Role role;
}
