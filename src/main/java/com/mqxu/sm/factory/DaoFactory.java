package com.mqxu.sm.factory;

import com.mqxu.sm.dao.AdminDao;
import com.mqxu.sm.dao.impl.AdminDaoImpl;

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
}
