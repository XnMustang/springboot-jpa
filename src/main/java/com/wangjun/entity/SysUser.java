package com.wangjun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/11/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "sys_user",schema = "jpa")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * length:字段的长度，当字段的类型为varchar时，该属性才有效，默认为255个字符
     * unique:该字段是否为唯一标识，默认为false
     * nullable:该字段是否可以为null值，默认为true
     * name:定义了被标注字段在数据库中所对应字段的名称
     * updatable:在使用“UPDATE”脚本插入数据时，是否需要更新该字段的值
     */
    @Column(length = 18,unique = true,nullable = false,name = "username",updatable = true)
    @NotEmpty(message = "用户名不允许为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,16}$", message = "用户名需3到16位的英文,数字,唯一不可重复")
    private String username;

    @Column(length = 18,nullable = false)
    @NotEmpty(message = "用户昵称不允许为空")
    private String nickname;

    @Range(min = 0,max = 100,message = "年龄需要在0-100岁之间")
    private Integer userAge;

    @Column(length = 2)
    private String userSex;
}
