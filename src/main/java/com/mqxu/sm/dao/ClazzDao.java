package com.mqxu.sm.dao;

import com.mqxu.sm.entity.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @description: 班级dao接口
 * @author: mqxu
 * @create: 2020-11-20 19:31
 **/
public interface ClazzDao {
    /**
     * 按照院系id查询班级
     *
     * @param departmentId 院系id
     * @return List<Clazz> 院系班级集合
     * @throws SQLException 异常
     */
    List<Clazz> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 查询所有班级
     *
     * @return List<Clazz>
     * @throws SQLException 异常
     */
    List<Clazz> selectAll() throws SQLException;

    /**
     * 新增班级
     *
     * @param clazz 入参班级实体
     * @return int
     * @throws SQLException 异常
     */
    int insertClazz(Clazz clazz) throws SQLException;

    /**
     * 删除班级
     *
     * @param clazzId 班级id
     * @return int
     * @throws SQLException 异常
     */
    int deleteClazz(int clazzId) throws SQLException;
}
