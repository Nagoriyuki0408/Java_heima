package com.shiokou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

//继承JFrame类
public class MainFrame extends JFrame {
    public static final String IMAGE_PATH = "/image/";
    private int[][] imagedata={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    private int[][] winData={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    private int row,col;
    //用来统计一共移动的步数
    private int count;
    public MainFrame() {
        initFrame();
        //打乱数字色块的顺序
        initRandomArray();
        //初始化界面：展示数字色块
        initImage();
        //初始化系统菜单：点击弹出菜单信息是系统退出，重启游戏
        initMenu();
        //给当前窗口绑定上下左右按键按压事件
        initKeyPressEvent();
        //设置窗口的显示
        this.setVisible(true);
        this.requestFocusInWindow();

    }
    private boolean isWin(){
        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                if (imagedata[i][j] != winData[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private void initKeyPressEvent(){
        //给当前窗口绑定上下左右按键按压事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int Keycode = e.getKeyCode();
                switch(Keycode){
                    case KeyEvent. VK_UP:
                        System.out.println("按下了上键");
                        switchAndMove(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("按下了下键");
                        switchAndMove(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("按下了左键");
                        switchAndMove(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("按了右键");
                        switchAndMove(Direction.RIGHT);
                        break;
                }
            }
        });
    }
    private void switchAndMove(Direction r){
        //判断图片的方向，再控制图片移动
        switch (r){
            case UP:
                //上交换条件必须是<3，然后才开始交换
                if (row < imagedata.length-1) {
                    //当前空白色块的位置： rol col
                    //需要交换的位置：row+1 col
                     int temp = imagedata[row][col];
                     imagedata[row][col] = imagedata[row + 1][col];
                     imagedata[row + 1][col] = temp;
                    //更新当前空白色块的位置
                    row++;
                    count++;
                }
                System.out.println("up");

                break;
            case DOWN:
                //下交换条件必须是>0，然后才开始交换
                 if (row > 0) {
                     int temp = imagedata[row][col];
                     imagedata[row][col] = imagedata[row - 1][col];
                     imagedata[row - 1][col] = temp;
                     //更新当前空白色块的位置
                     row--;
                     count++;
                 }
                System.out.println("down");

                break;
            case LEFT:
                //左交换条件必须是>0，然后才开始交换
                if (col < imagedata.length-1) {
                    int temp = imagedata[row][col];
                     imagedata[row][col] = imagedata[row][col +1];
                     imagedata[row][col + 1] = temp;
                     col++;
                     count++;
                }
                System.out.println("left");

                break;
            case RIGHT:
                 if (col > 0) {
                     int temp = imagedata[row][col];
                     imagedata[row][col] = imagedata[row][col - 1];
                     imagedata[row][col - 1] = temp;
                     col--;
                     count++;
                 }
                System.out.println("right");

                break;
        }
        initImage();
    }
//    private void initRandomArray() {
//        for (int i = 0; i < imagedata.length; i++) {
//            for (int j = 0; j < imagedata[i].length; j++) {
//                //随机两个行列位置，让这两个位置交换
//                int r1 = (int) (Math.random() * imagedata.length);
//                int c1 = (int) (Math.random() * imagedata[i].length);
//                int r2 = (int) (Math.random() * imagedata.length);
//                int c2 = (int) (Math.random() * imagedata[i].length);
//                int temp = imagedata[r1][c1];
//                imagedata[r1][c1] = imagedata[r2][c2];
//                imagedata[r2][c2] = temp;
//            }
//        }
//    }
private void initRandomArray() {
    do {
        // 生成随机乱序数组
        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                // 随机两个行列位置，让这两个位置交换
                int r1 = (int) (Math.random() * imagedata.length);
                int c1 = (int) (Math.random() * imagedata[i].length);
                int r2 = (int) (Math.random() * imagedata.length);
                int c2 = (int) (Math.random() * imagedata[i].length);
                int temp = imagedata[r1][c1];
                imagedata[r1][c1] = imagedata[r2][c2];
                imagedata[r2][c2] = temp;
            }
        }
    } while (!isRecoverable(imagedata)); // 检查是否可恢复
}

    // 判断当前拼图状态是否可恢复
    private boolean isRecoverable(int[][] arr) {
        int[] flatArray = flattenArray(arr); // 将二维数组展平为一维数组
        int inversionCount = getInversionCount(flatArray); // 计算逆序数
        int blankRowFromBottom = arr.length - row; // 空白块的行数（从底部开始计数）

        // 如果宽度是偶数，考虑空白块的行数
        if (arr.length % 2 == 0) {
            return (inversionCount + blankRowFromBottom) % 2 == 0;
        } else {
            // 如果宽度是奇数，只需判断逆序数的奇偶性
            return inversionCount % 2 == 0;
        }
    }

    // 计算数组的逆序数
    private int getInversionCount(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 0 && arr[j] > 0 && arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 将二维数组展平为一维数组
    private int[] flattenArray(int[][] arr) {
        int[] flatArray = new int[arr.length * arr[0].length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                flatArray[index++] = arr[i][j];
            }
        }
        return flatArray;
    }
    private void initImage() {
        // 初始化空白块的位置
        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                if (imagedata[i][j] == 0) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        // 清空窗口上的所有内容
        this.getContentPane().removeAll();

        // 使用 JLayeredPane 管理图层
        JLayeredPane layeredPane = this.getLayeredPane();
        layeredPane.removeAll(); // 清空之前的所有图层

        // 如果胜利，显示胜利图片
        if (isWin()) {
            URL imageUrl = getClass().getResource(IMAGE_PATH + "win.png");
            if (imageUrl != null) {
                JLabel winLabel = new JLabel(new ImageIcon(imageUrl));
                winLabel.setBounds(0, 0, 288, 100);
                layeredPane.add(winLabel, JLayeredPane.MODAL_LAYER); // 添加到模态层
            } else {
                System.err.println("图片加载失败：" + IMAGE_PATH + "win.png");
            }
        }

        // 添加数字图片
        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                String imageName = imagedata[i][j] + ".png";
                ImageIcon imageIcon = new ImageIcon(getClass().getResource(IMAGE_PATH + imageName));
                JLabel label = new JLabel(imageIcon);
                label.setBounds(25 + j * 100, 110 + i * 100, 100, 100);
                layeredPane.add(label, JLayeredPane.PALETTE_LAYER); // 添加到调色板层
            }
        }

        // 添加背景图片
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource(IMAGE_PATH + "background.png"));
        JLabel background = new JLabel(backgroundIcon);
        background.setBounds(0, 0, 465, 600);
        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER); // 添加到默认层

        // 显示步数
        JLabel label1 = new JLabel("步数：" + count);
        label1.setBounds(10, 20, 100, 30); // 设置步数标签的位置和大小
        layeredPane.add(label1, JLayeredPane.MODAL_LAYER); // 添加到模态层

        // 确保内容面板是透明的
        ((JPanel) this.getContentPane()).setOpaque(false);

        // 重新绘制窗口
        this.validate();
        this.repaint();
    }
    private void initMenu(){
        //创建一个菜单条
        JMenuBar menuBar = new JMenuBar();
        //创建一个菜单
        JMenu menu = new JMenu("游戏");
        //设置退出键
        JMenuItem exitItem = new JMenuItem("退出");
        //exitItem绑定事件监听器
        exitItem.addActionListener(e -> {
            dispose();
        });
        //添加一个菜单，重启
        JMenuItem restartItem = new JMenuItem("重新开始");
        //加入菜单窗口
        menu.add(restartItem);
        //restartItem绑定事件监听器
        restartItem.addActionListener(e -> {
            // 重新开始游戏
            // 重新加载页面
            this.dispose();
            new MainFrame();
        });
        //添加到菜单条种
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    private void initFrame() {
        this.setTitle("石子迷阵 v1.0");
        this.setSize(465, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // 绝对布局
        //给窗口添加一个展示文字的组件
        JLabel label = new JLabel("步数：" + count);
        label.setBounds(0, 0, 100, 20);
    }


}