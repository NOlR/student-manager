package com.mqxu.sm.service;

import com.mqxu.sm.factory.ServiceFactory;
import com.mqxu.sm.utils.ResultEntity;
import org.junit.Test;

public class AdminServiceTest {
    private final AdminService adminService = ServiceFactory.getAdminServiceInstance();

    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminService.adminLogin("taoranran@qq.com", "123123");
        System.out.println(resultEntity);
    }
}