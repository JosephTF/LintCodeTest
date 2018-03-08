/**
 * 在数组中找到第k大的元素 给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，第三大的元素是 3，以此类推
 * 
 * 给出数组[9,3,2,4,8]，第三大的元素是 4
 * 
 * @author Joseph
 * 
 *         2018/3/7
 *
 */
public class KthLargestElement {

	public static void main(String[] args) {
		int[] nums = { 9, 3, 2, 4, 8 };
		int k = 3;
		int left = 0;// 左侧下标
		int right = nums.length - 1;// 右侧下标
		getElement(nums, left, right);
		System.out.println("数组中第" + k + "大元素是" + nums[nums.length - k]);
	}

	/*
	 * 快速排序
	 */
	private static void getElement(int[] nums, int left, int right) {
		int i = left;
		int j = right;
		int povit = nums[left];// 参照值
		while (i < j) {
			while (i < j && nums[j] >= povit) {
				j--;
			}
			if (i < j) {
				swap(nums, i, j);
				i++;
			}
			while (i < j && nums[i] <= povit) {
				i++;
			}
			if (i < j) {
				swap(nums, i, j);
				j--;
			}
		}
		if (i > left) {
			getElement(nums, left, i - 1);
		}
		if (i < right) {
			getElement(nums, i + 1, right);
		}
	}

	/*
	 * 数组中a,b交换
	 */
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
