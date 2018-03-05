/**
 * 计算数字k在0到n中的出现的次数 
 * k可能是0~9的一个值 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
 * 
 * @author Joseph 
 * 2018/3/5
 */
public class DigitCounts {

	public static void main(String[] args) {
		int k = 1;
		int n = 12;
		if (k >= 0 && k < 9 && n >= 0) {
			System.out.println("数字：" + k + "在0到" + n + "中出现的次数为"+calc(k, n));
		} else {
			System.out.println("参数错误");
		}
	}

	/*
	 * 统计次数
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
	 * 每一个数字进行判断 i:当前遍历到的数字 k:需要判断次数的数字
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
