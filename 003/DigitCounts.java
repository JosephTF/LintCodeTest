/**
 * ��������k��0��n�еĳ��ֵĴ��� 
 * k������0~9��һ��ֵ ����n=12��k=1���� [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12]�����Ƿ���1������5�� (1, 10, 11, 12)
 * 
 * @author Joseph 
 * 2018/3/5
 */
public class DigitCounts {

	public static void main(String[] args) {
		int k = 1;
		int n = 12;
		if (k >= 0 && k < 9 && n >= 0) {
			System.out.println("���֣�" + k + "��0��" + n + "�г��ֵĴ���Ϊ"+calc(k, n));
		} else {
			System.out.println("��������");
		}
	}

	/*
	 * ͳ�ƴ���
	 * 
	 */
	private static int calc(int k, int n) {
		int sum = 0;
		for (int i = k; i <= n; i++) {
			sum += count(i, k);
		}
		return sum;
	}

	/*
	 * ÿһ�����ֽ����ж� i:��ǰ������������ k:��Ҫ�жϴ���������
	 */
	private static int count(int i, int k) {
		if (i == 0 && k == 0) {
			return 1;
		}
		int count = 0;
		while (i != 0) {
			if (i % 10 == k) {
				count++;
			}
			i /= 10;
		}
		return count;
	}

}
