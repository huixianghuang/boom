package text;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;

public class addBoom {
	static int[][] boomNum;//���ռ�������
	static int[][] boomText;//��������
	int [] num;
	int i, j;
	int height, width;//��������������
	static int number;//����
	
	void add(){
		boomText = new int[boomFlow.height][boomFlow.width];
		num = new int[boomFlow.height*boomFlow.width]; //һά����Ԫ�������Ͷ�ά����Ԫ������һ�£�ͨ��һά�����������������
		                                               //�׵�λ�ã�����ȷ����ά�������׵�λ��
		height = boomFlow.height;
		width = boomFlow.width;
		
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();//���÷���set�����ԣ���ӻ�����ͬ�������
		for(i=0; i<number;)//�������
		{
			if(set.add( random.nextInt(height*width) )==true)//����������ͬ�������
			{
				i++;
			}
		}//for
		
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int a = it.next();
			num[a] = -1;  //�����׵�λ������ֵΪ-1
		}
	
		
		int k=0;
		for(i=0; i<height; i++)
		{
			for(j=0; j<width; j++)
			{
				if(num[k]==-1)
				{
					boomText[i][j]=-1;   //����
				}
				k++;
			}
		}
		
		
		//������Χ����
		for(i=0; i<height; i++)
		{
			for(j=0; j<width; j++)
			{
				if(boomText[i][j]==0)
				{
					//i-1��
					if((i-1) >= 0)
					{
						if( ((j-1) >= 0) && (boomText[i-1][j-1]==-1))
						{
							boomText[i][j]++;
						}
						if(boomText[i-1][j]==-1)
						{
							boomText[i][j]++;
						}
						if( ((j+1) < width) && (boomText[i-1][j+1]==-1))
						{
							boomText[i][j]++;
						}
					}
					//i��
					if( ((j-1)>=0) && (boomText[i][j-1]==-1) )
					{
						boomText[i][j]++;
					}
					if( ((j+1)<width) && (boomText[i][j+1]==-1) )
					{
						boomText[i][j]++;
					}
					//i+1��
					if((i+1) < height)
					{
						if( ((j-1) >= 0) && (boomText[i+1][j-1]==-1))
						{
							boomText[i][j]++;
						}
						if(boomText[i+1][j]==-1)
						{
							boomText[i][j]++;
						}
						if( ((j+1) < width) && (boomText[i+1][j+1]==-1))
						{
							boomText[i][j]++;
						}
					}
					
				}
			}
		}
		//�������
		boomNum=boomText.clone(); 
		
	}//add

}
