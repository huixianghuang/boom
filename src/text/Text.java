package text;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.InvocationEvent;
import java.lang.*; 
import java.util.*;

import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;


public class Text {
	static JFrame winFrame;      //��Ϸ����
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
		
		winFrame = new JFrame("ɨ��");
		winFrame.setBounds(250, 250, 800, 500);
		winFrame.setVisible(true);
		winFrame.setResizable(false);
		

//		��������
		createBoomFlow(9, 9, 10);
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	}//createFrame
	
	public static void createBoomFlow(int a, int b, int c){
		
		
		bFlow = new boomFlow(a, b, c);

		openNum = 0;
		setMenuAction setAction = new setMenuAction();
		
//		��������Ӳ˵���
//		winFrame.setLayout(new FlowLayout());
		winFrame.setJMenuBar(setAction.menuBar);
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		���ô��ڿ��
		winFrame.setSize(boomFlow.width*30+10, boomFlow.height*30+95);
//		����״̬��ʾ��
		bFlow.setShowLayout();
//		����Button
		bFlow.addBoomButton();  
//		����		
		addBoom textAddBoom = new addBoom();
		textAddBoom.add();
		
//		���Ƕ���˾���GridLayout�������γ��������ֵ�FlowLayout����
		winFrame.add(bFlow.getFlowLayout1());
		
		winFrame.setVisible(true);
		
	}
}
