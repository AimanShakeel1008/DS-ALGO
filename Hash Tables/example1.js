let user={
    age:54,
    name:'Kylie',
    magic:true,
    scream:function(){
        console.log('Ahhhhhhh!');
    }
}

user.age //O(1)
user.spell='Abracadabraaaaaa'; //O(1)
user.scream(); //O(1)
 