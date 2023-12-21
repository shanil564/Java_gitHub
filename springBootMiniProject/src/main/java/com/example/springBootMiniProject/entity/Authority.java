package com.example.springBootMiniProject.entity;
import com.example.springBootMiniProject.Constants;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAuthorityName() {
        return authorityName;
    }
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
