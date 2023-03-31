// Method 1

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
      
        while(!stack1.isEmpty()) {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        stack1.push(x);
        
        while(!stack2.isEmpty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
          
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

// Method 2 xD solution

class MyQueue {
    Deque<Integer> stack;

    public MyQueue() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public int pop() {
        return stack.pollFirst();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
