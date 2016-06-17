package com.ak.c2j.usage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import com.ak.c2j.utils.ConversionUtil;

public class ConvertionMain {
public static void main(String[] args) throws Exception{
	 FileInputStream in  = new FileInputStream("binary.ctl");
     int c;
     byte[] bytesRead = null;
     
     ByteArrayOutputStream ous = new ByteArrayOutputStream();
     
     
     while(true){
    	 c = in.read();
    	 if(c==-1){
      		break;
      	}
     		ous.write(c);	
     }
     bytesRead = ous.toByteArray();
     
     byte[] secondField = new byte[2];
     
     secondField[0]= bytesRead[2];
     secondField[1]=bytesRead[3];
     
     System.out.println(new String(secondField,"cp037")); // string
     
     
     byte[] eighthField = new byte[5];
     eighthField[0]=bytesRead[52];
     eighthField[1]=bytesRead[53];
     eighthField[2]=bytesRead[54];
     eighthField[3]=bytesRead[55];
     eighthField[4]=bytesRead[56];
     
     System.out.println("Eighth Field "+ConversionUtil.convertCOMP3ToString(eighthField, 0)); // comp3 integer
     
     
     
     
     byte[] fifteenthField = new byte[8];
     fifteenthField[0]=bytesRead[102];
     fifteenthField[1]=bytesRead[103];
     fifteenthField[2]=bytesRead[104];
     fifteenthField[3]=bytesRead[105];
     fifteenthField[4]=bytesRead[106];
     fifteenthField[5]=bytesRead[107];
     fifteenthField[6]=bytesRead[108];
     fifteenthField[7]=bytesRead[109];
     
     System.out.println("fifteenthField Field "+ConversionUtil.convertCOMP3ToString(fifteenthField, 2)); // comp3 decimal
     
     System.out.println(bytesRead.length);
     in.close();
}
}
