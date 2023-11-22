class ColorCryptograph{
  
  int map[][][];
  int sequence[] = {0,1,2,2,1,0,0,1,1,2,0};//may be generated logically

  int encIndex, decIndex;

  ColorCryptograph(String key){
    int r = Integer.parseInt( key.substring(0,2));
    int g = Integer.parseInt( key.substring(2,4));
    int b = Integer.parseInt( key.substring(4));

 
    int i,j,k;
    int n;
    int bands [] = {r,g,b};

    map = new int[3][16][16];

    encIndex = 0;
    decIndex = 0;

    for(i = 0; i< map.length; i++){

      n = bands[i];
      for(j = 0; j < map[i].length; j++){
        for(k = 0; k < map[i][j].length; k++){
          map[i][j][k] = n;
          n = (n+1) % 256;

        }//for(k ... 
      }//for(j ...
    }//for(i ...

  }//ColorCryptograph

 
  int encrypt(int data){
    //break the data into nibbles
    int r = data >> 4;
    int c = data & 0xF; //AND with 1111

    int result = map[sequence[encIndex]][r][c];
    encIndex = (encIndex+1)%sequence.length;
    return result;

  }
   
  int decrypt(int encData){

/*
    int i, j, k;
    i = sequence[decIndex];


    for(j= 0 ; j < map[i].length ; j++){
      for(k =0 ; k < map[i][j].length ; k++){
        if(map[i][j][k] == encData){
            decIndex= (decIndex+1)%sequence.length;
            return (j<<4) |k;
        }
      }//for(k
    }//for(j

    return 0;
*/

		//Following math replaces the nested loop
    int temp = (encData - map[sequence[decIndex]][0][0] + 256) % 256;
    int r = temp/16;
    int c = temp% 16;
    decIndex= (decIndex+1)%sequence.length;
    return (r<<4) | c;


  }
   
/*

  public static void main(String args[]){
  
     ColorCryptograph  cc = new ColorCryptograph(57, 123, 85);


     String data = "You must solve the cryptograph to find the correct coordinates";

     int i, l = data.length();
     int x;
   
     int encBuffer[] = new int[l];

     for(i =0 ; i < l; i++){
       x = (int)data.charAt(i);
       encBuffer[i] = cc.encrypt(x);
     }

     System.out.println();
     for(i =0 ; i < l ; i++){

       System.out.print((char)encBuffer[i]);
     }

     int decBuffer[] = new int[l];
     for(i =0 ; i < l; i++){
       x = encBuffer[i];
       decBuffer[i] = (int) cc.decrypt(x);
     }

     System.out.println();
     for(i =0 ; i < l ; i++){

       System.out.print((char)decBuffer[i]);
     }



  }//main
*/
}//ColorCryptograph