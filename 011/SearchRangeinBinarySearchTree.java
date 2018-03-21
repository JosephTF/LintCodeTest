import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉查找树中搜索区间
 * 
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。即打印所有x (k1 <= x <=
 * k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
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
		System.out.println("搜索结果：" + searchRange2(tree, 17, 37).toString());
		;
	}

	/**
	 * 第一种下意识算法：先把所有节点放进队列，然后遍历比较
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
	 * 后来进一步了解到二叉搜索树（二叉查找树）有以下特性： 
	 * （1）若左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值；
	 * （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值； 
	 * （3）左、右子树也分别为二叉排序树；
	 * 所以不需要获取每一个节点，直接从根节点开始判断截取k1,k2之间的所有节点即可
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
		// 三次判断：val>k1;val>=k1&&val<=k2;val<k2。按这个顺序判断，得出的队列也是有序的，从小到大一个个加进去
		if (root.val > k1) {
			// 节点值大于左值域，判断左子树
			checkRange(root.left, k1, k2);
		}
		if (root.val >= k1 && root.val <= k2) {
			// 节点符合要求，加进队列
			searchArray.add(root.val);
		}
		if (root.val < k2) {
			// 节点值小于右值域，判断右子树
			checkRange(root.right, k1, k2);
		}
	}
}
