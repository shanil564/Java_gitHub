package com.example.demo.entity;


import com.example.demo.Constants;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name=Constants.AUTHORITY)
@Data
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String authorityName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = Constants.ROLE_ID,nullable = false)
    private Role role;

}
