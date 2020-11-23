package com.mqxu.sm.service.impl;

import com.mqxu.sm.dao.StudentDao;
import com.mqxu.sm.factory.DaoFactory;
import com.mqxu.sm.service.StudentService;
import com.mqxu.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-11-23 16:20
 **/
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = DaoFactory.getStudentDaoInstance();

    @Override
    public List<StudentVo> selectAll() {
        List<StudentVo> list = null;
        try {
            list = studentDao.selectAll();
        } catch (SQLException throwables) {
            System.err.println("查询所有学生出现异常");
        }
        return list;
    }
}
