package com.mqxu.sm.service;

import com.mqxu.sm.entity.Department;
import com.mqxu.sm.utils.ResultEntity;

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

    /**
     * 删除院系
     *
     * @param depId 院系id
     * @return ResultEntity
     */
    int delete(int depId);

    /**
     * 新增院系
     *
     * @param department 入参
     * @return int
     */
    int addDepartment(Department department);
}
