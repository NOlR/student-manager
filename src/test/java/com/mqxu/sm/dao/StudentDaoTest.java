package com.mqxu.sm.dao;

import com.mqxu.sm.entity.Student;
import com.mqxu.sm.factory.DaoFactory;
import com.mqxu.sm.vo.StudentVo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentDaoTest {

    private final StudentDao studentDao = DaoFactory.getStudentDaoInstance();

    @Test
    public void selectAll() throws SQLException {
        List<StudentVo> list = studentDao.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void selectByDepId() throws SQLException {
        List<StudentVo> list = studentDao.selectByDepId(5);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByClassId() throws SQLException {
        List<StudentVo> list = studentDao.selectByClassId(18);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByKeywords() throws SQLException {
        List<StudentVo> list = studentDao.selectByKeywords("田");
        list.forEach(System.out::println);
    }

    @Test
    public void updateStudent() throws SQLException {
        Student student = new Student();
        student.setId("1");
        student.setAddress("浙江温州");
        student.setPhone("13100001111");
        int n = studentDao.updateStudent(student);
        assertEquals(1, n);
    }

    @Test
    public void deleteById() throws SQLException {
        int n = studentDao.deleteById("15");
        assertEquals(1, n);
    }

    @Test
    public void insert() throws SQLException {
        Student student = new Student();
        student.setId("16");
        student.setClassId(18);
        student.setStudentName("嘉弈");
        student.setAvatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/1.jpg");
        student.setBirthday(new Date());
        student.setGender((short) 1);
        student.setPhone("13899991111");
        student.setAddress("四川成都");
        int n = studentDao.insertStudent(student);
        assertEquals(1, n);
    }

    @Test
    public void countByDepartmentId() {
        try {
            System.out.println(studentDao.countByDepartmentId(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void countByClassId() {
        try {
            System.out.println(studentDao.countByClassId(16));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}