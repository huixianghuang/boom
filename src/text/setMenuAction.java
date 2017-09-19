package text;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.Highlighter;

import sun.security.util.Debug;
import jdk.internal.dynalink.beans.StaticClass;
import jdk.nashorn.internal.objects.annotations.Setter;

public class setMenuAction {
	static JMenuBar menuBar;             //菜单栏
	static JMenu gameJMenu, helpJMenu;   //“游戏”菜单，“帮助”菜单
	
	static JMenuItem gameItem1, gameItem2, gameItem3, gameItem4, gameItem5,  // "游戏"菜单项
	          gameItem6, gameItem7, gameItem8, gameItem9;
	static JMenuItem helpItem1, helpItem2;                                   // “帮助”菜单项
	
	static JLabel label1, label2, label3, label4, label5, label6;           //扫雷英雄榜组件
	static JButton jButton1, jButton2;
	static int CheckColor;    //标记颜色是否改变，为0则为默认颜色
	public setMenuAction() {
		
//		创建菜单栏以及各组件
	    menuBar = new JMenuBar();
		gameJMenu = new JMenu("游戏");
		helpJMenu = new JMenu("帮助");
//		
//		生成菜单项控件并设置快捷键
//		游戏菜单
		gameItem1 = new JMenuItem("开局");
		gameItem1.setAccelerator(KeyStroke.getKeyStroke('N'));
		gameItem1.addActionListener(new listner());
		
		gameItem2 = new JMenuItem("初级");
		gameItem2.setAccelerator(KeyStroke.getKeyStroke('B'));
		gameItem2.addActionListener(new listner());
		
		gameItem3 = new JMenuItem("中级");
		gameItem3.setAccelerator(KeyStroke.getKeyStroke('I'));
		gameItem3.addActionListener(new listner());
		
		gameItem4 = new JMenuItem("高级");
		gameItem4.setAccelerator(KeyStroke.getKeyStroke('E'));
		gameItem4.addActionListener(new listner());
		
		gameItem5 = new JMenuItem("自定义");
		gameItem5.setAccelerator(KeyStroke.getKeyStroke('C'));
		gameItem5.addActionListener(new listner());
		
	/*	gameItem6 = new JMenuItem("标记");
		gameItem6.setAccelerator(KeyStroke.getKeyStroke('M'));
		gameItem6.addActionListener(new listner());
		*/
		gameItem7 = new JMenuItem("颜色");
		gameItem7.setAccelerator(KeyStroke.getKeyStroke('L'));
		gameItem7.addActionListener(new listner());
		
		gameItem8 = new JMenuItem("扫雷英雄榜");
		gameItem8.setAccelerator(KeyStroke.getKeyStroke('T'));
		gameItem8.addActionListener(new listner());
		
		gameItem9 = new JMenuItem("退出");
		gameItem9.setAccelerator(KeyStroke.getKeyStroke('X'));
		gameItem9.addActionListener(new listner());
		
//		帮助菜单
		helpItem1 = new JMenuItem("游戏帮助");
		helpItem1.setAccelerator(KeyStroke.getKeyStroke('H'));
		helpItem1.addActionListener(new listner());
		
		helpItem2 = new JMenuItem("关于扫雷");
		helpItem2.setAccelerator(KeyStroke.getKeyStroke('A'));
		helpItem2.addActionListener(new listner());
		
//		顺序添加菜单组件
		gameJMenu.add(gameItem1);
		gameJMenu.addSeparator();
		gameJMenu.add(gameItem2);
		gameJMenu.addSeparator();
		gameJMenu.add(gameItem3);
		gameJMenu.addSeparator();
		gameJMenu.add(gameItem4);
		gameJMenu.addSeparator();
		gameJMenu.add(gameItem5);
		gameJMenu.addSeparator();
//		gameJMenu.add(gameItem6);
//		gameJMenu.addSeparator();
		gameJMenu.add(gameItem7);
		gameJMenu.addSeparator();
		gameJMenu.add(gameItem8);
		gameJMenu.addSeparator();
		gameJMenu.add(gameItem9);
		
		helpJMenu.add(helpItem1);
		helpJMenu.addSeparator();
		helpJMenu.add(helpItem2);
		
//		往菜单条添加菜单
		menuBar.add(gameJMenu);
		menuBar.add(helpJMenu);
		
//		扫雷英雄榜组件初始化
		label1 = new JLabel("初级： "+"999"+"秒");
		label2 = new JLabel("中级： "+"999"+"秒");
		label3 = new JLabel("高级： "+"999"+"秒");
		label4 = new JLabel("匿名");
		label5 = new JLabel("匿名");
		label6 = new JLabel("匿名");
		
		jButton1 = new JButton("重新计分");
//		jButton1.addActionListener(new listner());
		jButton1.setBackground(new Color(245, 245, 245));
		jButton1.setPreferredSize(new Dimension(80, 20));
		jButton1.setMargin(new java.awt.Insets(3, 3, 3, 3));
		
		jButton2 = new JButton("确定");
//		jButton2.addActionListener(new listner());
		jButton2.setBackground(new Color(245, 245, 245));
		jButton2.setPreferredSize(new Dimension(80, 20));
		jButton2.setMargin(new java.awt.Insets(3, 3, 3, 3));
		
		
	}
	
}

class listner implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==setMenuAction.gameItem1)//开局
		{
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(9, 9, 10);
		}
		if(e.getSource()==setMenuAction.gameItem2)//初级模式
		{
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(9, 9, 10);
		}
		if(e.getSource()==setMenuAction.gameItem3)//中级模式
		{   
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(16, 16, 40);
		}
		if(e.getSource()==setMenuAction.gameItem4)//高级模式
		{   
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(30, 16, 99);
		}
		if(e.getSource()==setMenuAction.gameItem5)//自定义
		{   
			final JFrame jFrame = new JFrame("自定义雷区");
			JLabel h, w, n;
			final JTextField ht;
			final JTextField wt;
			final JTextField nt;
			JButton yes, no;
			h = new JLabel("高度:");
			w = new JLabel("宽度:");
			n = new JLabel("雷数:");
			ht = new JTextField(6);
			wt = new JTextField(6);
			nt = new JTextField(6);
			ht.setText("9");
			wt.setText("9");
			nt.setText("10");
			
			yes = new JButton("确定");
			yes.setBackground(new Color(245, 245, 245));
			no = new JButton("取消");
			no.setBackground(new Color(245, 245, 245));
			
			Box baseBox, box1, box2, box3;
			box1 = Box.createVerticalBox();
			box1.add(h);
			box1.add(box1.createVerticalStrut(8));
			box1.add(w);
			box1.add(box1.createVerticalStrut(8));
			box1.add(n);
			box2 = Box.createVerticalBox();
			box2.add(ht);
			box2.add(box1.createVerticalStrut(8));
			box2.add(wt);
			box2.add(box1.createVerticalStrut(8));
			box2.add(nt);
			box3 = Box.createVerticalBox();
			box3.add(yes);
			box3.add(box1.createVerticalStrut(24));
			box3.add(no);
			baseBox = Box.createHorizontalBox();
			baseBox.add(box1);
			baseBox.add(box1.createHorizontalStrut(8));
			baseBox.add(box2);
			baseBox.add(box1.createHorizontalStrut(8));
			baseBox.add(box3);
			jFrame.setLayout(new FlowLayout());
			jFrame.add(baseBox);
			jFrame.setBounds(120, 125, 250, 150);
			jFrame.setVisible(true);
			jFrame.setResizable(false);
			jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			//设置按钮监听事件
			yes.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int a = Integer.parseInt(ht.getText());
					int b = Integer.valueOf(wt.getText());
					int c = Integer.valueOf(nt.getText());
					
					if( (c <= (a*b*(0.75))) && (a<=20) && (b<=40))
					{
						Text.winFrame.setVisible(false);
						Text.winFrame.remove(Text.bFlow.getFlowLayout1());
						Text.createBoomFlow(b, a, c);
						jFrame.setVisible(false);
					}
					else if (a>20) {
						JOptionPane.showMessageDialog(null, "你输入的雷区高度太大，请重新输入");
					}
					else if (b>40) {
						JOptionPane.showMessageDialog(null, "你输入的雷区宽度太大，请重新输入");
					}
					else {
						JOptionPane.showMessageDialog(null, "你输入的雷数太多，请重新输入");
					}
					
				}
			});
            no.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jFrame.setVisible(false);
					
				}
			});
		}//if(e.getSource()==setMenuAction.gameItem5)
		
	/*	if(e.getSource()==setMenuAction.gameItem6)//标记
		{   
			
		}*/
		
		if(e.getSource()==setMenuAction.gameItem7)//颜色
		{  
			if( setMenuAction.CheckColor == 0)
			{
			for(int i=0; i<boomFlow.width; i++)
			{
				for(int j=0; j<boomFlow.height; j++)
				{
					if(boomFlow.check[i][j]==0)
					boomFlow.boomButton[i][j].setBackground(Color.gray);
					setMenuAction.CheckColor = 1;
				}
			}
			}
			else {
				for(int i=0; i<boomFlow.width; i++)
				{
					for(int j=0; j<boomFlow.height; j++)
					{
						if(boomFlow.check[i][j]==0)
						boomFlow.boomButton[i][j].setBackground(null);
						setMenuAction.CheckColor = 0;
					}
				}
			}
		}
		if(e.getSource()==setMenuAction.gameItem8)//扫雷英雄榜
		{   
			final JFrame jFrame = new JFrame("扫雷英雄榜");
			jFrame.setLayout(new FlowLayout());
			jFrame.setBounds(120, 125, 250, 170);

//			Box组件
			Box baseBox, box1, box2;
			box1 = Box.createVerticalBox();
			box1.add(box1.createVerticalStrut(8));
			box1.add(setMenuAction.label1);
			box1.add(box1.createVerticalStrut(8));
			box1.add(setMenuAction.label2);
			box1.add(box1.createVerticalStrut(8));
			box1.add(setMenuAction.label3);
			box1.add(box1.createVerticalStrut(8));
			
			box2 = Box.createVerticalBox();
			box2.add(box1.createVerticalStrut(8));
			box2.add(setMenuAction.label4);
			box2.add(box1.createVerticalStrut(8));
			box2.add(setMenuAction.label5);
			box2.add(box1.createVerticalStrut(8));
			box2.add(setMenuAction.label6);
			box2.add(box1.createVerticalStrut(8));
			
			baseBox = Box.createHorizontalBox();
			baseBox.add(box1);
			baseBox.add(baseBox.createHorizontalStrut(80));
			baseBox.add(box2);
			
//			设置按钮监听
			setMenuAction.jButton1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					jFrame.setVisible(false);
					setMenuAction.label1.setText("初级： "+"999"+"秒");
					setMenuAction.label2.setText("中级： "+"999"+"秒");
					setMenuAction.label3.setText("高级： "+"999"+"秒");
					setMenuAction.label4.setText("匿名");
					setMenuAction.label5.setText("匿名");
					setMenuAction.label6.setText("匿名");
//					jFrame.setVisible(true);
				}
			});
            setMenuAction.jButton2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jFrame.setVisible(false);
				}
			});
			
			jFrame.add(baseBox);
			jFrame.add(setMenuAction.jButton1);
			jFrame.add(setMenuAction.jButton2);
			
			jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jFrame.setResizable(false);
			jFrame.setVisible(true);
			
		}
		
		
		if(e.getSource()==setMenuAction.gameItem9)//退出
		{   
			System.exit(0);//结束程序
		}
//////////<--帮助菜单事件实现-->///////////////////////////////////////////////////////
		if(e.getSource()==setMenuAction.helpItem1)
		{
			JFrame helpTip = new JFrame("游戏帮助");
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setText("\n\n  游戏的基本操作包括左键单击（Left Click）、右键单击（Right Click）、双击（Chording）三种。其中左键用于打开安全的\n"
					+ "格子，推进游戏进度；右键用于标记地雷，以辅助判断，或为接下来的双击做准备；双击在一个数字周围的地雷标记完时，相当\n"
					+ "于对数字周围未打开的方块均进行一次左键单击操作：\n\n"
					+ "  左键单击：在判断出不是雷的方块上按下左键，可以打开该方块。如果方块上出现数字，则该数字表示其周围3×3区域中的\n"
					+ "地雷数（一般为8个格子，对于边块为5个格子，对于角块为3个格子。所以扫雷中最大的数字为8）；如果方块上为空（相当于\n"
					+ "0），则可以递归地打开与空相邻的方块；如果不幸触雷，则游戏结束。\n\n"
					+ "右键单击：在判断为地雷的方块上按下右键，可以标记地雷（显示为小红旗）。重复一次或两次操作可取消标记\n"
					+ "\n\n"
					);
			helpTip.add(textArea);
			
			helpTip.setBounds(120, 125, 720, 400);
			helpTip.setVisible(true);
			helpTip.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			helpTip.setResizable(false);
		}
		if(e.getSource()==setMenuAction.helpItem2)
		{
			JFrame Msg = new JFrame("游戏帮助");
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setText("\n\n  私家扫雷\n  版本1.0\n"
					+ "  由Programmer_hhy开发\n");
			Msg.add(textArea);
			
			Msg.setBounds(120, 125, 400, 400);
			Msg.setVisible(true);
			Msg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Msg.setResizable(false);
		}
	}
}
