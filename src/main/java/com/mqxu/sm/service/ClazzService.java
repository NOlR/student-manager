package com.mqxu.sm.service;

import com.mqxu.sm.entity.Clazz;
import com.mqxu.sm.entity.Department;

import java.util.List;

/**
 * @description: 班级service
 * @author: mqxu
 * @create: 2020-11-20 19:47
 **/
public interface ClazzService {
    /**
     * 根据院系id查询班级列表
     *
     * @param depId 院系id
     * @return 班级列表
     */
    List<Clazz> getClazzByDepId(int depId);

    /**
     * 新增班级
     *
     * @param clazz 班级实体
     * @return int
     */
    int addClazz(Clazz clazz);

    /**
     * 删除班级
     * @param clazzId 班级id
     * @return int
     */
    int deleteClazz(int clazzId);
}
