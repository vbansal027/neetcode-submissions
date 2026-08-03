class MinStack {

    private final int size = 10000;
    private final int[] min;
    private final int[] arr;
    private int top;

    public MinStack() {
        min = new int[size];
        arr = new int[size];
        top = -1;
    }
    
    public void push(int val) {
        if (top+1 < size-1) {
            arr[top+1] = val;
            if (top < 0) {
                min[top+1] = val;
            } else {
                min[top+1] = Math.min(min[top], val);
            }
            top++;
        }
    }
    
    public void pop() {
        if (top > -1) {
            top--;
        }
    }
    
    public int top() {
        if (top > -1) {
            return arr[top];
        } else {
            return -1;
        }
    }
    
    public int getMin() {
        if (top > -1) {
            return min[top];
        } else {
            return -1;
        }
    }
}
