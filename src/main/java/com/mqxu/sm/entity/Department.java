package com.mqxu.sm.entity;

import lombok.*;

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

    @Override
    public String toString() {
        return this.departmentName;
    }
}
