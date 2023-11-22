class ArmstrongCryptograph{

   int encIndex;
   int decIndex;
   int key[];  
   ArmstrongCryptograph(String k){

     int i, l;
     l = k.length();
    
     key = new int[l];

     for(i =0 ; i < l; i++){
       key[i] = (int) (k.charAt(i) - 48);
       //System.out.println(key[i]);    
       
     }

   }//ArmstronCryptograph()

   int encrypt(int x){
     int temp = x ^ key[encIndex];
     encIndex = (encIndex+1) % key.length;
     return temp;
   }

   int decrypt(int x){
     int temp = x ^ key[decIndex];
     decIndex = (decIndex+1) % key.length;
     return temp;
   }
   
}//ArmstrongCryptograph