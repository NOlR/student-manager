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
     * @return List<CClass> 院系班级集合
     * @throws SQLException 异常
     */
    List<Clazz> selectByDepartmentId(int departmentId) throws SQLException;
}
