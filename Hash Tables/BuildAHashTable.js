class HashTable{
    constructor(size){
        this.data=Array(size);
    }

_hash(key){
    let hash=0;
    for(let i=0;i<key.length;i++){
        hash=(hash+key.charCodeAt(i)*i)%this.data.length;
    }
    return hash;
} //here is for loop but since we are iterating over only key, we won't consider hash function as O(n). Instead we can consider it as O(1)

set(key,value){
    let address=this._hash(key);
    console.log("address for "+key+":"+address);
    if(!this.data[address]){
        this.data[address]=[];
    }
    this.data[address].push([key,value]);
} //this O(1) as there is no iterations

get(key){
    let address=this._hash(key);
    const currentBucket=this.data[address];
    if(currentBucket){
        for(let i=0;i<currentBucket.length;i++){
            if(currentBucket[i][0]===key){
                return currentBucket[i][1];
            }
        }
    }
    return undefined;
} // if there is no collision , it will also be O(1)                          

keys(){
    const keysArray=[];
    for (let i=0; i<this.data.length;i++){
        if(this.data[i]){
            keysArray.push(this.data[i][0][0]);
        }
    }

    return keysArray;
}

} //we have to loop over whole memory



const myHashTable=new HashTable(100);
myHashTable.set('grapes',10000);
myHashTable.set('apples',20000);
myHashTable.set('oranges',30000);
myHashTable.set('banana',50000);

console.log(myHashTable.data);
console.log(myHashTable.get('grapes'));
console.log(myHashTable.get('apples'));
console.log(myHashTable.get('oranges'));
console.log(myHashTable.get('banana'));
console.log(myHashTable.get('grapesssssss'));

console.log(myHashTable.keys());