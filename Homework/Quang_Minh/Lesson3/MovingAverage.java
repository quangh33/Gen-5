class MovingAverage {

   
    Queue<Integer> queue;
    int sum = 0;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList();
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        
        return (double)sum / queue.size();
    }
}