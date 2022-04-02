var MyCircularQueue = function (k) {
    this.capacity = k;
    this.tail = new this.Node();
    this.head = this.tail;
    for (let i = 1; i < this.capacity; i++) {
        this.head = new this.Node(undefined, this.head);
    }
    this.tail.next = this.head;
    this.length = 0;
};

MyCircularQueue.prototype.Node = function (value, next) {
    this.value = value ? value : undefined;
    this.next = next ? next : null;
};

MyCircularQueue.prototype.enQueue = function (value) {
    if (this.isFull()) {
        return false;
    }
    this.tail = this.tail.next;
    this.tail.value = value;
    this.length++;
    return true;
};

MyCircularQueue.prototype.deQueue = function () {
    if (this.isEmpty()) {
        return false;
    }
    this.head = this.head.next;
    this.length--;
    return true;
};

MyCircularQueue.prototype.Front = function () {
    return this.isEmpty() ? -1 : this.head.value;
};

MyCircularQueue.prototype.Rear = function () {
    return this.isEmpty() ? -1 : this.tail.value;
};

MyCircularQueue.prototype.isEmpty = function () {
    return this.length == 0;
};

MyCircularQueue.prototype.isFull = function () {
    return this.length == this.capacity;
};

// https://leetcode.com/problems/design-circular-queue/

// Input
//     ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
//     [[3], [1], [2], [3], [4], [], [], [], [4], []]
// Output
//     [null, true, true, true, false, 3, true, true, true, 4]
//
// Explanation
// MyCircularQueue myCircularQueue = new MyCircularQueue(3);
// myCircularQueue.enQueue(1); // return True
// myCircularQueue.enQueue(2); // return True
// myCircularQueue.enQueue(3); // return True
// myCircularQueue.enQueue(4); // return False
// myCircularQueue.Rear();     // return 3
// myCircularQueue.isFull();   // return True
// myCircularQueue.deQueue();  // return True
// myCircularQueue.enQueue(4); // return True
// myCircularQueue.Rear();     // return 4