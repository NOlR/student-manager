package com.mqxu.sm.service.impl;

import com.mqxu.sm.dao.DepartmentDao;
import com.mqxu.sm.entity.Department;
import com.mqxu.sm.factory.DaoFactory;
import com.mqxu.sm.service.DepartmentService;
import com.mqxu.sm.utils.ResultEntity;

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

    @Override
    public int delete(int depId) {
        int n = 0;
        try {
            n = departmentDao.delete(depId);
        } catch (SQLException e) {
            System.err.print("删除院系信息出现异常");
        }
        return n;
    }

    @Override
    public int addDepartment(Department department) {
        int n = 0;
        try {
            n = departmentDao.insertDepartment(department);
        } catch (SQLException e) {
            System.err.print("新增院系信息出现异常");
        }
        return n;
    }
}
