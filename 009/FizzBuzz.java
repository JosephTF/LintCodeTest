import java.util.ArrayList;

/**
 * FizzBuzz һ������n. �� 1 �� n ��������Ĺ����ӡÿ������
 * 
 * ����������3��������ӡfizz.����������5��������ӡbuzz.����������ͬʱ��3��5��������ӡfizz buzz.
 * 
 * @author Joseph 2018/3/19
 *
 */
public class FizzBuzz {

	public static void main(String[] args) {
		int n = 15;
		fizzBuzz1(n);
	}

	/**
	 * ��һ�֣�����д��
	 * 
	 * @param n
	 */
	public static void fizzBuzz1(int n) {
		ArrayList<String> n2String = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				n2String.add("fizz buzz");
			} else if (i % 5 == 0) {
				n2String.add("buzz");
			} else if (i % 3 == 0) {
				n2String.add("fizz");
			} else {
				n2String.add(String.valueOf(i));
			}
		}
		System.out.println(n2String.toString());
	}

	/**
	 * �ڶ��֣�ֻ��һ�� if ��������
	 */
	public static void fizzBuzz2(int n) {
		ArrayList<String> n2String = new ArrayList<>();
		int i = 1;
		int p = 1, q = 1;
		while (i <= n) {
			// ���ֱ���
			while (i < p * 3 && i < q * 5) {
				n2String.add(String.valueOf(i));
				i++;
			}
			// ��ͬʱ��3��5����
			if (i <= n && i == p * 3 && i == q * 5) {
				n2String.add("fizz buzz");
				i++;
				p++;
				q++;
				continue;
			}
			// �ܱ�3����
			while (i <= n && i == p * 3) {
				n2String.add("fizz");
				i++;
				p++;
			}
			// �ܱ�5����
			while (i <= n && i == q * 5) {
				n2String.add("buzz");
				i++;
				q++;
			}
		}
		System.out.println(n2String.toString());
	}
}
