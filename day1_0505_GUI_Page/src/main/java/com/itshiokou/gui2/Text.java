package com.itshiokou.gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Text {
    //提供实现类，创建实现类对象代表事件监听器对象

    public static <MyFrame, MyListener> void main(String[] args) {
        JFrame jf=new JFrame("登录窗口");
        JPanel pannel =  new JPanel();
        jf.add(pannel);
        jf.setSize(400,300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("登录");
        pannel.add(button);//添加组件
        button.addActionListener(new ActionListener(){
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
        jf.setVisible(true);
    }
    class  MyListener implements ActionListener {
        private JFrame jf;
        public MyListener(JFrame jf) {
            this.jf = jf;
        }
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(jf,"登录成功！");
        }
    }
}
