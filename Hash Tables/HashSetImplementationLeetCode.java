/*Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.


Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.*/

class MyHashSet {
    private final int MAX_LENGTH=10000;
    private List<Integer>[] set;
    /** Initialize your data structure here. */
    
    private int hashFunction(int key){
        return key%MAX_LENGTH;
    }
    
    public MyHashSet() {
        set=(List<Integer>[])new ArrayList[MAX_LENGTH];
    }
    
    public void add(int key) {
        
        int index=hashFunction(key);
        
        if(set[index]==null){
            set[index]=new ArrayList<Integer>();
        }
        
        List<Integer> temp=set[index];
        int toAddBucket=-1;
        for(int i=0;i<temp.size();i++){
            if(temp.get(i)==key){
                toAddBucket=i;
            }
        }
        if(toAddBucket<0){
        set[index].add(key);   
        }
    }
    
    public void remove(int key) {
        int index=hashFunction(key);
        int toRemoveIndex=-1;
        if(set[index]!=null){
            List<Integer> temp=set[index];
            for(int i=0;i<temp.size();++i){
                if(temp.get(i)==key){
                     toRemoveIndex=i;
                }
                if(toRemoveIndex>=0){
                set[index].remove(toRemoveIndex);
                }
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=hashFunction(key);
        if(set[index]!=null){
            List<Integer> temp=set[index];
            for(int i=0;i<temp.size();++i){
                if(temp.get(i)==key){
                    return true;
                }  
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
 
/*Run Code Result:
Your input
["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
[[],[1],[2],[1],[3],[2],[2],[2],[2]]
Your answer
[null,null,null,true,false,null,true,null,false]
Expected answer
[null,null,null,true,false,null,true,null,false]*/