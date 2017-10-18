package server1;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server1 extends javax.swing.JFrame implements Runnable {
    ServerSocket server1;
    Socket client;
    BufferedReader in;
    PrintWriter out;
    Connection con;
    Statement stmt,stmt1;    
    ResultSet rs;
    Thread t;
static String s14="";
static String filepath="E:/VC/";
static String filepath2 = "E:/VC/StudyMaterial/" ;
    public Server1() throws IOException, ClassNotFoundException {
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
        jLabel3.setText("Running server1...");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(280, 20, 200, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 700, 390);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server1/Grey-website-background.jpg"))); // NOI18N
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
        {java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (InstantiationException ex)
        {java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (IllegalAccessException ex)
        {java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
catch (javax.swing.UnsupportedLookAndFeelException ex)
        {java.util.logging.Logger.getLogger(Server1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {                    
new Server1().setVisible(true);
                }
catch (IOException ex) {
Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                }
catch (ClassNotFoundException ex)
                {
Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
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
    public void run() {
try
    {
        server1 =new ServerSocket(2014);
do
        {
jTextArea1.append("Waiting for client");
client=server1.accept();
in=new BufferedReader(new InputStreamReader(client.getInputStream()));
out=new PrintWriter(client.getOutputStream(),true);
            String str = in.readLine(); 
             String path = "";
switch(str)
            {
case "Slogin":
try
                {
jTextArea1.append(String.valueOf(client));
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con= DriverManager.getConnection("jdbc:odbc:VC");
stmt=con.createStatement();                            
                    String str1=in.readLine(); //password
                    String str2=in.readLine(); //username                    
rs=stmt.executeQuery("select`Email`,`Password` from `StudentLogin`");
boolean flag=false;               
while(rs.next())          
                    {                
                       String s1=rs.getString("Email"), s2=rs.getString("Password");
                        if(s1.equals(str2)&&s2.equals(str1))
                        {                   
                            flag=true;
                            out.println("login success");
                            break;
                        }         
                    
                    }               
if(!flag)
out.println("login failed");       
rs.close();
stmt.close();
con.close();      
                }       
catch(ClassNotFoundException | SQLException | IOException e)
                {
jTextArea1.append(String.valueOf(e));
                }
break;//end of case "Slogin"

    case "Flogin":
    try
                {
jTextArea1.append(String.valueOf(client));
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con= DriverManager.getConnection("jdbc:odbc:VC");
stmt=con.createStatement();                            
                    String str1=in.readLine(); //password
                    String str2=in.readLine(); //username                    
rs=stmt.executeQuery("select`Login_ID`,`Password` from `FacultyLogin`");
boolean flag=false;               
while(rs.next())          
                    {                
                       String s1=rs.getString("Login_ID"), s2=rs.getString("Password");
                        if(s1.equals(str2)&&s2.equals(str1))
                        {                   
                            flag=true;
                            out.println("login success");
                            break;
                        }         
                    
                    }               
if(!flag)
out.println("login failed");       
rs.close();
stmt.close();
con.close();      
                }       
catch(ClassNotFoundException | SQLException | IOException e)
                {
jTextArea1.append(String.valueOf(e));
                }
break;//end of case "login"

case "register":                
jTextArea1.append(String.valueOf(client));
                String s1=in.readLine();
                String s2=in.readLine();
                String s3=in.readLine();
                String s4=in.readLine();
                String s5=in.readLine();
                String s6=in.readLine();
                String s7=in.readLine();
                String s8=in.readLine();
                String s9=in.readLine();
                String s10=in.readLine();
                String s11=in.readLine();
          
try
                {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con= DriverManager.getConnection("jdbc:odbc:VC");
stmt=con.createStatement();        
                    stmt.executeUpdate("insert into `StudentLogin`(`SFName`,`SMName`,`SLName`,`FName`,`MName`,`Class`,`Roll`,`Scholar`,`Contact`,`Email`,`Password`) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"')");
                } 
catch (SQLException ex) 
                {
out.println("error");
jTextArea1.append(String.valueOf(ex));
break;
                }
out.println("complete");
break;  //end of case "register"

case "Initialise":
try
{
jTextArea1.append("\n"+String.valueOf(client));
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con= DriverManager.getConnection("jdbc:odbc:VC");
stmt=con.createStatement();                            

rs=stmt.executeQuery("select`TName`,`Subject` from `Test`");
System.out.println(0);
while(rs.next())          
{                
   out.println(rs.getString("Subject"));
   out.println(rs.getString("TName"));
}
out.println("Test done");
System.out.println(2);
rs=stmt.executeQuery("select`FName`,`Subject` from `File`");
while(rs.next())          
{                
   out.println(rs.getString("Subject"));
   out.println(rs.getString("FName"));
}
out.println("File done");
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
    
    
 case "TestCreate":                
jTextArea1.append("\n"+String.valueOf(client));
        int c = 0;
        String s12 = in.readLine();
        try
        {
            
            String s13 = "";

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con= DriverManager.getConnection("jdbc:odbc:VC");
            stmt=con.createStatement(); 
            while(!((s13 = in.readLine()).equals("Finish")))
            {          

            System.out.println(1);

                String s14=in.readLine();
                String s15=in.readLine();
                String s16=in.readLine();
                String s17=in.readLine();
                String s18=in.readLine();
                String s19=in.readLine();
                System.out.println(2);
                if(c==0)
                {
                    stmt.executeUpdate("insert into `Test`(`TName`,`Subject`) values('"+s13+"','"+s12+"')");
                    c++;
                }

            stmt.executeUpdate("insert into `"+s12+"`(`TName`,`Question`,`A`,`B`,`C`,`D`,`Answer`) values('"+s13+"','"+s14+"','"+s15+"','"+s16+"','"+s17+"','"+s18+"','"+s19+"')");
            System.out.println(3);
            out.println("success");
            }
            stmt.close();
            con.close();
         }
    catch (SQLException ex) 
    {
        out.println("error");
        jTextArea1.append(String.valueOf(ex));
        break;
    }       
    break; //end of case TestCreate

case "AttemptTest":
   int count = 0;
try
{
jTextArea1.append(String.valueOf(client));
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con= DriverManager.getConnection("jdbc:odbc:VC");
stmt=con.createStatement();     
    String s20 = in.readLine();
    String s21= in.readLine();
rs=stmt.executeQuery("select * from `"+s20+"`");
System.out.println("Question");
 
boolean flag=false;               
while(rs.next())          
{                
    System.out.println("Question");
   if(s21.equals(rs.getString("TName"))){
   out.println(rs.getString("Question"));
   out.println(rs.getString("A"));
   out.println(rs.getString("B"));
   out.println(rs.getString("C"));
   out.println(rs.getString("D"));
    System.out.println("Question");
   if(in.readLine().equals(rs.getString("Answer")))
   count++;
   }
   
}   
out.println("complete");
out.println(count);       
rs.close();
stmt.close();
con.close();      
}       
catch(ClassNotFoundException | SQLException | IOException e)
                {
jTextArea1.append(String.valueOf(e));
                }
break;
    //end of case "AttemptTest"
    
case "Discussion":
    String content="";
        int d;
    String st=in.readLine();
    String sub=in.readLine();
    FileReader fr = new FileReader(filepath+sub+".txt");       
    
        while((d = fr.read())!=-1)            
            content=content+(char)d;
        if(st.equals("student"))
            content=content+"Student : ";
        else if(st.equals("teacher"))
            content=content+"Teacher : ";        
    out.println(content);            
    fr.close();
break;
    
case "post":
            String sub2=in.readLine();
            String text2=in.readLine();
            
            try {
                    FileWriter fw = new FileWriter(filepath+sub2+".txt");   
                    fw.write(text2);         
                    fw.close();  
                    out.println("success");
                } catch (Exception ex) {
                    System.out.println(ex);
                    out.println("error");
                }  
            break;
 case "reset":
            String sub3=in.readLine();
            try {
                    FileWriter fw = new FileWriter(filepath+sub3+".txt");   
                    fw.write("");               
                    fw.close();  
                    out.println("success");
                } catch (Exception ex) {
                    System.out.println(ex);
                    out.println("error");
                }
            break;     
     
 case "FileDownload":
     BufferedInputStream bis;
     DataOutputStream dos;
     DataInputStream dis;
     try
     {
         System.out.println(0);
            jTextArea1.append("\n"+String.valueOf(client)+"\n");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con= DriverManager.getConnection("jdbc:odbc:VC");
            stmt=con.createStatement();     
            dis = new DataInputStream(client.getInputStream());
            String subject = dis.readLine();
            String file = dis.readLine();
            rs=stmt.executeQuery("select * from `File`");
            
            while(rs.next())
            {
                if(subject.equals(rs.getString("Subject"))&&file.equals(rs.getString("FName")))
                {
                     System.out.println(1);
                     DataInputStream f = new DataInputStream(new FileInputStream(rs.getString("Path")));
                     dos = new DataOutputStream(client.getOutputStream());
                     byte[] b = new byte[10000];
                     int s = f.available();
                     byte h = 0,i=0,k=0;
                     while(s!=0)
                     {
                         h=f.readByte();
                         k=i;
                         b[i++]=h;
                         System.out.print((char)b[k]);
                         s--;
                     }
                     dos.writeInt(i);
                     for(int u =0;u<i;u++)
                        dos.writeByte(b[u]);
                    dos.close();
                    f.close();
                }
            }
     }
     catch(Exception e)
     {
         System.out.println(e);
     } 
}
}
while(true);
}
catch(Exception e)
{}
}

}
