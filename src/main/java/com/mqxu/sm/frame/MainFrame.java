package com.mqxu.sm.frame;

import com.mqxu.sm.component.CustomPanel;
import com.mqxu.sm.entity.Department;
import com.mqxu.sm.factory.ServiceFactory;
import com.mqxu.sm.utils.AliOSSUtil;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.util.List;


/**
 * @description:
 * @author: mqxu
 * @create: 2020-11-14 20:55
 **/
public class MainFrame extends JFrame {
    private String adminName;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel bottomPanel;
    private JPanel toolBarPanel;
    private JButton 新增院系Button;
    private JButton 切换显示Button;
    private JPanel addDepPanel;
    private JTextField depNameField;
    private JButton 选择图片Button;
    private JLabel logoLabel;
    private JPanel contentPanel;
    private JButton 新增Button;

    private final CardLayout c;

    private String uploadFileUrl;
    private File file;

    public MainFrame(String adminName) {
        this.adminName = adminName;
        init();
        院系管理Button.setOpaque(false);
        班级管理Button.setOpaque(false);
        学生管理Button.setOpaque(false);
        奖惩管理Button.setOpaque(false);
        c = new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1", departmentPanel);
        centerPanel.add("2", classPanel);
        centerPanel.add("3", studentPanel);
        centerPanel.add("4", rewardPanel);
        院系管理Button.addActionListener(e -> {
            c.show(centerPanel, "1");
        });
        班级管理Button.addActionListener(e -> {
            c.show(centerPanel, "2");
        });
        学生管理Button.addActionListener(e -> {
            c.show(centerPanel, "3");
        });
        奖惩管理Button.addActionListener(e -> {
            c.show(centerPanel, "4");
        });

        //左侧边栏切换效果
        新增院系Button.addActionListener(e -> {
            //获取左侧面板的可见性
            boolean visible = addDepPanel.isVisible();
            //不可见
            if (!visible) {
                //向右侧展开、背景色变化、可见
                leftPanel.setPreferredSize(new Dimension(200, this.getHeight() - 100));
                addDepPanel.setVisible(true);
            } else {
                //向左侧收起、背景色还原、不可见
                leftPanel.setPreferredSize(new Dimension(60, this.getHeight() - 100));
                addDepPanel.setVisible(false);
            }

            leftPanel.revalidate();
        });

        //院系名称文本框焦点监听
        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });

        选择图片Button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("/Users/mqxu/Pictures/"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if (result == JFileChooser.APPROVE_OPTION) {
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(150, 150));
                //图片强制缩放成和JLabel一样大小
                icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_DEFAULT));
                logoLabel.setIcon(icon);
            }
        });
        新增Button.addActionListener(e -> {
            //上传文件到OSS并返回url
            uploadFileUrl = AliOSSUtil.ossUpload(file);
            //创建Department对象，并设置相应属性
            Department department = new Department();
            department.setDepartmentName(depNameField.getText().trim());
            department.setLogo(uploadFileUrl);
            //调用service实现新增功能
            int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if (n == 1) {
                JOptionPane.showMessageDialog(centerPanel, "新增院系成功");
                //新增成功后，将侧边栏隐藏
                leftPanel.setPreferredSize(new Dimension(60, this.getHeight() - 100));
                addDepPanel.setVisible(false);
                //刷新界面数据
                showDepartments();
                //清空文本框
                depNameField.setText("");
                logoLabel.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(centerPanel, "新增院系失败");
            }
        });
    }

    public void init() {
        this.setTitle("管理员：" + this.adminName);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        showDepartments();
        showClazz();

    }

    private void showClazz() {
        Image image = new ImageIcon("./../../img/1.jpg").getImage();
        CustomPanel cp = new CustomPanel(image);
        cp.setPreferredSize(new Dimension(300, 200));
        cp.repaint();
        classPanel.add(cp);
        classPanel.revalidate();
        classPanel.add(new JButton("按钮"));
    }

    /**
     * 显示所有院系信息
     */
    private void showDepartments() {
        //移除原有数据
        contentPanel.removeAll();
        //从service层获取到所有院系列表
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len = departmentList.size();
        //根据院系总数算出行数（每行放4个）
        int row = len % 4 == 0 ? len / 4 : len / 4 + 1;
        //创建一个网格布局，每行4列，指定水平和垂直间距
        GridLayout gridLayout = new GridLayout(0, 4, 15, 15);
        contentPanel.setLayout(gridLayout);
        for (Department department : departmentList) {
            //给每个院系对象创建一个面板
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(220, 220));
            depPanel.setLayout(new BorderLayout());
            JLabel nameLabel = new JLabel(department.getDepartmentName());
            //新建一个JLabel标签，用来放置院系logo，并指定大小
            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "' mode='scaleToFill'/></html>");
            JLabel blankLabel = new JLabel();
            blankLabel.setPreferredSize(new Dimension(220, 40));
            //删除按钮
            JButton delBtn = new JButton("删除");
            delBtn.addActionListener(e -> {
                int result = JOptionPane.showConfirmDialog(this, "确认要删除吗？");
                if (result == 0) {
                    int n = ServiceFactory.getDepartmentServiceInstance().delete(department.getId());
                    if (n == 1) {
                        JOptionPane.showMessageDialog(this, "删除成功");
                        showDepartments();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "删除失败");
                }
            });
            //院系名称标签加入院系面板
            depPanel.add(nameLabel, BorderLayout.NORTH);
            //图标标签加入院系面板
            depPanel.add(logoLabel, BorderLayout.CENTER);
            //按钮加入院系面板
            depPanel.add(delBtn, BorderLayout.SOUTH);
            //院系面板加入主体内容面板
            contentPanel.add(depPanel);
            //刷新主体内容面板
            contentPanel.revalidate();
        }
    }


    public static void main(String[] args) {
        new MainFrame("陶然然");
    }
}
