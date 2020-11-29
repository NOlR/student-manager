package com.mqxu.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 班级实体类
 * @author: mqxu
 * @create: 2020-11-20 19:29
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;
    private Integer departmentId;
    private String className;

    @Override
    public String toString() {
        return className;
    }

}
