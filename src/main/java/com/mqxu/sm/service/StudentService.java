package com.mqxu.sm.service;

import com.mqxu.sm.vo.StudentVo;

import java.util.List;

/**
 * @description: 学生服务接口
 * @author: mqxu
 * @create: 2020-11-23 16:19
 **/
public interface StudentService {
    /**
     * 查询所以学生
     * @return list
     */
    List<StudentVo> selectAll();
}
