package com.mqxu.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Admin实体类
 * @author: mqxu
 * @create: 2020-11-14 19:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    private Integer id;
    private String account;
    private String password;
    private String adminName;

}
