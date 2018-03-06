import java.util.ArrayList;
import java.util.List;

/**
 * ���ȶ��� ���һ���㷨���ҳ�ֻ��������2��3��5 ������,1Ҳ�㡣 �磺1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * �������n������ֵ ���n = 9�� ���� 10;
 * 
 * @author Joseph 2018/3/6
 *
 */
public class UglyNumber {
	public static void main(String[] args) {
		int n = 19;
		if (n > 0) {
			System.out.println("��" + n + "����Ϊ��" + getUglyNum(n));
		} else {
			System.out.println("n����Ϊ������");
		}
	}

	/*
	 * ˼·���������ж��Ƿ�Ϊ�����ķ�������������������������⣬��Ч�ʺܵͣ�nԽ��Խ����
	 * 		��Ҫ����˼·����Ȼ����������ֻ��2,3,5���������1��ˡ�
	 * 		����������Ҫһ���������洢�Ѿ�����õ��ĳ�����Ȼ��ͣ����ջ��ֵ�жϳ���Ӧ�ó��Լ�
	 * 		����Щ������һ������2��3��5�����ӣ���ֻҪ����1,�ذ�������һ��
	 * 		�������Ƿ������߽��л�ȡ���ֱ����ǰ��������2,3,5�ļ�����Ȼ�����������������ֱ���2,3,5�ͼ�һ��ÿ�ο϶�������һ���߼�һ��Ȼ������������е���Сֵ����ȡ���ɵõ���һ�������ĳ�����
	 * 		Ȼ��ͨ��forѭ�����������ɵõ���n��������ֵ��
	 * */
	private static int getUglyNum(int n) {
		List<Integer> uglyArray = new ArrayList<>();//��������
		uglyArray.add(1);
		int ugly2 = 0;
		int ugly3 = 0;
		int ugly5 = 0;
		
		for(int i = 1;i<n;i++){
			int currentUgly = uglyArray.get(i-1);
			while (uglyArray.get(ugly2)*2<=currentUgly){
				ugly2++;
			}
			while (uglyArray.get(ugly3)*3<=currentUgly){
				ugly3++;
			}
			while (uglyArray.get(ugly5)*5<=currentUgly){
				ugly5++;
			}
			uglyArray.add(Math.min(Math.min(uglyArray.get(ugly2)*2, uglyArray.get(ugly3)*3),uglyArray.get(ugly5)*5));
		}
		return uglyArray.get(n-1);
	}
	
	
//	/**
//	 * ����жϳ���
//	 * @param i
//	 * @return
//	 */
//	private static boolean isUglyNum(int i){
//		if(i == 1){
//			return true;
//		}
//		while(i>=2&&i%2==0){
//			i/=2;
//		}
//		while(i>=3&&i%3==0){
//			i/=3;
//		}
//		while(i>=5&&i%5==0){
//			i/=5;
//		}
//		return i==1;
//	}
}
