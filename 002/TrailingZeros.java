/**
 * 计算出n阶乘中尾部零的个数
 * @author Joseph
 *	2018/2/28
 */
public class TrailingZeros {

	public static void main(String[] args) {
		System.out.println(trailingZeros(25));
	}

	
	/*
	 * 知识点：负数没有阶乘，0和1的阶乘都是1。
	 * 思路：	1.阶乘尾数的0是由2*5相乘得来,4*5即可看成2*2*5。所以只要看n的质因子中有多少个5和2。
	 * 		2.又因为质因子中2的个数永远比5多，所以只用看5的倍数的个数，即n/5。
	 * 		3.又因为有些是5的指数，如25=5*5就包含了两个质因数5，要算两个。所以只要n！的n大于5必包含质因数5，要不停把阶乘数缩小5倍，直至小于5为止。
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