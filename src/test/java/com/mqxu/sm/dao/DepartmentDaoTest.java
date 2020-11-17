package com.mqxu.sm.dao;

import com.mqxu.sm.entity.Department;
import com.mqxu.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoTest {

    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    @Test
    public void getAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert departmentList != null;
        departmentList.forEach(System.out::println);
    }
}