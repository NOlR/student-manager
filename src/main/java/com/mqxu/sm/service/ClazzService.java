package com.mqxu.sm.service;

import com.mqxu.sm.entity.Clazz;

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
}
