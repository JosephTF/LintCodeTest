/**
 * �����n�׳���β����ĸ���
 * @author Joseph
 *	2018/2/28
 */
public class TrailingZeros {

	public static void main(String[] args) {
		System.out.println(trailingZeros(25));
	}

	
	/*
	 * ֪ʶ�㣺����û�н׳ˣ�0��1�Ľ׳˶���1��
	 * ˼·��	1.�׳�β����0����2*5��˵���,4*5���ɿ���2*2*5������ֻҪ��n�����������ж��ٸ�5��2��
	 * 		2.����Ϊ��������2�ĸ�����Զ��5�࣬����ֻ�ÿ�5�ı����ĸ�������n/5��
	 * 		3.����Ϊ��Щ��5��ָ������25=5*5�Ͱ���������������5��Ҫ������������ֻҪn����n����5�ذ���������5��Ҫ��ͣ�ѽ׳�����С5����ֱ��С��5Ϊֹ��
	 */
	private static long trailingZeros(long n) {
		if(n<0){
			return 0;
		}
		int count = 0;
		while (n != 0) {
			count += n / 5;
			n /= 5;	
		}
		return count;
	}
}