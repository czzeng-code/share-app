package com.soft1851.course.center.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description TODO
 * @author smart-attendance
 * @Date 2020/4/21
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;


    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}