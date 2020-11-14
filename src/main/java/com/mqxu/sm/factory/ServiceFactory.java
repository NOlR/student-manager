package com.mqxu.sm.factory;

import com.mqxu.sm.service.AdminService;
import com.mqxu.sm.service.impl.AdminServiceImpl;

/**
 * @description: Service工厂类
 * @author: mqxu
 * @create: 2020-11-14 20:20
 **/
public class ServiceFactory {
    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }
}
