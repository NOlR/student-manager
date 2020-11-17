package com.mqxu.sm.factory;

import com.mqxu.sm.dao.AdminDao;
import com.mqxu.sm.dao.DepartmentDao;
import com.mqxu.sm.dao.impl.AdminDaoImpl;
import com.mqxu.sm.dao.impl.DepartmentDaoImpl;

/**
 * @description: 工厂类
 * @author: mqxu
 * @create: 2020-11-14 19:57
 **/
public class DaoFactory {
    /**
     * 获得AdminDao实例
     *
     * @return AdminDao实例
     */
    public static AdminDao getAdminDaoInstance() {
        return new AdminDaoImpl();
    }

    /**
     * 获得DepartmentDao实例
     *
     * @return AdminDao实例
     */
    public static DepartmentDao getDepartmentDaoInstance() {
        return new DepartmentDaoImpl();
    }
}
