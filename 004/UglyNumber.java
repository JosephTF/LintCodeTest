import java.util.ArrayList;
import java.util.List;

/**
 * 优先队列 设计一个算法，找出只含素因子2，3，5 的数列,1也算。 如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * 并计算第n个数的值 如果n = 9， 返回 10;
 * 
 * @author Joseph 2018/3/6
 *
 */
public class UglyNumber {
	public static void main(String[] args) {
		int n = 19;
		if (n > 0) {
			System.out.println("第" + n + "个数为：" + getUglyNum(n));
		} else {
			System.out.println("n必须为正整数");
		}
	}

	/*
	 * 思路：下面有判断是否为丑数的方法，可以利用它迭代计算此题，但效率很低，n越大越明显
	 * 		需要换个思路，既然丑数的因素只有2,3,5，就让其从1相乘。
	 * 		所以首先需要一个数组来存储已经计算得到的丑数，然后不停根据栈顶值判断丑数应该乘以几
	 * 		但有些丑数不一定包含2或3或5的因子，但只要大于1,必包含其中一种
	 * 		所以我们分三条线进行获取，分别代表当前最大丑数是2,3,5的几倍，然后设置三个参数，分别满2,3,5就加一，每次肯定至少有一条线加一，然后计算三条线中的最小值并获取即可得到下一个相连的丑数。
	 * 		然后通过for循环迭代，即可得到第n个丑数的值。
	 * */
	private static int getUglyNum(int n) {
		List<Integer> uglyArray = new ArrayList<>();//丑数数组
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
//	 * 如何判断丑数
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
