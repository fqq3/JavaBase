package com.fqq.snalegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @author: fqq
 * @Date: 2025/5/18 - 05 - 18 - 16:47
 * @Description: com.fqq.snalegame
 * @version: 1.0
 */
public class GamePanel extends JPanel {
    //paintComponent这个方法比较特殊，这个方法就属于图形版的main方法，自动调用
    int length;
    int[] snakeX =new int[200];
    int[] snakeY =new int[200];
    String dir;
    boolean start=false;
    //定时器
    Timer tm;//定时器
    int foodX=200,foodY=225;//食物座标
    int score=0;//得分
    boolean dead=false;//是否死亡

    public void init(){
        length=3;

        snakeX[0]=525;
        snakeY[0]=275;

        snakeX[1]=500;
        snakeY[1]=275;

        snakeX[2]=475;
        snakeY[2]=275;
        dir="R";
    }
    public GamePanel(){
        init();
        //将焦点定在当前面板
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter(){
            @Override  //监听键盘事件
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int kc=e.getKeyCode();
                System.out.println(kc);
                if(!dead){
                    if(kc== KeyEvent.VK_SPACE){//32是空格键
                        start=!start;
                        repaint();//重绘
                    }
                }else{
                    init();
                    dead=false;
                }

                if(kc==KeyEvent.VK_UP){
                    dir="U";
                }
                if(kc==KeyEvent.VK_DOWN){
                    dir="D";
                }
                if(kc==KeyEvent.VK_LEFT){
                    dir="L";
                }
                if(kc==KeyEvent.VK_RIGHT){
                    dir="R";
                }
            }
        });
        tm=new Timer(150,new ActionListener(){
            /*
            事件监听器，每150秒监听是否发生事件
            具体动作放入actionPerformed方法中
             */
            @Override
            public void actionPerformed(ActionEvent e){
                if(start && !dead){//开始状态
                    for(int i=length-1;i>0;i--){
                        snakeX[i]=snakeX[i-1];
                        snakeY[i]=snakeY[i-1];
                    }
                    if("R"== dir){
                        snakeX[0]+=25;
                    }
                    if("L"==dir){
                        snakeX[0]-=25;
                    }
                    if(dir=="U"){
                        snakeY[0]-=25;
                    }
                    if(dir=="D"){
                        snakeY[0]+=25;
                    }

                    if(snakeX[0]>750){
                        snakeX[0]=25;
                    }
                    if(snakeY[0]>725){
                        snakeY[0]=75;
                    }
                    if(snakeX[0]<25){
                        snakeX[0]=750;
                    }
                    if(snakeY[0]<75){
                        snakeY[0]=725;
                    }
                    if(snakeX[0]==foodX && snakeY[0]==foodY){//吃到食物
                        length++;
                        //必须是25的倍数 X:25-725=(1-29)*25   Y:75-750=(3-30)*25
                        foodX=((int)(Math.random()*29)+1)*25;
                        foodY=(new Random().nextInt(27)+3)*25;//Random().nextInt(29)=[0,28) [0,27]
                        System.out.println(foodX +" "+foodY);
                        score+=10;
                    }
                    for(int i=1;i<length;i++){
                        if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                            dead=true;
                        }
                    }
                    repaint();
                }
            }
        });
        //定时器要启动
        tm.start();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(new Color(255, 220, 226));
        //画头部图片 四个参数，this指当前面板 ，g指的是使用的画笔，x,y指的就是以面板左上角为原点的坐标
        Pics.headerIcon.paintIcon(this,g,10,10);
        g.setColor(new Color(218, 255, 241, 255));
        //画一个矩形：
        g.fillRect(10,70,770,685);
        //画小蛇
        //画蛇头
        if("R".equals(dir)){
            Pics.rightIcon.paintIcon(this,g,snakeX[0],snakeY[0]);//图标的左上角 会被放置在 (snakeX[0], snakeY[0]) 坐标处。
        }
        if("L".equals(dir)){
            Pics.leftIcon.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("U".equals(dir)){
            Pics.upIcon.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("D".equals(dir)){
            Pics.downIcon.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
//        Pics.bodyIcon.paintIcon(this,g,snakeX[1],snakeY[1]);
//        Pics.bodyIcon.paintIcon(this,g,snakeX[2],snakeY[2]);
        for(int i=1;i<length;i++){
            Pics.bodyIcon.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        if(start==false){
            //设置画笔颜色
            g.setColor(new Color(255, 184, 99));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //参数：文字内容，x轴坐标，y轴坐标
            g.drawString("点击空格开始游戏",250,400);
        }
        //统计积分
        g.setColor(new Color(255, 184, 99));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        //参数：文字内容，x轴坐标，y轴坐标
        g.drawString("得分："+score,15,95);
        //画食物
        Pics.foodIcon.paintIcon(this,g,foodX,foodY);
        if(dead){
            g.setColor(new Color(255, 184, 99));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("你已经死亡，游戏结束！",250,400);
            score=0;
            tm.stop();
        }
    };

//直接点击jar包就可以运行
}
