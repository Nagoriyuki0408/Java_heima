package HumanManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementFrameUI extends JFrame {
    private JTextField name_searchField;
    private JButton searchButton;
    private JButton addButton;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    //无参构造器
    public EmployeeManagementFrameUI() {
        super("员工信息管理系统"); // 调用父类JFrame的构造方法，设置窗口标题为 "员工信息管理系统"
        this.setSize(800, 600); // 设置窗口的大小为 800x600 像素
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的默认操作为退出应用程序
        this.setLocationRelativeTo(null); // 设置窗口在屏幕中央显示
        initializeComponents(); // 调用initializeComponents方法，初始化窗口中的各种组件
    }
    //加载函数，构造器的外部函数实现
    private void initializeComponents() {
        // 创建主面板，使用 BorderLayout 布局
        JPanel mainPanel = new JPanel(new BorderLayout());

        // 创建顶部面板，用于放置搜索框、搜索按钮和添加按钮
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // 创建搜索的按键和搜索框
        name_searchField = new JTextField(20);
        searchButton = new JButton("搜索");

        // 创建添加按钮
        addButton = new JButton("添加");

        // 将搜索框、搜索按钮和添加按钮添加到顶部面板
        topPanel.add(name_searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);


        //设置表格：表格模型（列名，数据大小），导入表格到JTable后，导入其创建新的JScrollPane来实现滚动
        String[] columnNames = {"ID", "姓名", "年龄", "职位"};
        Object[][] data = new Object[20][4]; // 初始化20行数据
        tableModel = new DefaultTableModel(data, columnNames);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        addPopupMenuToTable();

        //将上面板和滚动面板放到主面板对应的位置
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 将主面板添加到窗体，设置窗体可见
        this.add(mainPanel);
        this.setVisible(true);

        // 用lambda表达式来添加按钮的事件监听器
        addButton.addActionListener(e -> addEmployee() );
    }

    private void addEmployee() {
        // JOptionPane.showInputDialog弹出对话框，获取用户输入的员工信息
        String id = JOptionPane.showInputDialog(this, "请输入员工ID:");
        String name = JOptionPane.showInputDialog(this, "请输入员工姓名:");
        String ageStr = JOptionPane.showInputDialog(this, "请输入员工年龄:");
        String position = JOptionPane.showInputDialog(this, "请输入员工职位:");
        System.out.println("添加员工信息：" + id + ", " + name + ", " + ageStr + ", " + position);


        // 检查用户是否输入了所有信息（未点击取消按钮）
        if (id != null && name != null && ageStr != null && position != null) {
            try {
                int age = Integer.parseInt(ageStr); // 将年龄字符串转换为整数，如果转换失败会抛出NumberFormatException

                // 创建新员工数据，存储在一个Object数组中
                Object[] newRow = {id, name, age, position};

                // 将新员工数据添加到表格模型中，表格模型负责管理表格的数据
                tableModel.addRow(newRow);

                // 提示添加成功
                JOptionPane.showMessageDialog(this, "员工信息添加成功!"); // 显示一个消息对话框，提示用户员工信息添加成功
            } catch (NumberFormatException ex) {
                // 如果年龄输入不是有效的整数，显示错误提示
                JOptionPane.showMessageDialog(this, "年龄输入无效，请输入数字!", "错误", JOptionPane.ERROR_MESSAGE); // 显示一个错误消息对话框，提示用户年龄输入无效，并要求输入数字
            }
        }
    }

    private void addPopupMenuToTable() {
        // 创建一个新的弹出菜单
        JPopupMenu popupMenu = new JPopupMenu();
        // 创建一个名为“修改”的菜单项
        JMenuItem editItem = new JMenuItem("修改");
        // 创建一个名为“删除”的菜单项
        JMenuItem deleteItem = new JMenuItem("删除");

        // 将“修改”菜单项添加到弹出菜单
        popupMenu.add(editItem);
        // 将“删除”菜单项添加到弹出菜单
        popupMenu.add(deleteItem);

        // 将弹出菜单设置为 employeeTable 的组件弹出菜单。
        employeeTable.setComponentPopupMenu(popupMenu);

        // 添加事件监听器
        // 为“修改”菜单项添加一个 ActionListener。
        editItem.addActionListener(e -> {
            // 获取表格中选定的行索引
            int selectedRow = employeeTable.getSelectedRow();
            // 检查是否选择了行（selectedRow != -1 表示选择了行）
            if (selectedRow != -1) {
                // 实现修改逻辑
                // 在控制台中打印一条消息，指示要修改哪一行
                System.out.println("修改第 " + (selectedRow + 1) + " 行数据");
                // TODO: 在此处添加实际的修改数据的代码。例如，可以打开一个对话框，允许用户编辑选定行的数据。
            }
        });
        // TODO: 为 deleteItem 添加 ActionListener，实现删除逻辑


        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    // 实现删除逻辑
                    tableModel.removeRow(selectedRow);
                }
            }
        });
    }
}
