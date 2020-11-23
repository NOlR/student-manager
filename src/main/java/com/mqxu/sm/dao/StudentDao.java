package com.mqxu.sm.dao;

import com.mqxu.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @description: 学生Dao接口
 * @author: mqxu
 * @create: 2020-11-23 14:57
 **/
public interface StudentDao {
    /**
     * 查询所有学生（视图对象）
     *
     * @return 学生视图列表数据
     * @throws SQLException 异常
     */
    List<StudentVo> selectAll() throws SQLException;
}
