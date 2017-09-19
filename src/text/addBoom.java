package text;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;

public class addBoom {
	static int[][] boomNum;//最终检测的数组
	static int[][] boomText;//布雷数组
	int [] num;
	int i, j;
	int height, width;//数组行数和列数
	static int number;//雷数
	
	void add(){
		boomText = new int[boomFlow.height][boomFlow.width];
		num = new int[boomFlow.height*boomFlow.width]; //一维数组元素数量和二维数组元素数量一致，通过一维数组随机产生，储存
		                                               //雷的位置，进而确定二维数组中雷的位置
		height = boomFlow.height;
		width = boomFlow.width;
		
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();//利用泛型set的特性，添加互不相同的随机数
		for(i=0; i<number;)//随机布雷
		{
			if(set.add( random.nextInt(height*width) )==true)//产生互不相同的随机数
			{
				i++;
			}
		}//for
		
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int a = it.next();
			num[a] = -1;  //布了雷的位置设其值为-1
		}
	
		
		int k=0;
		for(i=0; i<height; i++)
		{
			for(j=0; j<width; j++)
			{
				if(num[k]==-1)
				{
					boomText[i][j]=-1;   //布雷
				}
				k++;
			}
		}
		
		
		//计算周围雷数
		for(i=0; i<height; i++)
		{
			for(j=0; j<width; j++)
			{
				if(boomText[i][j]==0)
				{
					//i-1行
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
					//i行
					if( ((j-1)>=0) && (boomText[i][j-1]==-1) )
					{
						boomText[i][j]++;
					}
					if( ((j+1)<width) && (boomText[i][j+1]==-1) )
					{
						boomText[i][j]++;
					}
					//i+1行
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
		//计算完毕
		boomNum=boomText.clone(); 
		
	}//add

}
