package com.itshiokou.gui2;

import javax.swing.*;

public class Text2 {
    //目标：自定义一个登录界面，让界面对象本身也是事件监听器对象
    public static void main(String[] args) {
        JFrame jf =new JFrame("登录界面");
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
    }

}
