package com.example.springBootMiniProject.dto;

import com.example.springBootMiniProject.entity.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String message;
    private boolean status;
    private Object response;
    private String error;
    private List<ApplicationUser> list;
    public List<ApplicationUser> getList() {
        return list;
    }
    public void setList(List<ApplicationUser> list) {
        this.list = list;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Object getResponse() {
        return response;
    }
    public void setResponse(Object response) {
        this.response = response;
    }
}
