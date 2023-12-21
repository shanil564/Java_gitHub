package com.example.springBoot.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String roleName;
    @JsonManagedReference    //specifies that we need to fetch authority  details while fetching a role
    @OneToMany(targetEntity = Authority.class, mappedBy = "role",fetch = FetchType.EAGER, cascade = CascadeType.ALL) //remember to use fetchType.eager to load collection
    private List<Authority> authorityList;

}
