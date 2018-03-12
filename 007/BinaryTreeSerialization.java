import java.util.ArrayList;

/**
 * ���л��ͷ����л�������
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
	 * ���������л�
	 * 
	 */
	public static String serialize(TreeNode root) {
		// ���ṹΪ��
		if (root == null) {
			return "{}";
		}
		// ���������б������нڵ㣨�����սڵ㣩����ײ�������һ��ȫ��Ϊ�յĽڵ�
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
		//ɾ����ײ�����пսڵ�
		while (queue.get(queue.size() - 1) == null) {
			queue.remove(queue.size() - 1);
		}
		// ���л����
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
	 * �����л�
	 */
	public static TreeNode deserialize(String data) {
		if (data.equals("{}")) {
			return null;
		}
		int index = 0;
		String[] vals = data.substring(1, data.length() - 1).split(",");//ȥ���Ų��
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(vals[index]));//���ڵ�
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

// ���ڵ���
class TreeNode {
	// ����Ҫ��
	public int val; // ֵ
	public TreeNode left, right; // ��������������
	// ���캯��

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}