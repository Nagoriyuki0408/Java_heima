package com.itshiokou.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Test {
    public static void main(String[] args){
        JFrame jf=new JFrame("登录窗口");
        JPanel pannel=new JPanel();
        jf.add(pannel);
        jf.setSize(400,300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb=new JButton("登录");
        pannel.add(jb);
        //给按钮绑定点击事件监听对象
        jb.addActionListener(new ActionListener(){
            @Override
            public  void actionPerformed(ActionEvent e){
                System.out.println("登录成功");
                //一旦点击jb按钮，就会出发方法执行
                //e是事件对象，封装事件相关信息
                System.out.println(e);
                e.getID();
                String s = "有人点击了登录！！";
                JOptionPane.showMessageDialog(jf,"有人点击了登录！");
            }
        });
        //案件项目，需要监听用户上下左右四个键的事件事件
        jf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println("有人按下了键盘");
                int keyCode = e.getKeyCode();
                //拿事件源头的号编号
                //判断按键编码是否为上下左右，分开写if语句
                if(keyCode==KeyEvent.VK_UP){
                    System.out.println("按下了上键");
                }else if(keyCode==KeyEvent.VK_DOWN){
                    System.out.println("按下了下键");
                }else if(keyCode==KeyEvent.VK_LEFT){
                    System.out.println("按下了左键");
                }else if(keyCode==KeyEvent.VK_RIGHT){
                    System.out.println("按下了右键");
                }
            }

        });
        //让窗口作为焦点
        jf.setFocusable(true);
//        jf.requestFocus(true);
        jf.setVisible(true);
        //登录会导致冲突

    }
}
