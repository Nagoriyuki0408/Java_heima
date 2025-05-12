package com.shiokou.HM.ui;

import com.shiokou.HM.bean.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginFrame extends JFrame  {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    //定义一个静态的集合，存储系统中全部的用户对象信息
    private static ArrayList<User> users = new ArrayList<User>();
    //初始化几个测试用户对象信息，作为登录用
    static {
        users.add(new User("Shiokou", "Shiokou"));
        users.add(new User("Shiokou1", "Shiokou1"));
        users.add(new User("Shiokou2", "Shiokou2"));
        users.add(new User("Shiokou3", "Shiokou3"));
    }
    public LoginFrame() {
        super("登录界面");
        this.setSize(400, 300); // 稍微增大窗口
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        createAndShowGUI(); // 调用 createAndShowGUI 方法
    }

    private void createAndShowGUI() {
        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout()); // 使用 BorderLayout
        mainPanel.setBackground(new Color(240, 240, 240)); // 浅灰色背景
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // 设置边距

        // 设置字体
        Font chineseFont = new Font("宋体", Font.PLAIN, 18); // 使用宋体，增大字号

        // 创建顶部面板，包含标题
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(240, 240, 240)); // 浅灰色背景
        JLabel titleLabel = new JLabel("用户登录"); // 更友好的标题
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24)); // 更现代的字体
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // 创建中心面板，包含用户名和密码输入框
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 使用 GridLayout，增加间距
        centerPanel.setBackground(new Color(240, 240, 240)); // 浅灰色背景
        centerPanel.setBorder(new EmptyBorder(10, 0, 10, 0)); // 设置内部边距

        JLabel usernameLabel = new JLabel("用户名:");
        usernameLabel.setFont(chineseFont);
        centerPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(chineseFont);
        centerPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(chineseFont);
        centerPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(chineseFont);
        centerPanel.add(passwordField);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // 创建底部面板，包含登录和注册按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); // 使用 FlowLayout, 增加按钮间距
        buttonPanel.setBackground(new Color(240, 240, 240)); // 浅灰色背景

        loginButton = new JButton("登录");
        loginButton.setFont(chineseFont);
        loginButton.setBackground(new Color(59, 89, 182)); // 更醒目的颜色
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false); // 移除焦点边框
        buttonPanel.add(loginButton);

        registerButton = new JButton("注册");
        registerButton.setFont(chineseFont);
        registerButton.setBackground(new Color(59, 89, 182)); // 更醒目的颜色
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false); // 移除焦点边框
        buttonPanel.add(registerButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加事件监听器
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加登录逻辑
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword()); // 获取密码

                // 验证用户名和密码
                boolean authenticated = false;
                for (User user : users) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        authenticated = true;
                        break;
                    }
                }

                if (authenticated) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "登录成功!");
                    // 登录成功后，创建并显示员工信息管理界面
                    SwingUtilities.invokeLater(() -> {
                        new EmployeeManagementFrame(username).setVisible(true);
                    });
                    LoginFrame.this.dispose(); // 关闭登录界面
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "用户名或密码错误!", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        registerButton.addActionListener(e -> {
            // 创建注册界面
            JPanel registerPanel = new JPanel(new GridLayout(3, 2, 5, 5));
            JTextField registerUsernameField = new JTextField();
            JPasswordField registerPasswordField = new JPasswordField();
            JPasswordField confirmPasswordField = new JPasswordField();

            registerPanel.add(new JLabel("用户名:"));
            registerPanel.add(registerUsernameField);
            registerPanel.add(new JLabel("密码:"));
            registerPanel.add(registerPasswordField);
            registerPanel.add(new JLabel("确认密码:"));
            registerPanel.add(confirmPasswordField);

            int result = JOptionPane.showConfirmDialog(LoginFrame.this, registerPanel, "注册", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // 获取注册信息
                String username = registerUsernameField.getText();
                char[] password = registerPasswordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();

                // 验证用户名是否已存在
                for (User user : users) {
                    if (user.getUsername().equals(username)) {
                        JOptionPane.showMessageDialog(LoginFrame.this, "用户名已存在!", "错误", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // 验证密码和确认密码是否一致
                if (!Arrays.equals(password, confirmPassword)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "密码和确认密码不一致!", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 创建新用户
                User newUser = new User(username, new String(password));
                users.add(newUser);

                JOptionPane.showMessageDialog(LoginFrame.this, "注册成功!");
            }
        });

        //添加面板到窗体
        this.add(mainPanel);
        this.setVisible(true);
    }

        //添加面板到窗体

    }
