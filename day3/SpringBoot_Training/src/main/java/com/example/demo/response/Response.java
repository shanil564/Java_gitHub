package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseBody
@Getter
@Setter
public class Response {
    private boolean success=true;
    private String message;
    private Object result;
    private List<Object> list;
}
