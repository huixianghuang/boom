package text;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.InvocationEvent;
import java.lang.*; 
import java.util.*;

import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;


public class Text {
	static JFrame winFrame;      //游戏窗体
	static JPanel panel;
	static boomFlow bFlow;
	static int openNum;
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createFrame();
				
			}
		});
	//	createFrame();
	}
	
	public static void createFrame() {
		
		winFrame = new JFrame("扫雷");
		winFrame.setBounds(250, 250, 800, 500);
		winFrame.setVisible(true);
		winFrame.setResizable(false);
		

//		建立雷区
		createBoomFlow(9, 9, 10);
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	}//createFrame
	
	public static void createBoomFlow(int a, int b, int c){
		
		
		bFlow = new boomFlow(a, b, c);

		openNum = 0;
		setMenuAction setAction = new setMenuAction();
		
//		往窗口添加菜单条
//		winFrame.setLayout(new FlowLayout());
		winFrame.setJMenuBar(setAction.menuBar);
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		设置窗口宽度
		winFrame.setSize(boomFlow.width*30+10, boomFlow.height*30+95);
//		加入状态显示栏
		bFlow.setShowLayout();
//		加入Button
		bFlow.addBoomButton();  
//		布雷		
		addBoom textAddBoom = new addBoom();
		textAddBoom.add();
		
//		添加嵌套了具有GridLayout的容器形成雷区布局的FlowLayout容器
		winFrame.add(bFlow.getFlowLayout1());
		
		winFrame.setVisible(true);
		
	}
}
