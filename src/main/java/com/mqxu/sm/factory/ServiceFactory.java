package com.mqxu.sm.factory;

import com.mqxu.sm.service.AdminService;
import com.mqxu.sm.service.ClazzService;
import com.mqxu.sm.service.DepartmentService;
import com.mqxu.sm.service.impl.AdminServiceImpl;
import com.mqxu.sm.service.impl.ClazzServiceImpl;
import com.mqxu.sm.service.impl.DepartmentServiceImpl;

/**
 * @description: Service工厂类
 * @author: mqxu
 * @create: 2020-11-14 20:20
 **/
public class ServiceFactory {
    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }

    public static DepartmentService getDepartmentServiceInstance() {
        return new DepartmentServiceImpl();
    }

    public static ClazzService getClazzServiceInstance() {
        return new ClazzServiceImpl();
    }
}
