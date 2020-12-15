import java.util.ArrayList;
import java.util.List;

/*Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.*/

class MyHashMap {
    private final int MAX_LENGTH=10000;
   private List<ArrayList<Integer>>[] map;
   /** Initialize your data structure here. */
   
   private int hashFunction(int key){
       return key%MAX_LENGTH;
   }
   
   public MyHashMap() {
       map=(List<ArrayList<Integer>>[])new ArrayList[MAX_LENGTH];
   }
   
   public void put(int key, int value) {
       
       int index=hashFunction(key);
       //int toAddBucket=-1;
       if(map[index]==null) {
       	map[index]=new ArrayList<ArrayList<Integer>>();
       }
       
       List<ArrayList<Integer>> a=map[index];
       
       int toAddIndex=-1;
       for(int i=0;i<a.size();++i){
       	ArrayList<Integer> b=a.get(i);
           if(b.get(0)==key){
                b.set(1, value);
                toAddIndex=i;
           }
       }
       if(toAddIndex==-1) {
       ArrayList<Integer> temp=new ArrayList<Integer>();
       
       temp.add(key);
       temp.add(value);
       map[index].add(temp);
       }
       
   }
   
   public void remove(int key) {
       int index=hashFunction(key);
       int toRemoveIndex=-1;
       if(map[index]!=null){
           List<ArrayList<Integer>> a=map[index];
           for(int i=0;i<a.size();++i){
           	ArrayList<Integer> b=a.get(i);
               if(b.get(0)==key){
                    toRemoveIndex=i;
               }
               if(toRemoveIndex>=0){
               map[index].remove(toRemoveIndex);
               }
           }
       }
   }
   
   	public int get(int key) {
   		 int index=hashFunction(key);
   		 if(null!=map[index]) {
   			 List<ArrayList<Integer>> a=map[index];
   			 for(int i=0;i<a.size();i++) {
   				 ArrayList<Integer> b=a.get(i);
   				if(b.get(0)==key) {
   					return b.get(1);
   				}
   			 }
   			 return -1;
   		 }
   		return -1;
   		}
}
/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/
/*Your input
["MyHashMap","put","put","get","get","put","get", "remove", "get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]
Your answer
[null,null,null,1,-1,null,1,null,-1]
Expected answer
[null,null,null,1,-1,null,1,null,-1]*/