package com.mqxu.sm.service;

import com.mqxu.sm.entity.Department;

import java.util.List;

/**
 * @description: DepartmentService
 * @author: mqxu
 * @create: 2020-11-17 20:56
 **/
public interface DepartmentService {
    /**
     * 查询所有院系
     *
     * @return List<Department>
     */
    List<Department> selectAll();
}
