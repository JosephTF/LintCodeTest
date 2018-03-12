import java.util.ArrayList;

/**
 * 序列化和反序列化二叉树
 * 
 * @author Administrator
 *
 */
public class BinaryTreeSerialization {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(serialize(root));
		System.out.println(deserialize("{1,2,3,4,#,5,6}").right.left.val);
	}

	/*
	 * 二叉树序列化
	 * 
	 */
	public static String serialize(TreeNode root) {
		// 树结构为空
		if (root == null) {
			return "{}";
		}
		// 建立数组列表存放所有节点（包括空节点），最底层会再添加一层全部为空的节点
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
		//删除最底层的所有空节点
		while (queue.get(queue.size() - 1) == null) {
			queue.remove(queue.size() - 1);
		}
		// 序列化输出
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(queue.get(0).val);
		for (int i = 1; i < queue.size(); i++) {
			if (queue.get(i) == null) {
				sb.append(",#");
			} else {
				sb.append(",");
				sb.append(queue.get(i).val);
			}
		}
		sb.append("}");
		return sb.toString();
	}

	/*
	 * 反序列化
	 */
	public static TreeNode deserialize(String data) {
		if (data.equals("{}")) {
			return null;
		}
		int index = 0;
		String[] vals = data.substring(1, data.length() - 1).split(",");//去括号拆分
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(vals[index]));//根节点
		queue.add(root);
		boolean isLeftChild = true;
		for (int i = 1; i < vals.length; i++) {
			if (!vals[i].equals("#")) {
				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				if (isLeftChild) {
					queue.get(index).left = node;
				} else {
					queue.get(index).right = node;
				}
				queue.add(node);
			}
			if (!isLeftChild) {
				index++;
			}
			isLeftChild = !isLeftChild;
		}
		return root;
	}
}

// 树节点类
class TreeNode {
	// 三个要素
	public int val; // 值
	public TreeNode left, right; // 左子树，右子树
	// 构造函数

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}