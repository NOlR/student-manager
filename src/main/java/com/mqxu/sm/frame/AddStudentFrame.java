package com.mqxu.sm.frame;


import com.eltima.components.ui.DatePicker;
import com.mqxu.sm.component.ImgPanel;
import com.mqxu.sm.entity.Clazz;
import com.mqxu.sm.entity.Student;
import com.mqxu.sm.factory.ServiceFactory;
import com.mqxu.sm.utils.AliOSSUtil;
import com.mqxu.sm.utils.FormatUtil;
import com.mqxu.sm.vo.StudentVo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-11-29
 **/
public class AddStudentFrame extends JFrame {
    private ImgPanel rootPanel;
    private JTextField idField;
    private JTextField nameField;
    private JComboBox<Clazz> classComboBox;
    private JRadioButton 男RadioButton;
    private JRadioButton 女RadioButton;
    private JPanel datePanel;
    private JButton 新增Button;
    private JLabel avatarLabel;
    private JLabel closeLabel;
    private JTextField addressField;
    private JTextField phoneField;
    private String uploadFileUrl;
    private int classId;
    private File file;
    private final MainFrame mainFrame;

    public AddStudentFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setContentPane(rootPanel);
        rootPanel.setFileName("student.jpg");
        rootPanel.repaint();
        setUndecorated(true);
        setTitle("新增学生界面");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //班级选择
        Clazz tip = new Clazz();
        tip.setClassName("请选择班级");
        classComboBox.addItem(tip);
        List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectAll();
        for (Clazz clazz : clazzList) {
            classComboBox.addItem(clazz);
        }

        //关闭窗体
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddStudentFrame.this.dispose();
            }
        });

        //头像按钮
        avatarLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("/Users/mqxu/Pictures"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(150, 150, 150));
                    avatarLabel.setText("");
                    avatarLabel.setIcon(icon);
                }
            }
        });


        //班级复选框
        classComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int index = classComboBox.getSelectedIndex();
                if (index != 0) {
                    classId = classComboBox.getItemAt(index).getId();
                }
            }
        });

        //单选按钮
        ButtonGroup group = new ButtonGroup();
        group.add(男RadioButton);
        group.add(女RadioButton);

        //出生日期
        DatePicker datePicker = getDatePicker();
        datePanel.add(datePicker);
        datePanel.revalidate();


        新增Button.addActionListener(e -> {
            String gender = null;
            if (男RadioButton.isSelected()) {
                gender = "男";
            }
            if (女RadioButton.isSelected()) {
                gender = "女";
            }
            Student student = new Student();
            student.setId(idField.getText());
            student.setClassId(classId);
            student.setStudentName(nameField.getText());
            student.setAvatar(AliOSSUtil.ossUpload(file));
            student.setGender(FormatUtil.formatGender(gender));
            student.setBirthday((Date) datePicker.getValue());
            student.setAddress(addressField.getText());
            student.setPhone(phoneField.getText());
            int n = ServiceFactory.getStudentServiceInstance().insertStudent(student);
            if (n == 1) {
                JOptionPane.showMessageDialog(rootPanel, "新增成功");
                AddStudentFrame.this.dispose();
                List<StudentVo> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                mainFrame.showStudentTable(studentList);
            }
        });
        新增Button.setBackground(new Color(134, 219, 71));
        新增Button.setForeground(new Color(0, 0, 0));
    }

    private static DatePicker getDatePicker() {
        final DatePicker datePicker;
        // 格式
        String defaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.PLAIN, 18);
        Dimension dimension = new Dimension(200, 30);
        int[] hilightDays = {1, 3, 5, 7};
        int[] disabledDays = {4, 6, 5, 9};
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datePicker = new DatePicker(date, defaultFormat, font, dimension);
        //设置起始位置
        // datePicker.setLocation(137, 83);
        //也可用setBounds()直接设置大小与位置
        //datePicker.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datePicker.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datePicker.setDisableddays(disabledDays);
        // 设置国家
        datePicker.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        // datePicker.setTimePanleVisible(true);
        return datePicker;
    }

}

