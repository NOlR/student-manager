package com.mqxu.sm.service;

import com.mqxu.sm.entity.Department;
import com.mqxu.sm.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class DepartmentServiceTest {
    private final DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(System.out::println);
    }
}