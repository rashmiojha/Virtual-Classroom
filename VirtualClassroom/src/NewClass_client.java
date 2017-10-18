
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.net.Socket;
import java.net.UnknownHostException;

public class NewClass_client 
{
     public static void main(String args[]) throws UnknownHostException, IOException
     {
    
            Socket client=null;
            FileOutputStream fis = null;
            BufferedInputStream bis = null;
            BufferedOutputStream os = null;    
            DataInputStream oos;
            
            try{
                
            client=new Socket("localhost",20000);
            oos = new DataInputStream(client.getInputStream());
             
             byte [] b = new byte[oos.readInt()];
                 oos.read(b);
                   
              DataOutputStream f = new DataOutputStream(new FileOutputStream("E:/st.txt"));
                   f.write(b);
                   f.close();
               oos.close();
            }
        catch(Exception e){
            System.out.print(e);

        }
   }
   }