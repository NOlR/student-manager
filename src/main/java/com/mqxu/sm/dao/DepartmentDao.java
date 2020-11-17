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
}
