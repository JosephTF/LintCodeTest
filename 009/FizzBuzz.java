import java.util.ArrayList;

/**
 * FizzBuzz 一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 * 
 * 如果这个数被3整除，打印fizz.如果这个数被5整除，打印buzz.如果这个数能同时被3和5整除，打印fizz buzz.
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
	 * 第一种：无脑写法
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
	 * 第二种：只用一个 if 语句来完成
	 */
	public static void fizzBuzz2(int n) {
		ArrayList<String> n2String = new ArrayList<>();
		int i = 1;
		int p = 1, q = 1;
		while (i <= n) {
			// 数字本身
			while (i < p * 3 && i < q * 5) {
				n2String.add(String.valueOf(i));
				i++;
			}
			// 能同时被3和5整除
			if (i <= n && i == p * 3 && i == q * 5) {
				n2String.add("fizz buzz");
				i++;
				p++;
				q++;
				continue;
			}
			// 能被3整除
			while (i <= n && i == p * 3) {
				n2String.add("fizz");
				i++;
				p++;
			}
			// 能被5整除
			while (i <= n && i == q * 5) {
				n2String.add("buzz");
				i++;
				q++;
			}
		}
		System.out.println(n2String.toString());
	}
}
