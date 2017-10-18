package server2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Server2 extends javax.swing.JFrame implements Runnable {
    ServerSocket server2;
    Socket client;
    DataInputStream fromClient, fromFile;
    DataOutputStream toClient, toFile;
    BufferedReader br;
    Connection con;
    Statement stmt,stmt1;    
    ResultSet rs;
    Thread t;
    String filepath = "E:/VC/StudyMaterial/";

    public Server2() throws IOException, ClassNotFoundException {
        initComponents();
                t=new Thread(this);
                t.start();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Running server2...");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(280, 20, 200, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 700, 390);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server2/Grey-website-background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 760, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
                Thread t = new Thread();
t.start();
        //Set the Nimbus look and feel
try
        {
for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
if ("Nimbus".equals(info.getName()))
                {
javax.swing.UIManager.setLookAndFeel(info.getClassName());
break;
                }
            }
        }
catch (ClassNotFoundException ex)
        {java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (InstantiationException ex)
        {java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (IllegalAccessException ex)
        {java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (javax.swing.UnsupportedLookAndFeelException ex)
        {java.util.logging.Logger.getLogger(Server2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {                    
new Server2().setVisible(true);
                }
catch (IOException ex) {
Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
                }
catch (ClassNotFoundException ex)
                {
Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
   public char[] read()
   {
       char b[]= new char[16777216];
       int i=0;
       try { 
         
            while((b[i]=fromClient.readChar())!='$')   i++;
        }
        catch (IOException ex) {
            Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
        }
        char a[]= new char[i];
            for(int j = 0; j<i ; j++)
            {    a[j]=b[j];
                System.out.print((char)a[j]);
            }
            return a;
   }    
    public void chararray(char r[])
    {
        try {
            for(int i=0;i<r.length;i++)
            {
                toClient.writeChar(r[i]);
            }
            toClient.writeChar('$');
        }
        catch (IOException ex) {
                Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
         }
    }  
   
    
    
    public void run() {
    try
    {
        server2 =new ServerSocket(2015);
    do
    {
            jTextArea1.append("Waiting for client");
            client=server2.accept();
            jTextArea1.append(":  "+String.valueOf(client)+"\n");
            fromClient = new DataInputStream(client.getInputStream());
            toClient = new DataOutputStream(client.getOutputStream());
            String str = new String(read());
            
            switch(str)
            {
                case "Initialise":
        try
        {
            System.out.println(0);
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con= DriverManager.getConnection("jdbc:odbc:VC");
            stmt=con.createStatement();                            

            rs=stmt.executeQuery("select`TName`,`Subject` from `Test`");
            System.out.println(0);
            while(rs.next())          
            {                
               chararray(rs.getString("Subject").toCharArray());
               chararray(rs.getString("TName").toCharArray());
            }
            chararray("Testdone".toCharArray());
            System.out.println(2);
            rs=stmt.executeQuery("select`FName`,`Subject` from `File`");
            while(rs.next())          
            {                
               chararray(rs.getString("Subject").toCharArray());
               chararray(rs.getString("FName").toCharArray());
            }
            chararray("Filedone".toCharArray());
            System.out.println(3);
            rs.close();
            stmt.close();
            con.close();      
        }       
        catch(ClassNotFoundException | SQLException e)
        {
        jTextArea1.append(String.valueOf(e));
        }
        break;//end of case "Initialise"
    
                
                case "FileDownload":
                try
                {
                    
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    con= DriverManager.getConnection("jdbc:odbc:VC");
                    stmt=con.createStatement();                            
                    System.out.println(0);
                    
                    String subject = new String(read());
                    String file = new String(read());
                    rs=stmt.executeQuery("select * from `File`");
            
                    while(rs.next())
                    {
                        String extension = rs.getString("FName");
                        if(subject.equals(rs.getString("Subject"))&&file.equals(extension))
                        {
                            int l = extension.lastIndexOf('.');
                                while(l<extension.length())
                                { System.out.print(extension.charAt(l));toClient.writeChar(extension.charAt(l++));}
                                toClient.writeChar('$');
                             System.out.println(1);
                             fromFile = new DataInputStream(new FileInputStream(rs.getString("Path")));
                             
                             byte[] b = new byte[16777216];
                             int s = fromFile.available();
                             byte h = 0; int i=0,k=0;
                             while(s!=0)
                             {
                                 h=fromFile.readByte();
                                 k=i;
                                 b[i++]=h;
                                 System.out.print((char)b[k]);
                                 s--;
                             }
                             toClient.writeInt(i);
                             for(int u =0;u<i;u++)
                             toClient.writeByte(b[u]);
                             fromFile.close();
                             chararray("DownloadComplete".toCharArray());
                        }
                    }
     }
     catch(Exception e)
     {
         chararray("DownloadUnsuccessful".toCharArray());
         e.printStackTrace();
     } 
                    break;  //end of case FileDownload
                
                case "FileUpload":
                try
                {
                   String fname = new String(read());
                   String subject = new String(read());
                   byte b[] = new byte[fromClient.readInt()];
                   for(int i = 0; i<b.length; i++)
                   b[i]= fromClient.readByte();
                   toFile = new DataOutputStream(new FileOutputStream(filepath+fname));
                   toFile.write(b);
                   toFile.close();
                    
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    con= DriverManager.getConnection("jdbc:odbc:VC");
                    stmt=con.createStatement();                            
                    System.out.println(0);
                    String Path = filepath+fname;
                    stmt.executeUpdate("insert into `File`(`Subject`,`FName`,`Path`) values('"+subject+"','"+fname+"','"+Path+"')");
                    stmt.close();
                    chararray("UploadSuccessful".toCharArray());
                    String status = new String(read());
                    if(status.equals("UploadComplete"))
                      JOptionPane.showMessageDialog(this, "New File has been uploaded to the Server", "Upload Successful", JOptionPane.OK_OPTION);
                    else if(status.equals("UploadUnsuccessful"))
                      JOptionPane.showMessageDialog(this, "New file cannot be uploaded. Please try  again later", "Upload Unsuccessful", JOptionPane.ERROR_MESSAGE);
                    
            
                        }
     catch(Exception e)
     {
         chararray("UploadUnsuccessful".toCharArray());
         System.out.println(e);
     } 

break;//end of case "FileUpload"
                    
    }
}
while(true);
}
catch(Exception e)
{
    System.out.println(e);
}
}

}
