import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NewClass 
{
    

    static String filepath="E:/Presentation/Dali.pps";
    
    public static void main(String args[]) throws IOException 
    {
        ServerSocket server1;
        Socket client=null;
        BufferedInputStream bis;
        DataOutputStream bos;
        
            try
                
        {
            server1 = new ServerSocket(20000);
            do{client = server1.accept();
            System.out.println(1);
            bos = new DataOutputStream(client.getOutputStream());
            bis = new BufferedInputStream(client.getInputStream());
            DataInputStream f = new DataInputStream(new FileInputStream("E:/s.txt"));
            byte[] b = new byte[10000];
            int s = f.available();
            byte c = 0,i=0,k=0;
            while(s!=0)
            {
                
                c=f.readByte();
               
                k=i;
                b[i++]=c;
                System.out.print((char)b[k]);
                s--;
            }
            bos.writeInt(i);
            for(int u =0;u<i;u++)
               bos.writeByte(b[u]);
            bos.close();
            f.close();
       }while(true);                 
        }
        
       catch(Exception e)
    {
        System.out.println(e);
        }    
       
    }
}