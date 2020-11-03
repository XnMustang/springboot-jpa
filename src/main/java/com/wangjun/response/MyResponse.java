package com.wangjun.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

/**
 * @Description: RESTful api接口，统一消息返回类
 * @Author : 王俊
 * @date :  2020/11/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyResponse implements Serializable {

    private static final long SerialVersionUID = -2L;
    private String status;
    private String message;

}
