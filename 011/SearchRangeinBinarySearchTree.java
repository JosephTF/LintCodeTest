import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �������������������
 * 
 * ��������ֵ k1 �� k2��k1 < k2����һ������������ĸ��ڵ㡣�ҵ���������ֵ�� k1 �� k2 ��Χ�ڵĽڵ㡣����ӡ����x (k1 <= x <=
 * k2) ���� x �Ƕ�����������еĽڵ�ֵ��������������Ľڵ�ֵ��
 * 
 * @author Joseph
 * 
 *         2018/3/21
 *
 */
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class SearchRangeinBinarySearchTree {
	public static ArrayList<Integer> searchArray;

	public static void main(String[] args) {
		// create new binary search tree
		TreeNode tree = new TreeNode(20);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(40);
		tree.right.left = new TreeNode(35);
		System.out.println("���������" + searchRange2(tree, 17, 37).toString());
		;
	}

	/**
	 * ��һ������ʶ�㷨���Ȱ����нڵ�Ž����У�Ȼ������Ƚ�
	 * 
	 * @param root
	 * @param k1
	 * @param k2
	 * @return
	 */
	public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
		if (root == null | k1 > k2) {
			return null;
		}
		searchArray = new ArrayList<>();
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		for (int i = 0; i < queue.size(); i++) {
			TreeNode node = queue.get(i);
			if (node == null) {
				continue;
			}
			queue.add(node.left);
			queue.add(node.right);
		}
		while (queue.get(queue.size() - 1) == null) {
			queue.remove(queue.size() - 1);
		}
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i) == null) {
				continue;
			}
			int val = queue.get(i).val;
			if (val >= k1 && val <= k2) {
				searchArray.add(val);
			}
		}
		Collections.sort(searchArray);
		return searchArray;
	}

	/**
	 * ������һ���˽⵽��������������������������������ԣ� 
	 * ��1�������������գ��������������н���ֵ��С�ڻ�������ĸ�����ֵ��
	 * ��2�������������գ��������������н���ֵ�����ڻ�������ĸ�����ֵ�� 
	 * ��3����������Ҳ�ֱ�Ϊ������������
	 * ���Բ���Ҫ��ȡÿһ���ڵ㣬ֱ�ӴӸ��ڵ㿪ʼ�жϽ�ȡk1,k2֮������нڵ㼴��
	 */
	public static List<Integer> searchRange2(TreeNode root, int k1, int k2) {
		if (root == null | k1 > k2) {
			return null;
		}
		searchArray = new ArrayList<>();
		checkRange(root, k1, k2);
		return searchArray;
	}

	public static void checkRange(TreeNode root, int k1, int k2) {
		if (root == null) {
			return;
		}
		// �����жϣ�val>k1;val>=k1&&val<=k2;val<k2�������˳���жϣ��ó��Ķ���Ҳ������ģ���С����һ�����ӽ�ȥ
		if (root.val > k1) {
			// �ڵ�ֵ������ֵ���ж�������
			checkRange(root.left, k1, k2);
		}
		if (root.val >= k1 && root.val <= k2) {
			// �ڵ����Ҫ�󣬼ӽ�����
			searchArray.add(root.val);
		}
		if (root.val < k2) {
			// �ڵ�ֵС����ֵ���ж�������
			checkRange(root.right, k1, k2);
		}
	}
}
