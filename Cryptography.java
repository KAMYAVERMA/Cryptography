import java.io.*;
import java.util.*;

class Cryptography{


  static boolean encrypt(String src, String trgt){
    try{
      KeyGenerator kgen = new KeyGenerator(1234);
      ArmstrongCryptograph ac = new ArmstrongCryptograph(kgen.getKey());
      ColorCryptograph  cc = new ColorCryptograph(kgen.getKey());


      FileInputStream fin = new FileInputStream(src);
      FileOutputStream fout = new FileOutputStream(trgt);

      int x, y, z; 
      while((x = fin.read()) != -1){
        
        y = ac.encrypt(x);
        z = cc.encrypt(y);
        fout.write(z);

      }//while
      System.out.println("C");
      fin.close();
      fout.close();
      System.out.println("D");
      return true;
    }catch(Exception ex){
      System.out.println("Error in encrypt: " + ex.getMessage()); 
      //ex.printStackTrace();  
      return false;
    }
 
  }//encrypt

  static boolean decrypt(String src, String trgt){
    try{

      KeyGenerator kgen = new KeyGenerator(1234);
      ArmstrongCryptograph ac = new ArmstrongCryptograph(kgen.getKey());
      ColorCryptograph  cc = new ColorCryptograph(kgen.getKey());

      FileInputStream fin = new FileInputStream(src);
      FileOutputStream fout = new FileOutputStream(trgt);

      int x, y,z; 
      while((z = fin.read()) != -1){
        y = cc.decrypt(z);
        x = ac.decrypt(y);
        fout.write(x);

      }//while

      fin.close();
      fout.close();
      return true;

    }catch(Exception ex){
      System.out.println("Error in decrypt: " + ex.getMessage()); 
      return false;
    }
 
  }//decrypt
    

  public static void main(String args[]){
    try{
 
      String srcFile, trgtFile;
      Scanner scn = new Scanner(System.in);
      int ch;  

      while(true){

        System.out.println("1. Encrypt ");         
        System.out.println("2. Decrypt ");         
        System.out.println("3. Exit");

        ch = scn.nextInt();

        if(ch == 1){

          System.out.println("Enter the absolute path of file to encrypt");
          srcFile = scn.next();
          System.out.println("Enter the absolute path of target file");
          //scn.next();
          trgtFile = scn.next();
          

          if(encrypt(srcFile, trgtFile))
             System.out.println("Encryption Successfull");
          else
             System.out.println("Encryption Failed");
    
        }else if(ch == 2){

          System.out.println("Enter the absolute path of file to decrypt");
          srcFile = scn.next();
          System.out.println("Enter the absolute path of target file");
          trgtFile = scn.next();
 
          if(decrypt(srcFile, trgtFile))
             System.out.println("Decryption Successfull");
          else
             System.out.println("Decryption Failed");

          
        }else if(ch == 3){

          break;

        }else{

          System.out.println("Wrong Choice"); 

        }
        
      }//while

    }catch(Exception ex){
      System.out.println("Error in decrypt: " + ex.getMessage()); 
    }

  }//main
}