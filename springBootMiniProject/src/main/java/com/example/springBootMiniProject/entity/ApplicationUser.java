package com.example.springBootMiniProject.entity;
import com.example.springBootMiniProject.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column (unique = true)// nullable = false
    private String userName;
    //@Column (nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.DETACH) // if we use CascadeType.ALL then we cannot create an object with role object passed to it
    @JoinColumn(name = Constants.ROLE_ID)
    @JsonIgnoreProperties(Constants.AUTHORITY_LIST)
    private Role role;
    @OneToMany(mappedBy = Constants.APPLICATION_USER)
    @JsonIgnoreProperties({Constants.APPLICATION_USER})
    private List<BookBorrow> bookBorrowList;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public List<BookBorrow> getBookBorrowList() {
        return bookBorrowList;
    }
    public void setBookBorrowList(List<BookBorrow> bookBorrowList) {
        this.bookBorrowList = bookBorrowList;
    }
}
