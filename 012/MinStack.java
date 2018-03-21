import java.util.Stack;

/**
 * ����Сֵ������ջ
 * ʵ��һ������ȡ��Сֵmin������ջ��min���������ص�ǰջ�е���Сֵ��
 * ʵ�ֵ�ջ��֧��push��pop �� min ���������в���Ҫ����O(1)ʱ������ɡ�
 * @author Joseph
 * 
 * 2018/3/21
 *
 */
public class MinStack {
	private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }


	/**
	 * ��ջ
	 */
	public void push(int number) {
		stack.push(number);
		if(minStack.isEmpty()){
			minStack.push(number);
		}else{
			minStack.push(Math.min(number, minStack.peek()));
		}
	}

	/**
	 * ��ջ
	 */
	public int pop() {
		minStack.pop();
		return stack.pop();
	}

	/**
	 * �����Сֵ
	 */
	public int min() {
		return minStack.peek();
	}
	
	/**
	 * 
	 * �ڶ��ַ�������minStack��ʡ����ռ䣬���Ҳ�Ӱ��ʱ�临�Ӷ�
	 * 
	 */
    public void push2(int number) {
        stack.push(number);
        if (minStack.empty() == true)
            minStack.push(number);
        else {
        // ���￼�ǵ���ȵ����Ҳ�����push
        if (minStack.peek() >= number)
            minStack.push(number);
        }
    }

    public int pop2() {
        if (stack.peek().equals(minStack.peek()) ) 
            minStack.pop();
        return stack.pop();
    }

    public int min2() {
        return minStack.peek();
    }
}
