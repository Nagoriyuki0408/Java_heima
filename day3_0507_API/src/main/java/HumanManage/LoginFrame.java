package HumanManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginFrame() {
        super("登录界面");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        createAndShowGUI(); // 调用 createAndShowGUI 方法
    }

    private void createAndShowGUI() {
        // 创建面板
        JPanel panel = new JPanel(new BorderLayout()); // 使用 BorderLayout
        panel.setBackground(Color.LIGHT_GRAY);

        // 设置字体
        Font chineseFont = new Font("宋体", Font.PLAIN, 16); // 使用宋体

        // 创建顶部面板，包含标题
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("登录界面");
        titleLabel.setFont(chineseFont);
        titlePanel.add(titleLabel);
        panel.add(titlePanel, BorderLayout.NORTH);
        //创建一个展示框的步骤：建立单独的JPanel->设置面板的颜色->创建文字的JLable->设置JLable的字体->将标签加入面板->将单独的JPanel放到总的Panel当中
        // 创建中心面板，包含用户名和密码输入框
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // 使用 GridLayout
        centerPanel.setBackground(Color.LIGHT_GRAY);
        JLabel usernameLabel = new JLabel("用户名:");
        usernameLabel.setFont(chineseFont);
        centerPanel.add(usernameLabel);
//创建有输入的面板的步骤：先new一个单独的面板->设置面板的颜色->创建对应的JLable->设置JLable的字体->将JLable加入单独的面板->创建一个输入的JTextField->调整这个域的字体->将输入框和面板绑定->将单独的面板加入总面板
        usernameField = new JTextField();
        usernameField.setFont(chineseFont);
        centerPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(chineseFont);
        centerPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(chineseFont);
        centerPanel.add(passwordField);
        panel.add(centerPanel, BorderLayout.CENTER);

        // 创建底部面板，包含登录和注册按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        loginButton = new JButton("登录");
        loginButton.setFont(chineseFont);
        loginButton.setBackground(new Color(59, 89, 182)); // 更醒目的颜色
        loginButton.setForeground(Color.WHITE);
        buttonPanel.add(loginButton);
//含有按钮的面板：创建一个 JPanel 用于放置按钮->设置面板背景颜色_>创建JButton用来显示按钮->设置按钮的字体->设置按钮的颜色-》设置按钮的前景色->j将按钮绑定到面板上
        registerButton = new JButton("注册");
        registerButton.setFont(chineseFont);
        registerButton.setBackground(new Color(59, 89, 182)); // 更醒目的颜色
        registerButton.setForeground(Color.WHITE);
        buttonPanel.add(registerButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加事件监听器
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加登录逻辑
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword()); // 获取密码

                // TODO:  验证用户名和密码
                if ("admin".equals(username) && "password".equals(password)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "登录成功!");
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "用户名或密码错误!", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
//事件监听器的安排：用按钮调用addActionListener函数->new一个ActionListener() 对象->获取用户输入框的文本 usernameField.getText()->验证输入内容是否符合要求。
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加注册逻辑
                JOptionPane.showMessageDialog(LoginFrame.this, "注册功能尚未实现!");
            }
        });

        //添加面板到窗体
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}