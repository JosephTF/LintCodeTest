/**
 * ���������ҵ���k���Ԫ�� �������� [1,2,3,4,5]����һ���Ԫ���� 5���ڶ����Ԫ���� 4���������Ԫ���� 3���Դ�����
 * 
 * ��������[9,3,2,4,8]���������Ԫ���� 4
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
		int left = 0;// ����±�
		int right = nums.length - 1;// �Ҳ��±�
		getElement(nums, left, right);
		System.out.println("�����е�" + k + "��Ԫ����" + nums[nums.length - k]);
	}

	/*
	 * ��������
	 */
	private static void getElement(int[] nums, int left, int right) {
		int i = left;
		int j = right;
		int povit = nums[left];// ����ֵ
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
	 * ������a,b����
	 */
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
