package com.fqq.snalegame;

import javax.swing.*;
import java.net.URL;

/**
 * @author: fqq
 * @Date: 2025/5/18 - 05 - 18 - 15:54
 * @Description: com.fqq.snalegame
 * @version: 1.0
 */
public class Pics {
    //将图片封装为图片
    //先路径 编译-》运行 ->封装-》虚拟机能识别的是out文件里的图片
    public static URL bodyURL=Pics.class.getResource("/pics/body.png");
    public static ImageIcon bodyIcon=new ImageIcon(bodyURL);
    public static URL downURL=Pics.class.getResource("/pics/down.png");
    public static ImageIcon downIcon=new ImageIcon(downURL);
    public static URL foodURL=Pics.class.getResource("/pics/food.png");
    public static ImageIcon foodIcon=new ImageIcon(foodURL);
    public static URL headerURL=Pics.class.getResource("/pics/header.png");
    public static ImageIcon headerIcon=new ImageIcon(headerURL);
    public static URL leftURL=Pics.class.getResource("/pics/left.png");
    public static ImageIcon leftIcon=new ImageIcon(leftURL);
    public static URL rightURL=Pics.class.getResource("/pics/right.png");
    public static ImageIcon rightIcon=new ImageIcon(rightURL);
    public static URL upURL=Pics.class.getResource("/pics/up.png");
    public static ImageIcon upIcon=new ImageIcon(upURL);

}
