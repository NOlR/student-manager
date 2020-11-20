package com.mqxu.sm.dao;

import com.mqxu.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @description: 院系DAO接口
 * @author: mqxu
 * @create: 2020-11-17 20:42
 **/
public interface DepartmentDao {
    /**
     * 查询所有院系
     *
     * @return List<Department>
     * @throws SQLException 异常
     */
    List<Department> getAll() throws SQLException;

    /**
     * 删除院系
     *
     * @param depId 院系id
     * @return int
     * @throws SQLException 异常
     */
    int delete(int depId) throws SQLException;

    /**
     * 新增院系
     *
     * @param department 入参
     * @return int
     * @throws SQLException 异常
     */
    int insertDepartment(Department department) throws SQLException;
}
