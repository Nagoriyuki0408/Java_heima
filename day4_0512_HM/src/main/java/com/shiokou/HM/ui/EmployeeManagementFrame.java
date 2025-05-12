package com.shiokou.HM.ui;

import com.shiokou.HM.bean.Employee;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeManagementFrame extends JFrame {

    private JTextField idField, genderField, ageField, phoneField, positionField, hireDateField, salaryField, departmentField;
    private JButton addButton;
    private JTable employeeTable; // 使用 JTable
    private DefaultTableModel tableModel; // 表格数据模型
    private ArrayList<Employee> employeeList = new ArrayList<>(); // 存储员工信息
    private String username;
    private static EmployeeManagementFrame frame; // 声明静态的 frame 变量
    // 准备一个静态集合对象，用来存储系统中的全部员工信息
    private static ArrayList<Employee> employees = new ArrayList<>();
    private JPopupMenu popupMenu; // 右键菜单

    // 统一的字体
    private static final Font MAIN_FONT = new Font("微软雅黑", Font.PLAIN, 14);
    // 统一的背景颜色
    private static final Color BACKGROUND_COLOR = new Color(240, 248, 255); // 象牙白

    public EmployeeManagementFrame() {
        super("员工信息管理");
        this.setSize(1000, 700); // 增大窗口尺寸
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 关闭窗口时只关闭当前窗口
        this.setLocationRelativeTo(null);
        createAndShowGUI();
    }

    public EmployeeManagementFrame(String username) {
        super("欢迎，" + username + "进入人事信息管理界面");
        this.username = username;
        frame = this;
        createAndShowGUI();
        this.setVisible(true);
    }

    private void createAndShowGUI() {
        // 主面板
        ImagePanel mainPanel = new ImagePanel("/background.jpg"); // 使用 ImagePanel
        mainPanel.setLayout(new BorderLayout()); // 设置布局管理器
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        //mainPanel.setBackground(BACKGROUND_COLOR); // 移除设置背景颜色的代码

        // 顶部面板，用于输入员工信息
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false); // 设置透明
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "员工信息");
        titledBorder.setTitleFont(MAIN_FONT);
        titledBorder.setTitleColor(Color.DARK_GRAY);
        inputPanel.setBorder(titledBorder);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // 增加组件间距
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(MAIN_FONT);
        idField = new JTextField();
        idField.setFont(MAIN_FONT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(idLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(idField, gbc);

        JLabel genderLabel = new JLabel("性别:");
        genderLabel.setFont(MAIN_FONT);
        genderField = new JTextField();
        genderField.setFont(MAIN_FONT);
        gbc.gridx = 2;
        gbc.gridy = 0;
        inputPanel.add(genderLabel, gbc);
        gbc.gridx = 3;
        inputPanel.add(genderField, gbc);

        JLabel ageLabel = new JLabel("年龄:");
        ageLabel.setFont(MAIN_FONT);
        ageField = new JTextField();
        ageField.setFont(MAIN_FONT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(ageLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(ageField, gbc);

        JLabel phoneLabel = new JLabel("电话:");
        phoneLabel.setFont(MAIN_FONT);
        phoneField = new JTextField();
        phoneField.setFont(MAIN_FONT);
        gbc.gridx = 2;
        gbc.gridy = 1;
        inputPanel.add(phoneLabel, gbc);
        gbc.gridx = 3;
        inputPanel.add(phoneField, gbc);

        JLabel positionLabel = new JLabel("职位:");
        positionLabel.setFont(MAIN_FONT);
        positionField = new JTextField();
        positionField.setFont(MAIN_FONT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(positionLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(positionField, gbc);

        JLabel hireDateLabel = new JLabel("入职时间:");
        hireDateLabel.setFont(MAIN_FONT);
        hireDateField = new JTextField();
        hireDateField.setFont(MAIN_FONT);
        gbc.gridx = 2;
        gbc.gridy = 2;
        inputPanel.add(hireDateLabel, gbc);
        gbc.gridx = 3;
        inputPanel.add(hireDateField, gbc);

        JLabel salaryLabel = new JLabel("薪水:");
        salaryLabel.setFont(MAIN_FONT);
        salaryField = new JTextField();
        salaryField.setFont(MAIN_FONT);
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(salaryLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(salaryField, gbc);

        JLabel departmentLabel = new JLabel("部门信息:");
        departmentLabel.setFont(MAIN_FONT);
        departmentField = new JTextField();
        departmentField.setFont(MAIN_FONT);
        gbc.gridx = 2;
        gbc.gridy = 3;
        inputPanel.add(departmentLabel, gbc);
        gbc.gridx = 3;
        inputPanel.add(departmentField, gbc);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // 中心面板，用于显示员工信息
        // 表头
        String[] columnNames = {"ID", "性别", "年龄", "电话", "职位", "入职时间", "薪水", "部门"};
        // 数据模型
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        employeeTable.setFont(MAIN_FONT);
        employeeTable.setRowHeight(25); // 设置行高
        employeeTable.getTableHeader().setFont(MAIN_FONT); // 设置表头字体
        employeeTable.setEnabled(false);
        employeeTable.setOpaque(false); // 设置透明
        ((JComponent) employeeTable.getDefaultRenderer(Object.class)).setOpaque(false); // 设置表格单元格透明

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setOpaque(false); // 设置透明
        scrollPane.getViewport().setOpaque(false); // 设置视口透明
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 底部面板，包含添加按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false); // 设置透明
        addButton = new JButton("添加");
        addButton.setFont(MAIN_FONT);
        addButton.setBackground(new Color(173, 216, 230)); // 淡蓝色
        addButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/favicon.ico")))); // 添加图标

        buttonPanel.add(addButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加事件监听器
        addButton.addActionListener(e -> {
            // 添加员工信息
            String id = idField.getText();
            String gender = genderField.getText();
            String age = ageField.getText();
            String phone = phoneField.getText();
            String position = positionField.getText();
            String hireDate = hireDateField.getText();
            String salary = salaryField.getText();
            String department = departmentField.getText();

            Employee employee = new Employee(id, gender, age, phone, position, hireDate, salary, department);
            employeeList.add(employee);
            employees.add(employee); // 添加到静态集合

            updateDisplayArea(); // 更新显示区域

            // 清空输入框
            idField.setText("");
            genderField.setText("");
            ageField.setText("");
            phoneField.setText("");
            positionField.setText("");
            hireDateField.setText("");
            salaryField.setText("");
            departmentField.setText("");
        });

        // 创建右键菜单
        popupMenu = new JPopupMenu();
        JMenuItem updateMenuItem = new JMenuItem("修改");
        updateMenuItem.setFont(MAIN_FONT);
        JMenuItem deleteMenuItem = new JMenuItem("删除");
        deleteMenuItem.setFont(MAIN_FONT);
        popupMenu.add(updateMenuItem);
        popupMenu.add(deleteMenuItem);

        // 为 "修改" 菜单项添加事件监听器
        updateMenuItem.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow != -1) {
                Employee employee = employees.get(selectedRow);
                // 弹出修改信息的对话框
                JPanel updatePanel = new JPanel(new GridLayout(8, 2, 5, 5));
                JTextField genderFieldUpdate = new JTextField(employee.getGender());
                JTextField ageFieldUpdate = new JTextField(employee.getAge());
                JTextField phoneFieldUpdate = new JTextField(employee.getPhone());
                JTextField positionFieldUpdate = new JTextField(employee.getPosition());
                JTextField hireDateFieldUpdate = new JTextField(employee.getHireDate());
                JTextField salaryFieldUpdate = new JTextField(employee.getSalary());
                JTextField departmentFieldUpdate = new JTextField(employee.getDepartment());

                updatePanel.add(new JLabel("性别:"));
                updatePanel.add(genderFieldUpdate);
                updatePanel.add(new JLabel("年龄:"));
                updatePanel.add(ageFieldUpdate);
                updatePanel.add(new JLabel("电话:"));
                updatePanel.add(phoneFieldUpdate);
                updatePanel.add(new JLabel("职位:"));
                updatePanel.add(positionFieldUpdate);
                updatePanel.add(new JLabel("入职时间:"));
                updatePanel.add(hireDateFieldUpdate);
                updatePanel.add(new JLabel("薪水:"));
                updatePanel.add(salaryFieldUpdate);
                updatePanel.add(new JLabel("部门:"));
                updatePanel.add(departmentFieldUpdate);

                int result = JOptionPane.showConfirmDialog(EmployeeManagementFrame.this, updatePanel, "修改员工信息", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    // 更新员工信息
                    employee.setGender(genderFieldUpdate.getText());
                    employee.setAge(ageFieldUpdate.getText());
                    employee.setPhone(phoneFieldUpdate.getText());
                    employee.setPosition(positionFieldUpdate.getText());
                    employee.setHireDate(hireDateFieldUpdate.getText());
                    employee.setSalary(salaryFieldUpdate.getText());
                    employee.setDepartment(departmentFieldUpdate.getText());

                    updateDisplayArea(); // 更新显示区域
                    JOptionPane.showMessageDialog(EmployeeManagementFrame.this, "员工信息修改成功!");
                }
            } else {
                JOptionPane.showMessageDialog(EmployeeManagementFrame.this, "请选择要修改的员工!", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 为 "删除" 菜单项添加事件监听器
        deleteMenuItem.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow != -1) {
                Employee employeeToDelete = employees.get(selectedRow);
                int result = JOptionPane.showConfirmDialog(EmployeeManagementFrame.this, "确定要删除员工 " + employeeToDelete.getId() + " 吗?", "删除确认", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    employees.remove(selectedRow);
                    updateDisplayArea(); // 更新显示区域
                    JOptionPane.showMessageDialog(EmployeeManagementFrame.this, "员工信息删除成功!");
                }
            } else {
                JOptionPane.showMessageDialog(EmployeeManagementFrame.this, "请选择要删除的员工!", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 在 JTable 上添加鼠标监听器
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = employeeTable.rowAtPoint(e.getPoint());
                    if (row >= 0 && row < employeeTable.getRowCount()) {
                        employeeTable.setRowSelectionInterval(row, row);
                    } else {
                        employeeTable.clearSelection();
                    }
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        this.add(mainPanel);
        this.setVisible(true);

        // 初始化表格数据
        updateDisplayArea();
    }

    // 更新显示区域
    private void updateDisplayArea() {
        // 清空表格数据
        tableModel.setRowCount(0);
        // 遍历员工列表，将数据添加到表格中
        for (Employee employee : employees) {
            Object[] rowData = {
                    employee.getId(),
                    employee.getGender(),
                    employee.getAge(),
                    employee.getPhone(),
                    employee.getPosition(),
                    employee.getHireDate(),
                    employee.getSalary(),
                    employee.getDepartment()
            };
            tableModel.addRow(rowData);
        }
    }
}