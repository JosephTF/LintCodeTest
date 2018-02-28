/**
 * 不用加号计算A和B的和
 * 
 * @author Joseph
 * 2018/2/27
 *
 */
public class AandB {
	public static void main(String[] args) {
		int A = 100, B = 20;
		System.out.println(add(A, B));
	}

	/*
	 * 知识点：位运算（且&、或|、异或^、非~、shl <<、shr >>）
	 * 此算法优点：2进制位运算的速度要比10进制加减乘除速度更快
	 * 思路：	异或，又称为不进位加法，a^b就是a和b相加之后，该进位的地方不进位的结果，例如1010^0110=1100。
	 * 		然后下面考虑哪些地方要进位，自然是a和b里都是1的地方即a&b就是a和b里都是1的那些位置，a & b << 1 就是进位之后的结果
	 * 		所以：a + b = (a ^ b) + (a & b << 1)
	 * 		在模拟加法的运算过程，进位不可能一直持续，最终会变为0。所以重复做上述操作就可以求得a + b的值。
	 */
	private static int add(int a, int b) {
		while (b != 0) {
			int c = a ^ b;
			b = (a & b) << 1;
			a = c;
		}
		return a;
	}
}
