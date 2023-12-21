package com.example.springBoot.departmentResponseBody;
import com.example.springBoot.model.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Getter
@Setter
@ResponseBody
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentResponseBody {
    private boolean success=true;
    private String message;
    private Object result;
    private List<Object> list;
}
