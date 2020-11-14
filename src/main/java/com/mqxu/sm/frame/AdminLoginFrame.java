package com.mqxu.sm.frame;

import com.mqxu.sm.factory.ServiceFactory;
import com.mqxu.sm.utils.ResultEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-11-14 20:30
 **/
public class AdminLoginFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton resetBtn;

    public AdminLoginFrame() {
        this.setTitle("AdminLoginFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        loginBtn.addActionListener(e -> {
            //获得输入的账号和密码，注意密码框组件的使用方法
            String account = accountField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
            JOptionPane.showMessageDialog(mainPanel, resultEntity.getMessage());
            if (resultEntity.getCode() == 0) {
                //关闭登录界面，进入主界面
                this.dispose();
                new MainFrame();
            } else {
                accountField.setText("");
                passwordField.setText("");
            }
        });

        resetBtn.addActionListener(e -> {
            accountField.setText("");
            passwordField.setText("");
        });
    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}
