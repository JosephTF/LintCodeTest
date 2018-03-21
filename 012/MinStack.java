import java.util.Stack;

/**
 * 带最小值操作的栈
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 * 实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
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
	 * 入栈
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
	 * 出栈
	 */
	public int pop() {
		minStack.pop();
		return stack.pop();
	}

	/**
	 * 求得最小值
	 */
	public int min() {
		return minStack.peek();
	}
	
	/**
	 * 
	 * 第二种方法：给minStack节省更多空间，而且不影响时间复杂度
	 * 
	 */
    public void push2(int number) {
        stack.push(number);
        if (minStack.empty() == true)
            minStack.push(number);
        else {
        // 这里考虑的相等的情况也会继续push
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
