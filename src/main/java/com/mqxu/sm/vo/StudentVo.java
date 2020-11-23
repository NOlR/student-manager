package com.mqxu.sm.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: 学生视图对象类
 * @author: mqxu
 * @create: 2020-11-23 14:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVo {
    private String id;
    private String departmentName;
    private String className;
    private String studentName;
    private String phone;
    private Short gender;
    private Date birthday;
    private String avatar;
    private String address;
}
