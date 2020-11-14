package com.mqxu.sm.service;

import com.mqxu.sm.utils.ResultEntity;

/**
 * @description: Admin业务逻辑接口
 * @author: mqxu
 * @create: 2020-11-14 20:08
 **/
public interface AdminService {
    /**
     * 管理员登录
     *
     * @param account     :账号
     * @param password：密码
     * @return ResultEntity：返回结果
     */
    ResultEntity adminLogin(String account, String password);
}
