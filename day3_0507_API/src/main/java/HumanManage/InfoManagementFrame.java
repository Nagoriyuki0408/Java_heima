package HumanManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoManagementFrame extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField phoneField;
    private JTextField positionField;
    private JTextField hireDateField;
    private JTextField salaryField;
    private JTextField departmentField;

    public InfoManagementFrame() {
        setTitle("信息管理界面");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        // 姓名输入框
        panel.add(new JLabel("姓名:"));
        nameField = new JTextField();
        panel.add(nameField);

        // 年龄输入框
        panel.add(new JLabel("年龄:"));
        ageField = new JTextField();
        panel.add(ageField);

        // 电话输入框
        panel.add(new JLabel("电话:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        // 职位输入框
        panel.add(new JLabel("职位:"));
        positionField = new JTextField();
        panel.add(positionField);

        // 入职时间输入框
        panel.add(new JLabel("入职时间:"));
        hireDateField = new JTextField();
        panel.add(hireDateField);

        // 薪水输入框
        panel.add(new JLabel("薪水:"));
        salaryField = new JTextField();
        panel.add(salaryField);

        // 部门输入框
        panel.add(new JLabel("部门:"));
        departmentField = new JTextField();
        panel.add(departmentField);

        // 添加按钮
        JButton addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String phone = phoneField.getText();
                String position = positionField.getText();
                String hireDate = hireDateField.getText();
                String salary = salaryField.getText();
                String department = departmentField.getText();
                // 这里可以添加添加员工信息的逻辑
                JOptionPane.showMessageDialog(InfoManagementFrame.this, "添加员工信息：姓名=" + name + ", 年龄=" + age + ", 电话=" + phone + ", 职位=" + position + ", 入职时间=" + hireDate + ", 薪水=" + salary + ", 部门=" + department);
            }
        });
        panel.add(addButton);

        add(panel);
    }

}

