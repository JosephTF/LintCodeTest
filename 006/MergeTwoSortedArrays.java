/**
 * �ϲ�������������
 * 
 * ����A=[1,2,3,4]��B=[2,4,5,6]������ [1,2,2,3,4,4,5,6]
 * 
 * @author Joseph 2018/3/9
 *
 */
public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 2, 4, 5, 6 };
		int[] mergedArray = getMergedArray(arr1, arr2);
		int[] result= mergeSortedArray(arr1, arr2);
		for (int i = 0; i <= mergedArray.length - 1; i++) {
			System.out.print(mergedArray[i]+" ");
		}
		System.out.println("");
		for (int i = 0; i <= result.length - 1; i++) {
			System.out.print(result[i]+" ");
		}
	}

	/*
	 * ���� �ȶ���һ�������������ϲ�������������� �Ƚ�����������С��ֵ ����һ��ȫ�����룬��һ������ʣ�µ�ֱֵ�Ӽӽ�ȥ����
	 */
	private static int[] getMergedArray(int[] arr1, int[] arr2) {
		int[] mergedArray = new int[arr1.length + arr2.length];
		int i = 0, j = 0, index = 0;
		while (i <= arr1.length - 1 && j <= arr2.length - 1) {
			if (arr1[i] < arr2[j]) {
				mergedArray[index] = arr1[i];
				i++;
			} else {
				mergedArray[index] = arr2[j];
				j++;
			}
			index++;
		}
		if (i == arr1.length) {
			// arr2��ʣ��
			for (int k = j; k <= arr2.length - 1; k++) {
				mergedArray[index] = arr2[k];
				index++;
			}
		} else {
			// arr1��ʣ��
			for (int k = i; k <= arr1.length - 1; k++) {
				mergedArray[index] = arr1[k];
				index++;
			}
		}
		return mergedArray;
	}

	/*
	 * �Ż��Ĳ�����㷨
	 */
	private static int[] mergeSortedArray(int[] A, int[] B) {
		// �ǿ��ж�
		if (A == null || B == null) {
			return null;
		}
		int[] result = new int[A.length + B.length];
		int i = 0, j = 0, index = 0;
		
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				result[index++] = A[i++];
			} else {
				result[index++] = B[j++];
			}
		}
		while (i < A.length) {
			result[index++] = A[i++];
		}
		while (j < B.length) {
			result[index++] = B[j++];
		}
		return result;
	}

}
