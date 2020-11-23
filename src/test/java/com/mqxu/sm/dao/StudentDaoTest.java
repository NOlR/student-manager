package com.mqxu.sm.dao;

import com.mqxu.sm.factory.DaoFactory;
import com.mqxu.sm.vo.StudentVo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoTest {

    @Test
    public void selectAll() throws SQLException {
        List<StudentVo> list = DaoFactory.getStudentDaoInstance().selectAll();
        list.forEach(System.out::println);
    }
}