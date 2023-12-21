package com.example.springBoot.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="authority")
@Data
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String authorityName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;

}
