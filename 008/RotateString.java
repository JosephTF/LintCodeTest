import java.util.Arrays;

/**
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 
 * 对于字符串 "abcdefg". 
 * offset=0 => "abcdefg" 
 * offset=1 => "gabcdef" 
 * offset=2 => "fgabcde" 
 * offset=3 => "efgabcd"
 * ……
 * offset=8 => "gabcdef"
 * @author Joseph 2018/3/16
 *
 */
public class RotateString {

	public static void main(String[] args) {
		char[] str = "abcdefg".toCharArray();
		rotate(str, 8);
		System.out.println(str);
	}

	public static void rotate(char[] str, int offset) {
		if (str == null || str.length == 0)
            return;
		char[] newstr = Arrays.copyOf(str, str.length);
		offset = offset % newstr.length;
		for (int i = 0; i < offset; i++) {
			str[i] = newstr[newstr.length - offset + i];
		}
		int j = 0;
		for (int i = offset; i < newstr.length; i++) {
			str[i] = newstr[j];
			j++;
		}
	}
}
