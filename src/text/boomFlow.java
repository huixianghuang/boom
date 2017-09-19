package text;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.sun.prism.Image;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class boomFlow {
	static JTextField boomNum, gameTime;   //ʣ������������ʱ��
	JLabel boomNumJLabel, gameTimeJLabel;  //ʣ��������ǩ������ʱ���ǩ
	static JButton faceButton;            //��λ��ť
	static JButton boomButton[][];       //������ť
	JPanel layout = new JPanel();    //������ʾ����
	JPanel layout1 = new JPanel();   //״̬����ʾ����
	static int height, width;        //������Ⱥ͸߶�
	static int[][] check;          //������飬���Button���򿪹������ӦֵΪ1
	static int[][] checkFlag;      //�����ֵ���ж��Ƿ��Ӧ��ť�Ƿ񱻱��ף���������Ϊ1
	static int count;
	static int countBoom;         //����˵��׵�����
	static int timeNum;           //����ʱ����ֵ
	static int checktime;         //����Ƿ�ʼ��ʱ
	
	public boomFlow(){
		
	}
	public boomFlow(int a, int b, int c) {
		// TODO Auto-generated constructor stub
		width  = a;
		height = b;
		addBoom.number = c;
		check = new int[height][width];
		checkFlag = new int[height][width];
		count=0;
		countBoom = 0;
		timeNum=0;
		checktime=0;
		setMenuAction.CheckColor = 0;      //��ɫΪĬ��
	}
	
	void addBoomButton(){
		
		boomButton = new JButton[height][width];
		layout.setLayout(new GridLayout(height, width));
		int i=0, j=0;
		for(i=0; i<height; i++)
		{
			for(j=0; j<width; j++)
			{
				boomButton[i][j] = new JButton();
				boomButton[i][j].setPreferredSize(new Dimension(30, 30));      
				boomButton[i][j].setMargin(new java.awt.Insets(0, 0, 0, 0));   //���������� 
				
				Font font = new Font(null, 0, 20);
				boomButton[i][j].setFont(font);
				layout.add(boomButton[i][j]);          //�����������Button�ؼ�
				

			}
		}
		
		
//		��Ӱ�ť�����¼�
		for(i=0; i<height; i++)
		{
			for(j=0; j<width; j++)
			{
				boomButton[i][j].addMouseListener(new action());
			}
		}
		
	}//addBoomButton
	
	void setHeightWidth(int a, int b, int c){
//		����������ߺ�����
		width  = a;
		height = b;
		addBoom.number = c;
		check = new int[height][width];
		count=0;
		countBoom = 0;
	}
	
//	���״̬��
	void setShowLayout(){
		boomNumJLabel = new JLabel("ʣ������");
		boomNum = new JTextField(4);
		boomNum.setHorizontalAlignment(JTextField.CENTER);	//������ж���	
		boomNum.setText(Integer.toString(addBoom.number));
		
		boomNum.setEditable(false);
		
		faceButton = new JButton();
		faceButton.setPreferredSize(new Dimension(30, 30));
		ImageIcon iconImage = new ImageIcon("picture/smile.png");
		faceButton.setIcon(iconImage);
		faceButton.addActionListener(new listenerFace());
		
		gameTime = new JTextField(4);
		gameTime.setHorizontalAlignment(JTextField.CENTER);//������ж���
		gameTime.setText("0");
		gameTimeJLabel = new JLabel("����ʱ��");
		gameTime.setEditable(false);
		
		FlowLayout flowLayout = new FlowLayout();
		layout1.setLayout(flowLayout);
		flowLayout.setAlignment(FlowLayout.CENTER);
		layout1.add(boomNumJLabel);
		layout1.add(boomNum);
		layout1.add(faceButton);
		layout1.add(gameTime);
		layout1.add(gameTimeJLabel);
		
		layout1.add(layout);       //������������


	}//setShowLayout
	
	static void addTime(){
		gameTime.setText(Integer.toString(123));
	}
	
	JPanel getFlowLayout(){
		return layout;
	}
	JPanel getFlowLayout1(){
		return layout1;
	}
	

}//boomFlow

//������¼�
 class action implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int i, j;
		for(i=0; i<boomFlow.height; i++)
			for(j=0; j<boomFlow.width; j++)
			{
				if(e.getSource()== boomFlow.boomButton[i][j])
				{
//					����¼�
					if(e.getModifiers()== InputEvent.BUTTON1_MASK)
					{

						if(boomFlow.checktime == 0)// ��һ�������ʼ��ʱ
						{
							Thread thread = new Thread(new Count());
							thread.start();
							boomFlow.checktime = 1;
						}
						
						if(boomFlow.boomButton[i][j].getIcon()==null)  //����������ˣ���������ÿؼ�
						{
     						open(i, j);
						}
	
					}
					
					
//	                                          �һ��¼�				
					if(e.getModifiers()==InputEvent.BUTTON3_MASK)
					{
						if(boomFlow.check[i][j]==0)
						{
							if(boomFlow.checktime == 0)// ��һ���һ���ʼ��ʱ
							{
								Thread thread = new Thread(new Count());
								thread.start();
								boomFlow.checktime = 1;
							}
							if(boomFlow.checkFlag[i][j]==0)//���û���ף������
							{
								ImageIcon ic = new ImageIcon("picture/flag.png");
								boomFlow.boomButton[i][j].setIcon(ic);
								boomFlow.countBoom++;
								boomFlow.checkFlag[i][j]=1;
							}
							else if(boomFlow.checkFlag[i][j]==1)//��������ף���ȡ������
							{
								boomFlow.boomButton[i][j].setIcon(null);
								boomFlow.countBoom--;
								boomFlow.checkFlag[i][j]=0;
							}
							boomFlow.boomNum.setText(Integer.toString(addBoom.number-boomFlow.countBoom));//ʣ������
						
						}//if(boomFlow.check[i][j]==0)

												
					}
					
					
					
				}
			}
		
	}//mouseClicked

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//////////////////////<-- ������ť -->///////////////////////////////////////////////
	public void open(int i, int j){
		
		//��������ף�ֱ�ӷ���
		if(boomFlow.check[i][j]==0)//��û�б�����
		{
		if(addBoom.boomNum[i][j]!=-1)
		{
			if(addBoom.boomNum[i][j]!=0)
			{
				if(boomFlow.check[i][j]==0)
				{
				boomFlow.boomButton[i][j].setBackground(Color.white);
				boomFlow.boomButton[i][j].setText(Integer.toString(addBoom.boomNum[i][j]));
				boomFlow.check[i][j]=1;
				Text.openNum++;
				if( (boomFlow.height*boomFlow.width-Text.openNum)==(addBoom.number) )
				{

					Count.temp = 1; //��ʱ����
					JOptionPane.showMessageDialog(null, "��ϲ��ɨ�׳ɹ�����Ӯ��");
					
					for(int ii=0; ii<boomFlow.height; ii++)//����ɨ�׳ɹ������пؼ����ܱ����
					{
						for(int jj=0; jj<boomFlow.width; jj++)
						{
							boomFlow.check[ii][jj]=1;
						}
					}
				}
				
				}
				
			}
			else if(addBoom.boomNum[i][j]==0)
			{
				if(boomFlow.check[i][j]==0)
				{
				boomFlow.boomButton[i][j].setBackground(Color.white);
				boomFlow.check[i][j]=1;
				Text.openNum++;
				if( (boomFlow.height*boomFlow.width-Text.openNum)==(addBoom.number) )
				{

					Count.temp = 1;  //��ʱ����
					JOptionPane.showMessageDialog(null, "��ϲ��ɨ�׳ɹ�����Ӯ��");
					
					
					for(int ii=0; ii<boomFlow.height; ii++)//����ɨ�׳ɹ������пؼ����ܱ����
					{
						for(int jj=0; jj<boomFlow.width; jj++)
						{
							boomFlow.check[ii][jj]=1;
						}
					}
					
				}
				}
				
				if( (i-1) >= 0 )
				{
					if( (j-1)>=0 )
					{
						open(i-1, j-1);
					}
					open(i-1, j);
					if( (j+1) < boomFlow.width)
					{
						open(i-1, j+1);
					}
				}
				
				if( (j-1)>=0 )
				{
					open(i, j-1);
				}
				if( (j+1) < boomFlow.width)
				{
					open(i, j+1);
				}
				if( (i+1) < boomFlow.height )
				{
					if( (j-1)>= 0 )
					{
						open(i+1, j-1);
					}
					open(i+1, j);
					if( (j+1)<boomFlow.width)
					{
						open(i+1, j+1);
					}
				}
			}
		}//if(addBoom.boomNum[i][j]!=-1)
		
		if(addBoom.boomNum[i][j]==-1)
		{
			ImageIcon icon = new ImageIcon("picture/cry.png");
			boomFlow.faceButton.setIcon(icon);
			for(int ii=0; ii<boomFlow.height; ii++)
			{
				for(int jj=0; jj<boomFlow.width; jj++)
				{
					boomFlow.check[ii][jj]=1;     //�����ˣ������������еĿؼ������ܱ����
					if(addBoom.boomNum[ii][jj]==-1)
					{
						ImageIcon icon1 = new ImageIcon("picture/boom.png");
						boomFlow.boomButton[ii][jj].setIcon(icon1);
					}
					if(addBoom.boomNum[ii][jj]!=-1 && boomFlow.checkFlag[ii][jj]==1) //�����
					{
						ImageIcon icon2 = new ImageIcon("picture/wrong.jpg");
						boomFlow.boomButton[ii][jj].setIcon(icon2);
					}
				}
			}

			Count.temp = 1; //��ʱ����
			JOptionPane.showMessageDialog(null, "�����ˣ���Ϸ����");
			
			
		}//if(addBoom.boomNum[i][j]==-1)
		}
	}//open
	
}

 
class listenerFace implements ActionListener{     //��λ

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == boomFlow.faceButton)
	{
		int a, b, c;
		a=boomFlow.height;
		b=boomFlow.width;
		c=addBoom.number;
		Count.temp = 1;  // ��ʱ����
		Text.winFrame.setVisible(false);
		Text.winFrame.remove(Text.bFlow.getFlowLayout1());
		Text.createBoomFlow(b, a, c);
		
	}
}
}

class Count implements Runnable{

	
	static int temp;
	public Count() {
		// TODO Auto-generated constructor stub
		temp = 0;
	}
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(true)
		{
			
			try {
				boomFlow.timeNum++;
				Thread.sleep(1000);
				boomFlow.gameTime.setText(boomFlow.timeNum+"");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(temp == 1)
				break;
		}
		
	}
	
}

