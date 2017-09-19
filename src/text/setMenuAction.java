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
	static JMenuBar menuBar;             //�˵���
	static JMenu gameJMenu, helpJMenu;   //����Ϸ���˵������������˵�
	
	static JMenuItem gameItem1, gameItem2, gameItem3, gameItem4, gameItem5,  // "��Ϸ"�˵���
	          gameItem6, gameItem7, gameItem8, gameItem9;
	static JMenuItem helpItem1, helpItem2;                                   // ���������˵���
	
	static JLabel label1, label2, label3, label4, label5, label6;           //ɨ��Ӣ�۰����
	static JButton jButton1, jButton2;
	static int CheckColor;    //�����ɫ�Ƿ�ı䣬Ϊ0��ΪĬ����ɫ
	public setMenuAction() {
		
//		�����˵����Լ������
	    menuBar = new JMenuBar();
		gameJMenu = new JMenu("��Ϸ");
		helpJMenu = new JMenu("����");
//		
//		���ɲ˵���ؼ������ÿ�ݼ�
//		��Ϸ�˵�
		gameItem1 = new JMenuItem("����");
		gameItem1.setAccelerator(KeyStroke.getKeyStroke('N'));
		gameItem1.addActionListener(new listner());
		
		gameItem2 = new JMenuItem("����");
		gameItem2.setAccelerator(KeyStroke.getKeyStroke('B'));
		gameItem2.addActionListener(new listner());
		
		gameItem3 = new JMenuItem("�м�");
		gameItem3.setAccelerator(KeyStroke.getKeyStroke('I'));
		gameItem3.addActionListener(new listner());
		
		gameItem4 = new JMenuItem("�߼�");
		gameItem4.setAccelerator(KeyStroke.getKeyStroke('E'));
		gameItem4.addActionListener(new listner());
		
		gameItem5 = new JMenuItem("�Զ���");
		gameItem5.setAccelerator(KeyStroke.getKeyStroke('C'));
		gameItem5.addActionListener(new listner());
		
	/*	gameItem6 = new JMenuItem("���");
		gameItem6.setAccelerator(KeyStroke.getKeyStroke('M'));
		gameItem6.addActionListener(new listner());
		*/
		gameItem7 = new JMenuItem("��ɫ");
		gameItem7.setAccelerator(KeyStroke.getKeyStroke('L'));
		gameItem7.addActionListener(new listner());
		
		gameItem8 = new JMenuItem("ɨ��Ӣ�۰�");
		gameItem8.setAccelerator(KeyStroke.getKeyStroke('T'));
		gameItem8.addActionListener(new listner());
		
		gameItem9 = new JMenuItem("�˳�");
		gameItem9.setAccelerator(KeyStroke.getKeyStroke('X'));
		gameItem9.addActionListener(new listner());
		
//		�����˵�
		helpItem1 = new JMenuItem("��Ϸ����");
		helpItem1.setAccelerator(KeyStroke.getKeyStroke('H'));
		helpItem1.addActionListener(new listner());
		
		helpItem2 = new JMenuItem("����ɨ��");
		helpItem2.setAccelerator(KeyStroke.getKeyStroke('A'));
		helpItem2.addActionListener(new listner());
		
//		˳����Ӳ˵����
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
		
//		���˵�����Ӳ˵�
		menuBar.add(gameJMenu);
		menuBar.add(helpJMenu);
		
//		ɨ��Ӣ�۰������ʼ��
		label1 = new JLabel("������ "+"999"+"��");
		label2 = new JLabel("�м��� "+"999"+"��");
		label3 = new JLabel("�߼��� "+"999"+"��");
		label4 = new JLabel("����");
		label5 = new JLabel("����");
		label6 = new JLabel("����");
		
		jButton1 = new JButton("���¼Ʒ�");
//		jButton1.addActionListener(new listner());
		jButton1.setBackground(new Color(245, 245, 245));
		jButton1.setPreferredSize(new Dimension(80, 20));
		jButton1.setMargin(new java.awt.Insets(3, 3, 3, 3));
		
		jButton2 = new JButton("ȷ��");
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
		if(e.getSource()==setMenuAction.gameItem1)//����
		{
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(9, 9, 10);
		}
		if(e.getSource()==setMenuAction.gameItem2)//����ģʽ
		{
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(9, 9, 10);
		}
		if(e.getSource()==setMenuAction.gameItem3)//�м�ģʽ
		{   
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(16, 16, 40);
		}
		if(e.getSource()==setMenuAction.gameItem4)//�߼�ģʽ
		{   
			Text.winFrame.setVisible(false);
			Text.winFrame.remove(Text.bFlow.getFlowLayout1());
			Text.createBoomFlow(30, 16, 99);
		}
		if(e.getSource()==setMenuAction.gameItem5)//�Զ���
		{   
			final JFrame jFrame = new JFrame("�Զ�������");
			JLabel h, w, n;
			final JTextField ht;
			final JTextField wt;
			final JTextField nt;
			JButton yes, no;
			h = new JLabel("�߶�:");
			w = new JLabel("���:");
			n = new JLabel("����:");
			ht = new JTextField(6);
			wt = new JTextField(6);
			nt = new JTextField(6);
			ht.setText("9");
			wt.setText("9");
			nt.setText("10");
			
			yes = new JButton("ȷ��");
			yes.setBackground(new Color(245, 245, 245));
			no = new JButton("ȡ��");
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
			
			//���ð�ť�����¼�
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
						JOptionPane.showMessageDialog(null, "������������߶�̫������������");
					}
					else if (b>40) {
						JOptionPane.showMessageDialog(null, "��������������̫������������");
					}
					else {
						JOptionPane.showMessageDialog(null, "�����������̫�࣬����������");
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
		
	/*	if(e.getSource()==setMenuAction.gameItem6)//���
		{   
			
		}*/
		
		if(e.getSource()==setMenuAction.gameItem7)//��ɫ
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
		if(e.getSource()==setMenuAction.gameItem8)//ɨ��Ӣ�۰�
		{   
			final JFrame jFrame = new JFrame("ɨ��Ӣ�۰�");
			jFrame.setLayout(new FlowLayout());
			jFrame.setBounds(120, 125, 250, 170);

//			Box���
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
			
//			���ð�ť����
			setMenuAction.jButton1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					jFrame.setVisible(false);
					setMenuAction.label1.setText("������ "+"999"+"��");
					setMenuAction.label2.setText("�м��� "+"999"+"��");
					setMenuAction.label3.setText("�߼��� "+"999"+"��");
					setMenuAction.label4.setText("����");
					setMenuAction.label5.setText("����");
					setMenuAction.label6.setText("����");
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
		
		
		if(e.getSource()==setMenuAction.gameItem9)//�˳�
		{   
			System.exit(0);//��������
		}
//////////<--�����˵��¼�ʵ��-->///////////////////////////////////////////////////////
		if(e.getSource()==setMenuAction.helpItem1)
		{
			JFrame helpTip = new JFrame("��Ϸ����");
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setText("\n\n  ��Ϸ�Ļ��������������������Left Click�����Ҽ�������Right Click����˫����Chording�����֡�����������ڴ򿪰�ȫ��\n"
					+ "���ӣ��ƽ���Ϸ���ȣ��Ҽ����ڱ�ǵ��ף��Ը����жϣ���Ϊ��������˫����׼����˫����һ��������Χ�ĵ��ױ����ʱ���൱\n"
					+ "�ڶ�������Χδ�򿪵ķ��������һ���������������\n\n"
					+ "  ������������жϳ������׵ķ����ϰ�����������Դ򿪸÷��顣��������ϳ������֣�������ֱ�ʾ����Χ3��3�����е�\n"
					+ "��������һ��Ϊ8�����ӣ����ڱ߿�Ϊ5�����ӣ����ڽǿ�Ϊ3�����ӡ�����ɨ������������Ϊ8�������������Ϊ�գ��൱��\n"
					+ "0��������Եݹ�ش�������ڵķ��飻������Ҵ��ף�����Ϸ������\n\n"
					+ "�Ҽ����������ж�Ϊ���׵ķ����ϰ����Ҽ������Ա�ǵ��ף���ʾΪС���죩���ظ�һ�λ����β�����ȡ�����\n"
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
			JFrame Msg = new JFrame("��Ϸ����");
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setText("\n\n  ˽��ɨ��\n  �汾1.0\n"
					+ "  ��Programmer_hhy����\n");
			Msg.add(textArea);
			
			Msg.setBounds(120, 125, 400, 400);
			Msg.setVisible(true);
			Msg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Msg.setResizable(false);
		}
	}
}
