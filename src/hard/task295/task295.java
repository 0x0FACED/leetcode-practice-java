// TOOOO SLOW Solution - 2000 ms+ on leetcode, but 97% memory usage beats

class MedianFinder {
    int[] _values;
    int _capacity = 100000; 
    double _loadFactor = 0.8;
    int _count = 0;

    public MedianFinder() {
        _values = new int[_capacity];
    }
    
    public void addNum(int num) {
        if(_count >= _loadFactor * _capacity){
            ensureCapacity();
        }
        _values[_count++] = num;
    }

    private void ensureCapacity(){
        int[] temp = new int[_count];
        System.arraycopy(_values, 0, temp, 0, _count);
        _capacity = _count + _count / 2;
        _values = new int[_capacity];
        System.arraycopy(temp, 0, _values, 0, _count);
    }
    
    public double findMedian() {
        Arrays.sort(_values, 0, _count);
        if(_count % 2 == 1){
            return _values[_count / 2];
        } else {
            return (double)(_values[_count / 2] + _values[_count / 2 - 1]) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
