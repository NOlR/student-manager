package com.mqxu.sm.service.impl;

import com.mqxu.sm.dao.DepartmentDao;
import com.mqxu.sm.entity.Department;
import com.mqxu.sm.factory.DaoFactory;
import com.mqxu.sm.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @description: DepartmentServiceImpl
 * @author: mqxu
 * @create: 2020-11-17 20:57
 **/
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDao.getAll();
        } catch (SQLException e) {
            System.err.print("查询院系信息出现异常");
        }
        return departmentList;
    }
}
