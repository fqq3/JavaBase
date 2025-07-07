package elsfangkuai;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
//import java.applet.*;
//import java.lang.String.*;
//import java.lang.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Block extends JPanel implements ActionListener,KeyListener//应该是继承JPanel
{ 	
	
	Color mypink = new Color(255,228,225); // 使用RGB值创建自定义颜色，这里是橙色
	Color myye = new Color(255,255,224);//
	Color myblue = new Color(191,239,255);
	Color myp = new Color(191,170, 255);//，230,230,250
	Color mygreen = new Color(193,255,193);
	Color myor = new Color(250,235,215);
	Color mypp = new Color(220,255,220);//240 255 240
	static int locationx=0;
	static int locationy=0;
	
	static Button but[] = new Button[6];
	Font chineseFont = new Font("Microsoft YaHei", Font.PLAIN, 12);
	static Button noStop = new Button("Resume");
	//noStop.setFont(new Font("宋体", Font.PLAIN, 20));
	static Label scoreLab = new Label("   score");
	static Label infoLab = new Label("     tip");
	static Label speedLab = new Label("   level");
//	static Label bottomLab = new Label(" ");//地块
	static Label colorbr= new Label(" ");//填充右边
	
	static Label scoreTex = new Label(" 0");
	static Label infoTex = new Label(" ");
	static Label speedTex = new Label(" 1");
	static Label bottomTex = new Label("location:"+locationx+" ,"+locationy);//地块
	

	static JFrame jf = new JFrame();
	static MyTimer timer; 
	static ImageIcon icon=new ImageIcon("D:\\pictures\\image\\els.png");
	static JMenuBar mb = new JMenuBar();//////
	//mb.setBackground(myye);
	//static JMenu menu0 = new JMenu("更多");
	static JMenu menu1 = new JMenu("帮  助 ");
	//static JMenuItem mi0 = new JMenuItem("展示位置");
	//static JMenuItem mi1 = new JMenuItem("退  出");
	static JMenuItem mi1_0 = new JMenuItem("关  于");
    static JDialog dlg_1;
	static JTextArea dlg_1_text = new JTextArea();
	static int startSign = 0;//游戏开始标志 0 未开始 1 开始 2 暂停
	static String butLab[] = {"Start Game", "Restart", "Decrease Level", "Increase Level", "Pause Game", "Exit Game"};
	static int game_body[][] = new int[30][20];//19，10
	static int game_sign_x[] = new int[4];//用于记录4个方格的水平位置
	static int game_sign_y[] = new int[4];//用于记录4个方格的垂直位置
	static boolean downSign = false;//是否落下
	static boolean showlocation= false;//是否展示位置
	static int blockNumber = 1;//砖块的编号
	static int gameScore = 0;//游戏分数
	static int speedMark = 1;
	
	public static void main(String args[]) 
	{	
		
		Color mypink = new Color(255,192,203); // 使用RGB值创建自定义颜色，这里是橙色
		Color myye = new Color(255,255,224);
		Color myblue = new Color(191,239,255);
		
		//System.setProperty("file.encoding", "UTF-8");
	//java.nio.charset.Charset.defaultCharset();
	
		//System.out.println(System.getProperty("file.encoding"));////
		//Font chineseFont = new Font("Microsoft YaHei", Font.PLAIN, 12);
		Block myBlock = new Block();
		
		mb.setBackground(myye);//jmenubar颜色更改只能在main函数里
		
		mb.add(menu1);//将两个菜单 menu0（“更多”）和 menu1（“帮助”）添加到菜单栏 mb
		
		menu1.add(mi1_0);
		mi1_0.setBackground(myye);
	    jf.setJMenuBar(mb);//将菜单栏 mb 设置为主窗口 jf 的菜单栏
	    
	    myBlock.init();
	    jf.add(myBlock);
	    jf.setSize(1000,950);
		jf.setResizable(false);
		jf.setTitle("俄罗斯方块");
		jf.setIconImage(icon.getImage());
		jf.setLocation(200,50);
		jf.setVisible(true);////////////////////////////
		timer = new MyTimer(myBlock); //启动线程
       timer.setDaemon(true); 
       timer.start();
       timer.suspend();
	}
	public void init()
	
	
	{
   	setLayout(null);
   	for(int i = 0;i < 6;i++)
   	{
   		but[i] = new Button(butLab[i]);
   		add(but[i]);
   		but[i].addActionListener(this);
   		but[i].addKeyListener(this);
   		but[i].setBounds(700,(400 + 50 * i),160,25);
   		but[i].setFont(chineseFont); //////
   		but[i].setBackground(mypp);
   	}
   	
   	//标签和文本框组件添加到当前容器:
       add(scoreLab);
//       scoreLab.setFont(chineseFont);
       add(scoreTex);
       
       add(speedLab);
       
       add(speedTex);
       add(infoLab);
       add(infoTex);
       
       //add(bottomLab);//地块位置
       add(bottomTex);
       //bottomLab.setFont(chineseFont);
       add(colorbr);
       scoreLab.setBounds(695,30,55,30);//scoreLab 的位置和大小。
       scoreLab.setBackground(myye);
       scoreTex.setBounds(750,30,160,30);//scoreTex 的位置和大小。
       scoreTex.setBackground(mypink);//设置 scoreTex 的背景颜色为。
		
       speedLab.setBounds(695,75,55,30);//同上
       speedLab.setBackground(myye);
       speedTex.setBounds(750,75,160,30);
       speedTex.setBackground(mypink);
		
       infoLab.setBounds(695,120,55,30);//同上
       infoLab.setBackground(myye);
       infoTex.setBounds(750,120,160,30);
       infoTex.setBackground(mypink);
       
       
       //bottomLab.setBounds(0,780,50,120);//同上
       //bottomLab.setBackground(myp);
       bottomTex.setBounds(0,780,600,120);
       bottomTex.setBackground(myp);
		
		but[1].setEnabled(false);//禁用 but 数组中的第 1 和第 4 个按钮。
		but[4].setEnabled(false);
		
		noStop.setBounds(700,600,160,25);
		noStop.setBackground(myp);
		noStop.addActionListener(this);//为 noStop 按钮添加一个动作事件监听器。
		noStop.addKeyListener(this);//添加一个键盘事件监听器。
		
		//mi0.addActionListener(this);// mi0、mi1 和 mi1_0 添加动作事件监听器。
		//mi1.addActionListener(this);
		mi1_0.addActionListener(this);
		
		num_csh_game();//始化游戏数字缓存。
		rand_block();//调用 rand_block 用于生成随机方块
   }
   
   public void actionPerformed(ActionEvent e)
   {
   	if(e.getSource() == but[0])//开始游戏
   	{
   		startSign = 1;
   		infoTex.setText("Game Started!");
   		but[0].setEnabled(false);
   		but[1].setEnabled(true);
		but[4].setEnabled(true);
		timer.resume(); 
   	}
   	if(e.getSource() == but[1])//重新开始游戏
   	{
   		startSign = 0;
   		gameScore = 0;
   		locationx=0;
   		locationy=0;
   		timer.suspend();
   		num_csh_restart();
   		repaint();
   		rand_block();
   		scoreTex.setText("0");
   		infoTex.setText("New Game!");
   		but[0].setEnabled(true);
   		but[1].setEnabled(false);
		    but[4].setEnabled(false);
   	}
   	if(e.getSource() == but[2])//降低级数
   	{
   		infoTex.setText("Decrease Level!");
   		speedMark--;
   		if(speedMark <= 1)
   		{
   			speedMark = 1;
   			infoTex.setText("Minimum Level Reached!");
   		}
   		speedTex.setText(speedMark + "");
   	}
   	if(e.getSource() == but[3])//提高级数
   	{
   		infoTex.setText("Increase Level!");
   		speedMark++;
   		if(speedMark >= 9)
   		{
   			speedMark = 9;
   			infoTex.setText("Maximum Level Reached!");
   		}
   		speedTex.setText(speedMark + "");
   	}
   	if(e.getSource() == but[4])//游戏暂停
   	{
   		this.add(noStop);
   		this.remove(but[4]);
   		infoTex.setText("Game Paused!");
   		timer.suspend();
   	}
   	if(e.getSource() == noStop)//取消暂停
   	{
   		this.remove(noStop);
   		this.add(but[4]);
   		infoTex.setText("Game Resumed!");
   		timer.resume();
   	}
   	if(e.getSource() == but[5])//退出游戏||e.getSource() == mi1
   	{
   		jf.dispose();
   	}
   	
//   	if(e.getSource() == mi0) {
//   		showlocation=true;
//   		bottomLab = new Label("location");
//   		
//   		
//   	}
   	if(e.getSource() == mi1_0)//关于
   	{
   		//JOptionPane.showMessageDialog(this, "游戏操作：\n方向键左：方块左移\n方向键右：方块右移\n方向键上：方块旋转\n方向键下：方块加速下降\n空格键：方块快速到底");
   
   		dlg_1 = new JDialog(jf,"关 于");
		    try{
		    	
		        String str = new String("游戏操作：\n方向键左：方块左移\n方向键右：方块右移\n方向键上：方块旋转\n方向键下：方块加速下降\nStart Game:开始游戏\nRestart：重新开始\nDecrease Level；降低级数\nIncrease Level：提高级数\nPause Game：暂停游戏\nExit Game：退出游戏");
		        dlg_1_text.setText(str);
		        Font font = dlg_1_text.getFont();
		        Font newFont = new Font("宋体", font.getStyle(), font.getSize() * 3/2);		      
		        dlg_1_text.setFont(newFont);
		        // 调整间距（通过设置行高来间接调整间距）
		        int lineHeight = 20; // 设置行高为20像素
		        dlg_1_text.setLineWrap(true); // 设置自动换行
		        dlg_1_text.setWrapStyleWord(true); // 设置按单词换行
		        dlg_1_text.setMargin(new Insets(10, 10, 10, 10)); // 设置边距
		        
		        }
		        catch(Exception g){g.printStackTrace();}
		        dlg_1_text.setEditable(false);
		        dlg_1.add(dlg_1_text);
			    dlg_1.pack();
               dlg_1.setResizable(false);
               dlg_1.setSize(400, 400);
               dlg_1.setLocation(400, 240);
               dlg_1.show();
   }
}
   
   public void rand_block()//随机产生砖块
   {
   	int num;
		num = (int)(Math.random() * 6) + 1;//产生0~6之间的随机数
		blockNumber = num;
		switch(blockNumber)
		{
			case 1: block1(); blockNumber = 1; break;
			case 2: block2(); blockNumber = 2; break;
			case 3: block3(); blockNumber = 3; break;
			case 4: block4(); blockNumber = 4; break;
			case 5: block5(); blockNumber = 5; break;
			case 6: block6(); blockNumber = 6; break;
			case 7: block7(); blockNumber = 7; break;
		}
   } 
   
   public void change_body(int blockNumber)//改变砖块状态
   {
   	dingwei();
   	if(blockNumber == 1&&downSign == false)//变换长条2种情况
   	{
   		if(game_sign_y[0] == game_sign_y[1]&&game_sign_y[3] <= 27)//说明长条是横着的
   		{
   			if(game_body[game_sign_y[0] - 1][game_sign_x[0] + 1] != 2&&game_body[game_sign_y[3] + 2][game_sign_x[3] - 2] != 2)
   			{
   				num_csh_game();
   			    game_body[game_sign_y[0] - 1][game_sign_x[0] + 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1]] = 1;
   			    game_body[game_sign_y[2] + 1][game_sign_x[2] - 1] = 1;
   			    game_body[game_sign_y[3] + 2][game_sign_x[3] - 2] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   		if(game_sign_x[0] == game_sign_x[1]&&game_sign_x[0] >= 1&&game_sign_x[3] <= 17)//说明长条是竖着的
   		{
   			if(game_body[game_sign_y[0] + 1][game_sign_x[0]-1] != 2&&game_body[game_sign_y[3] - 2][game_sign_x[3] + 2] != 2)
   			{
   				num_csh_game();
   			    game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1]]=1;
   			    game_body[game_sign_y[2] - 1][game_sign_x[2] + 1] = 1;
   			    game_body[game_sign_y[3] - 2][game_sign_x[3] + 2] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   	}
   	if(blockNumber == 3&&downSign == false)//变换转弯1有4种情况
   	{
   		if(game_sign_x[0] == game_sign_x[1]&&game_sign_x[0] == game_sign_x[2]&&game_sign_y[2] == game_sign_y[3]&&game_sign_x[0] >= 1)
   		{
   			if(game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] != 2&&game_body[game_sign_y[2] - 1][game_sign_x[2] + 1] != 2&&game_body[game_sign_y[3] - 2][game_sign_x[3]] != 2)
   			{
   			    num_csh_game();
   			    game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1]] = 1;
   			    game_body[game_sign_y[2] - 1][game_sign_x[2] + 1] = 1;
   			    game_body[game_sign_y[3] - 2][game_sign_x[3]] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   		if(game_sign_y[1] == game_sign_y[2]&&game_sign_y[2] == game_sign_y[3]&&game_sign_x[0] == game_sign_x[3]&&game_sign_y[1] <= 28)
   		{
   			if(game_body[game_sign_y[0]][game_sign_x[0] - 2] != 2&&game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] != 2&&game_body[game_sign_y[3] - 1][game_sign_x[3] - 1] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0]][game_sign_x[0] - 2] = 1;	
   			    game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2]] = 1;
   			    game_body[game_sign_y[3] - 1][game_sign_x[3] - 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   		if(game_sign_x[1] == game_sign_x[2]&&game_sign_x[1] == game_sign_x[3]&&game_sign_y[0] == game_sign_y[1]&&game_sign_x[3] <= 18)
   		{
   			if(game_body[game_sign_y[0] + 2][game_sign_x[0]] != 2&&game_body[game_sign_y[1] + 1][game_sign_x[1] - 1] != 2&&game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 2][game_sign_x[0]] = 1;	
   			    game_body[game_sign_y[1] + 1][game_sign_x[1] - 1] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2]] = 1;
   			    game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   		if(game_sign_y[0] == game_sign_y[1]&&game_sign_y[1] == game_sign_y[2]&&game_sign_x[0] == game_sign_x[3])
   		{
   			if(game_body[game_sign_y[0] + 1][game_sign_x[0] + 1] != 2&&game_body[game_sign_y[2] - 1][game_sign_x[2] - 1] != 2&&game_body[game_sign_y[3]][game_sign_x[3] + 2] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 1][game_sign_x[0] + 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1]] = 1;
   			    game_body[game_sign_y[2] - 1][game_sign_x[2] - 1] = 1;
   			    game_body[game_sign_y[3]][game_sign_x[3] + 2] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   	}
   	if(blockNumber == 4&&downSign == false)//变换转弯2有4种情况
   	{
   		if(game_sign_x[0] == game_sign_x[1]&&game_sign_x[0] == game_sign_x[3]&&game_sign_y[1] == game_sign_y[2]&&game_sign_x[3] <= 17)
   		{
   			if(game_body[game_sign_y[0] + 2][game_sign_x[0]] != 2&&game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] != 2&&game_body[game_sign_y[3]][game_sign_x[3] + 2] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 2][game_sign_x[0]] = 1;
   			    game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2]] = 1;
   			    game_body[game_sign_y[3]][game_sign_x[3] + 2] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   		if(game_sign_y[1] == game_sign_y[2]&&game_sign_y[1] == game_sign_y[3]&&game_sign_x[0] == game_sign_x[2])
   		{
   			if(game_body[game_sign_y[1]][game_sign_x[1] + 2] != 2&&game_body[game_sign_y[2] - 1][game_sign_x[2] + 1] != 2&&game_body[game_sign_y[3] - 2][game_sign_x[3]] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0]][game_sign_x[0]] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1] + 2] = 1;
   			    game_body[game_sign_y[2] - 1][game_sign_x[2] + 1] = 1;
   			    game_body[game_sign_y[3] - 2][game_sign_x[3]] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   		if(game_sign_x[0] == game_sign_x[2]&&game_sign_x[0] == game_sign_x[3]&&game_sign_y[1] == game_sign_y[2]&&game_sign_x[0] >= 2)
   		{
   			if(game_body[game_sign_y[0]][game_sign_x[0] - 2] != 2&&game_body[game_sign_y[2] - 1][game_sign_x[2] - 1] != 2&&game_body[game_sign_y[3] - 2][game_sign_x[3]] != 2)
   			{
       			num_csh_game();
   		    	game_body[game_sign_y[0]][game_sign_x[0] - 2] = 1;
   		    	game_body[game_sign_y[1]][game_sign_x[1]] = 1;
   		    	game_body[game_sign_y[2] - 1][game_sign_x[2] - 1] = 1;
   			    game_body[game_sign_y[3] - 2][game_sign_x[3]] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   		if(game_sign_y[0] == game_sign_y[1]&&game_sign_y[0] == game_sign_y[2]&&game_sign_x[1] == game_sign_x[3]&&game_sign_y[0] <= 27)
   		{
   			if(game_body[game_sign_y[0] + 2][game_sign_x[0]] != 2&&game_body[game_sign_y[1] + 1][game_sign_x[1] - 1] != 2&&game_body[game_sign_y[2]][game_sign_x[2] - 2] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 2][game_sign_x[0]] = 1;
   			    game_body[game_sign_y[1] + 1][game_sign_x[1] - 1] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2] - 2] = 1;
   			    game_body[game_sign_y[3]][game_sign_x[3]] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}	
   		}
   	}
   	if(blockNumber == 5&&downSign == false)//变换转弯3有4种情况
   	{
   		if(game_sign_x[0] == game_sign_x[2]&&game_sign_x[2] == game_sign_x[3]&&game_sign_y[0] == game_sign_y[1]&&game_sign_x[1] >= 2)
   		{
   			if(game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] != 2&&game_body[game_sign_y[1]][game_sign_x[1] - 2] != 2&&game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1] - 2] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2]] = 1;
   			    game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   		if(game_sign_y[1] == game_sign_y[2]&&game_sign_y[2] == game_sign_y[3]&&game_sign_x[0] == game_sign_x[1]&&game_sign_y[0] <= 27)
   		{
   			if(game_body[game_sign_y[0] + 2][game_sign_x[0]] != 2&&game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] != 2&&game_body[game_sign_y[3] - 1][game_sign_x[3] - 1] != 2)
   			{
      			    num_csh_game();
   			    game_body[game_sign_y[0] + 2][game_sign_x[0]] = 1;
   		     	game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] = 1;
   		    	game_body[game_sign_y[2]][game_sign_x[2]] = 1;
   			    game_body[game_sign_y[3] - 1][game_sign_x[3] - 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   		if(game_sign_x[0] == game_sign_x[1]&&game_sign_x[1] == game_sign_x[3]&&game_sign_y[2] == game_sign_y[3])
   		{
   			if(game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] != 2&&game_body[game_sign_y[2]][game_sign_x[2] + 2] != 2&&game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1]] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2] + 2] = 1;
   			    game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   		if(game_sign_y[0] == game_sign_y[1]&&game_sign_y[1] == game_sign_y[2]&&game_sign_x[2] == game_sign_x[3])
   		{
   			if(game_body[game_sign_y[0] + 1][game_sign_x[0] + 1] != 2&&game_body[game_sign_y[2] - 1][game_sign_x[2] - 1] != 2&&game_body[game_sign_y[3] - 2][game_sign_x[3]] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 1][game_sign_x[0] + 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1]] = 1;
   			    game_body[game_sign_y[2] - 1][game_sign_x[2] - 1] = 1;
   			    game_body[game_sign_y[3] - 2][game_sign_x[3]] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   	}
   	if(blockNumber == 6&&downSign == false)//变换两层砖块1的2种情况
   	{
   		if(game_sign_x[0] == game_sign_x[2]&&game_sign_x[0] >= 2)
   		{
   			if(game_body[game_sign_y[0]][game_sign_x[0] - 2] != 2&&game_body[game_sign_y[2] - 1][game_sign_x[2] -1 ] != 2&&game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0]][game_sign_x[0] - 2] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1]] = 1;
   			    game_body[game_sign_y[2] - 1][game_sign_x[2] - 1] = 1;
   			    game_body[game_sign_y[3] - 1][game_sign_x[3] + 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   		if(game_sign_y[0] == game_sign_y[1]&&game_sign_y[3] <= 28)
   		{
   			if(game_body[game_sign_y[0]][game_sign_x[0] + 2] != 2&&game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] != 2&&game_body[game_sign_y[3] + 1][game_sign_x[3] - 1] != 2)
   			{
      			    num_csh_game();
   			    game_body[game_sign_y[0]][game_sign_x[0] + 2] = 1;
   			    game_body[game_sign_y[1] + 1][game_sign_x[1] + 1] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2]] = 1;
   			    game_body[game_sign_y[3] + 1][game_sign_x[3] - 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   	}
   	if(blockNumber == 7&&downSign == false)//变换两层砖块2的2种情况
   	{
   		if(game_sign_x[0] == game_sign_x[1]&&game_sign_x[0] <= 27)
   		{
   			if(game_body[game_sign_y[0]][game_sign_x[0] + 2] != 2&&game_body[game_sign_y[1] - 1][game_sign_x[1] + 1] != 2&&game_body[game_sign_y[3] - 1][game_sign_x[3] - 1] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0]][game_sign_x[0] + 2] = 1;
   			    game_body[game_sign_y[1] - 1][game_sign_x[1] + 1] = 1;
   			    game_body[game_sign_y[2]][game_sign_x[2]] = 1;
   			    game_body[game_sign_y[3] - 1][game_sign_x[3] - 1] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   		if(game_sign_y[0] == game_sign_y[1]&&game_sign_y[2] <= 28)
   		{
   			if(game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] != 2&&game_body[game_sign_y[1]][game_sign_x[1] - 2] != 2&&game_body[game_sign_y[2] + 1][game_sign_x[2] + 1] != 2)
   			{
       			num_csh_game();
   			    game_body[game_sign_y[0] + 1][game_sign_x[0] - 1] = 1;
   			    game_body[game_sign_y[1]][game_sign_x[1] - 2] = 1;
   			    game_body[game_sign_y[2] + 1][game_sign_x[2] + 1] = 1;
   			    game_body[game_sign_y[3]][game_sign_x[3]] = 1;
   			    infoTex.setText("Game in Progress!");
   			    repaint();
   			}
   		}
   	}
   }
   
   public void num_csh_game()//数组清零 用于将游戏数组 game_body 中的值重置
   {
   	for(int i = 0;i < 30;i++)//开始一个外层 for 循环，循环变量 i 从 0 到 18，用于遍历 game_body 数组的行（共 19 行）。
   	{
   		for(int j = 0;j < 20;j++)//遍历 game_body 数组的列（共 10 列）。
   		{
   			if(game_body[i][j] == 2)//如果 game_body 数组中位于 [i][j] 位置的元素等于 2，保持 game_body[i][j] 的值为 2。

   			{
   				game_body[i][j] = 2;
   			}
   			else
   			{//不等于 2，则将其重置为 0
   				game_body[i][j] = 0;
   			}
   		}
   	}
   }
   
   public void num_csh_restart()//重新开始时数组清零
   {
   	for(int i = 0;i < 30;i++)
   	{
   		for(int j = 0;j < 20;j++)
   		{
   			game_body[i][j] = 0;//清空所有位置
   		}
   	}
   }
   
   public void keyTyped(KeyEvent e){}    
   
   public void keyPressed(KeyEvent e)
   {
   	if(e.getKeyCode() == KeyEvent.VK_DOWN&&startSign == 1)//处理下键
   	{
   		this.down();
   	}
   	if(e.getKeyCode() == KeyEvent.VK_LEFT&&startSign == 1)//处理左键
   	{
   		this.left();
   	}
   	if(e.getKeyCode() == KeyEvent.VK_RIGHT&&startSign == 1)//处理右键
   	{
   		this.right();
   	}
   	if(e.getKeyCode() == KeyEvent.VK_UP&&startSign == 1)//处理上键转换
   	{
   		this.change_body(blockNumber);
   	}
   	if(startSign == 0)
   	{
   		infoTex.setText("Game not started or already over!");
   	}
   }
   
   public void keyReleased(KeyEvent e){}
   
   public void paint(Graphics g)//接收一个 Graphics 对象 g 作为参数，用于绘制图形。
	{
		g.setColor(mypink);//绘图颜色为粉色
		g.fill3DRect(0,0,600,900,true);//绘制3D矩形，左上角坐标为 (0, 0)，宽度为 600，高度为 900，并且绘制凸起效果的3D矩形背景。
		g.setColor(myor);
		g.fill3DRect(600,00,600,900,true);
		for(int i = 0;i < 30;i++)
		{
			for(int j = 0;j < 20;j++)
			{
				if(game_body[i][j] == 1)//若game_body [i][j] 等于 1，
				
				{
				    g.setColor(myblue);//将绘图颜色设置为蓝色。
		            g.fill3DRect(30*j,30*(i-4),30,30,true);//绘制一个填充的3D矩形，左上角坐标为 (30 * j, 30 * (i - 4))，宽度和高度均为 30，并且绘制凸起效果的3D矩形。
		             locationx=j;
		             locationy=25-(i-4);
		             bottomTex.setText("location:"+String.valueOf(locationx)+","+String.valueOf(locationy));
		            //System.out.println("小方块的位置 :"+30*j+" "+30*(i-4));

				}
				if(game_body[i][j] == 2)//等于 2。
				{
				    g.setColor(mygreen);//将绘图颜色设置为绿色
		            g.fill3DRect(30*j,30*(i-4),30,30,true);//绘制矩形
		            //System.out.println("固定的 "+30*j+" "+30*(i-4));
				}
			}
		}	
	}
	
	public void left()//向左移动
	{
		int sign = 0;//标记是否可以向左移动
		dingwei();//更新或获取当前方块的位置信息。
		for(int k = 0;k < 4;k++)//遍历当前方块的四个方格
		{
			if(game_sign_x[k] == 0||game_body[game_sign_y[k]][game_sign_x[k] - 1] == 2)
			{
				sign = 1;//检查当前方块的每个方格是否位于最左边的列（game_sign_x[k] == 0）。
						//或者检查当前方格左边的格子是否已经被占用（game_body[game_sign_y[k]][game_sign_x[k] - 1] == 2）。
						//如果上述任一条件为真，将 sign 设置为 1，表示不能向左移动。
			}
		}
		if(sign == 0&&downSign == false) 
		{//检查 sign 是否仍然为 0（表示可以向左移动），并且 downSign 是否为 false（表示当前方块还未落下）。
			num_csh_game();//重置游戏数组 game_body，但保留值为 2 的元素（已固定的方块）。
			for(int k = 0;k < 4;k++)
		    {//将当前方块的每个方格在游戏数组中向左移动一格，即将当前位置左边的格子设置为 1。
		    	game_body[game_sign_y[k]][game_sign_x[k] - 1] = 1;
		    }
		    infoTex.setText("Move left!");
		    repaint();
		}
	}
	
	public void right()//向右移动
	{
		int sign = 0;
		dingwei();
		for(int k = 0;k < 4;k++)
		{
			if(game_sign_x[k] == 20||game_body[game_sign_y[k]][game_sign_x[k] + 1] == 2)
			{
				sign = 1;
			}
		}
		if(sign == 0&&downSign == false)
		{
			num_csh_game();
			for(int k = 0;k < 4;k++)
		    {
		    	game_body[game_sign_y[k]][game_sign_x[k] + 1] = 1;
		    }
		    infoTex.setText("Move right!");
		    repaint();
		}
	}
	
	public void down()//下落
	{
		int sign = 0;// 标记是否到达底部或者碰到其他方块
		dingwei();
		for(int k = 0;k < 4;k++)
		{
			if(game_sign_y[k] == 29||game_body[game_sign_y[k] + 1][game_sign_x[k]] == 2)//如果方块的底部到达游戏区域的底部，或者下方有其他方块
			{
				showlocation=false;
				sign = 1;
				downSign = true;
				changeColor();
				cancelDW();
				getScore();
				if(game_over() == false)
				{
				    rand_block();
				    repaint();
				}
			}
		}
		if(sign == 0)//否到达底部或者碰到其他方块
		{	showlocation=true;
			num_csh_game();
		    for(int k = 0;k < 4;k++)
		    {
		        game_body[game_sign_y[k] + 1][game_sign_x[k]] = 1;
		    }
		    infoTex.setText("Game in Progress!!");
		    repaint();
		}
	}
	
	public boolean game_over()//判断游戏是否结束
	{
		int sign=0;//标记游戏是否结束
		for(int i = 0;i < 20;i++)//用于检测是否有方块到达顶部
		{
			if(game_body[4][i] == 2)
			{
				sign = 1;
			}
		}
		if(sign == 1)
		{
			infoTex.setText("Game over!");
			changeColor();//用于改变界面的颜色以表示游戏结束（
			repaint();//重绘组件以显示游戏结束的状态。
			startSign = 0;//startSign 设置为 0，表示游戏停止
			timer.suspend();
			return true;//。
		}
		else
		return false;//没有结束。
	}
	
	public void getScore()//满行消除方法
	{
		for(int i = 0;i < 30;i++)
		{
			int sign = 0;//记录当前行被填满的方块数量。
			for(int j = 0;j < 20;j++)
			{
				if(game_body[i][j] == 2)
				{//如果当前格子是否被固定方块占据，将 sign 增加 1。
					sign++;
				}
			}
			if(sign == 20) //是否当前行的所有格子都被填满）
			{
				gameScore += 10;//gameScore 增加 100。
				scoreTex.setText(gameScore+"");
				infoTex.setText("Congratulations, you scored!");
				for(int j = i;j >= 1;j--)
				{
					for(int k = 0;k < 20;k++)
				    {
					    game_body[j][k] = game_body[j - 1][k];
					    //将上面一行的内容复制到当前行，以清除当前行并将上面的行向下移动。
				    }
				}
			}
		}
	}
		
	public void changeColor()//给已经落下的块换色
	{
		downSign = false;// downSign 变量设置为 false，表示当前方块不再下落。
		for(int k = 0;k < 4;k++)
		{
		    game_body[game_sign_y[k]][game_sign_x[k]] = 2;
		    //将当前方块 game_body 数组中的值设置为 2，已经固定，绿色
		}
	}
	
	public void dingwei()//确定其位置
	{
		int k = 0;//记录当前方块的格子数目。
		cancelDW();//将定位数组初始化。
		for(int i = 0;i < 30;i++)
		{
			for(int j = 0;j < 20;j++)
			{
				if(game_body[i][j] == 1)
				{//如果当前格子属于当前活动方块，将当前格子的列索引 j 赋值给 game_sign_x[k]，行索引 i 赋值给 game_sign_y[k]。将 k 增加 1，记录下一个方块的位置。
					game_sign_x[k] = j;
					game_sign_y[k] = i;
					k++;
				}
			}
		}
	}
	
	public void cancelDW()//将定位数组初始化
	{
		for(int k = 0;k < 4;k++)//遍历定位数组的所有元素
		{
			game_sign_x[k] = 0;
			game_sign_y[k] = 0;
		}
	}
	
	public void block1()//长条
	{
		game_body[0][4] = 1;
		game_body[1][4] = 1;
		game_body[2][4] = 1;
		game_body[3][4] = 1;
	}
	
	public void block2()//正方形
	{
		game_body[3][4] = 1;
		game_body[2][4] = 1;
		game_body[3][5] = 1;
		game_body[2][5] = 1;
	}
	public void block3()//3加1(下)
	{
		game_body[1][4] = 1;
		game_body[2][4] = 1;
		game_body[3][4] = 1;
		game_body[3][5] = 1;
	}
	public void block4()//3加1(中)
	{
		game_body[1][4] = 1;
		game_body[2][4] = 1;
		game_body[3][4] = 1;
		game_body[2][5] = 1;
	}
	public void block5()//3加1(上)
	{
		game_body[1][4] = 1;
		game_body[2][4] = 1;
	    game_body[3][4] = 1;
		game_body[1][5] = 1;
	}
	public void block6()//转折1
	{
		game_body[1][5] = 1;
		game_body[2][5] = 1;
		game_body[2][4] = 1;
		game_body[3][4] = 1;
	}
	public void block7()//转折2
	{
		game_body[1][4] = 1;
		game_body[2][4] = 1;
		game_body[2][5] = 1;
		game_body[3][5] = 1;
	}
}

//定时线程 
class MyTimer extends Thread
{
	Block myBlock; //声明一个 Block 类型的成员变量,引用游戏中的方块对象
   public MyTimer(Block myBlock)//构造方法
   {
   	this.myBlock = myBlock;
   }
   public void run()//线程执行的入口点，重写了 Thread 类的 run 方法。
   {
       while(myBlock.startSign == 1)//只要 myBlock.startSign 等于 1，循环将继续执行。startSign 是一个标志位，表示游戏是否正在进行。
       {
       	try{
       	    sleep((10-myBlock.speedMark + 1)*100); //使当前线程休眠一段时间，休眠时间由 (10 - myBlock.speedMark + 1) * 100 计算得出，单位是毫秒。
       	    myBlock.down();//使方块向下移动一格
           }
           catch(InterruptedException e){}// 异常,线程在休眠期间被中断。
       } 
  }
} 


//class MyTimer extends Thread {
//    Block myBlock; 
//    private boolean paused = false;
//    
//    public MyTimer(Block myBlock) {
//        this.myBlock = myBlock;
//    }
//    
//    public synchronized void pauseTimer() {
//        paused = true;
//    }
//    
//    public synchronized void resumeTimer() {
//        paused = false;
//        notify();
//    }
//    
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (this) {
//                while (paused) {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                    }
//                }
//            }
//            
//            if (myBlock.startSign == 1) {
//                try {
//                    sleep((10 - myBlock.speedMark + 1) * 100); 
//                    myBlock.down();
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
//    }
//}
//


