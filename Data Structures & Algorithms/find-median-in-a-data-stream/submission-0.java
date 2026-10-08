class MedianFinder {
    private PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    private PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
    int n, m;
    public MedianFinder() {

    }

    public void addNum(int num) {
        maxPQ.add(num);
        n++;
        if (n - m > 1 || m != 0 && minPQ.peek() < maxPQ.peek()) {
            minPQ.add(maxPQ.poll());
            m++;
            n--;
        }
        if( m - n > 1) {
            maxPQ.add(minPQ.poll());
            m--;
            n++;
        }
    }

    public double findMedian() {
        if ((n + m) % 2 == 0) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        } else if ( n > m) {
            return maxPQ.peek();
        }else{
            return minPQ.peek();
        }
    }
}
