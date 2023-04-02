class MyHashSet {
    List<Integer>[] _container;
    int _capacity = 1000;
    double _loadFactor = 0.75;
    int _count = 0; 
    /** Initialize your data structure here. */
    public MyHashSet() {
        _container = new ArrayList[_capacity];
    }
    
    public void add(int key) {
        if(contains(key)) return;

        if(_loadFactor * _capacity == _count){
            _count = 0;
            //rehash
            _capacity += _capacity / 2;
            List<Integer>[] temp = _container;
            _container = new ArrayList[_capacity];
            for(int i = 0; i < temp.length; ++i){
                List<Integer> list = temp[i];
                if(list != null){
                    for(int entry : list)
                       this.add(entry); 
                }
            }
        }
        int hash = key % _capacity;
        if(_container[hash] == null)
            _container[hash] = new ArrayList<>();
        _container[hash].add(key);
        ++_count;
    }
    
    public void remove(int key) {
        int hash = key % _capacity;
        List<Integer> list = _container[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext()){
                if(itr.next() == key){
                    itr.remove();
                    --_count;
					          break;
                }
            } 
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % _capacity;
        List<Integer> list = _container[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext())
                if(itr.next() == key)
                    return true;
        }
        return false;
    }
}
