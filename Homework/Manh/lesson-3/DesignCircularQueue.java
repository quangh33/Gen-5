class MyCircularQueue {
    
    private int[] values;
	private int head;
	private int tail;
	private boolean isEmpty = true;

	public MyCircularQueue(int k) {
		this.values = new int[k];
	}

	public boolean enQueue(int value) {
		if (isFull())
			return false;
		this.values[this.tail % values.length] = value;
		this.tail = ++this.tail % values.length;
		this.isEmpty = false;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;
		this.values[this.head % values.length] = 0;
		this.head = ++this.head % values.length;
		if (this.head == this.tail) {
			this.isEmpty = true;
		}
		return true;
	}

	public int Front() {
		if (isEmpty())
			return -1;
		return values[head];
	}

	public int Rear() {
		if (isEmpty())
			return -1;
		return values[this.tail == 0 ? values.length - 1 : this.tail - 1];
	}

	public boolean isEmpty() {
		return head == tail && isEmpty;
	}

	public boolean isFull() {
		return tail - head == values.length || (head == tail && !isEmpty);
	}

	private void print() {
		String rs = String.format("\t\t\t(isEmpty=%s,head=%d,tail=%d,values=", this.isEmpty, this.head, this.tail);
		rs += String.format("[%d ", this.values[0]);
		for (int i = 1; i < this.values.length; i++) {
			rs += String.format(", %d ", this.values[i]);
		}
		System.out.println(rs + "])");
	}
    
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */