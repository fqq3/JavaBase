package com.fqq.snalegame;

import javax.swing.*;
import java.awt.*;

/**
 * @author: fqq
 * @Date: 2025/5/18 - 05 - 18 - 16:32
 * @Description: com.fqq.snalegame
 * @version: 1.0
 */
public class StartGame {
    public static void main(String[] args) {
        JFrame jf =new JFrame();//创建一个窗体
        jf.setTitle("贪吃蛇小游戏");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height =Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-800)/2,(height-800)/2,800,800);
        //窗口大小不可调节
        jf.setResizable(false);
        //关闭窗口的同时，程序随之关闭
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建一个面板
        GamePanel gp=new GamePanel();
        //将面板放入窗体中
        jf.add(gp);
        //默认情况下，窗体是隐形效果
        jf.setVisible(true);
    }

}
