package com.mqxu.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 院系实体类
 * @author: mqxu
 * @create: 2020-11-17 20:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    private Integer id;
    private String departmentName;
    private String logo;

}
