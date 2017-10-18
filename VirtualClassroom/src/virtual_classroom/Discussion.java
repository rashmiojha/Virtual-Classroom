/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual_classroom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class Discussion extends javax.swing.JFrame {  
    Socket client;
     BufferedReader in;
     PrintWriter out;
        
        String subject;
    public Discussion(String s1, String s2) throws FileNotFoundException, IOException {   //s1->student/teacher s2->subject
        initComponents();
        subject=s2;
        client=new Socket("localhost",2014);
            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            out=new PrintWriter(client.getOutputStream(),true);
            out.println("Discussion");
            out.println(s1);
            out.println(s2);
            jTextPane2.setText(in.readLine());
        if(s1.equals("teacher"))
            jButton2.setEnabled(true);
        else
            jButton2.setEnabled(false);        
    }
//    Socket client;
//     BufferedReader in;
//     PrintWriter out;
//        //String path="F:/Steganography/"; 
//        String subject;
//    public Discussion(String s1, String s2) throws FileNotFoundException, IOException {   //s1->student/teacher s2->subject
//        initComponents();
//        subject=s2;
////        String content="";
////        int c;
//        Socket client;
//        BufferedReader in;
//        PrintWriter out;
//        client=new Socket("localhost",2014);
//            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
//            out=new PrintWriter(client.getOutputStream(),true);
//            out.println("Discussion");
//            out.println(s1);
//            out.println(s2);
//            String str="";
//                        //int size=Integer.parseInt(in.readLine());
////           int d=in.read();
////            while(d!=-1)
////            {
////                str=str+(char)d;
////                d=in.read();
////            }
////            
////    
////            jTextPane2.setText(str);
//            
//            
//            jTextPane2.setText(in.readLine());
////        switch(s2)
////        {
////            case "Computer":
////        FileReader fr = new FileReader(path+s2+".txt");   //Computer            
////        while((c = fr.read())!=-1)
////            content=content+(char)c;
////        if(s1.equals("student"))
////            content=content+"\n\nStudent : ";
////        else
////            content=content+"\n\nTeacher : ";
////        jTextPane2.setText(content);
////        content="";        
////        fr.close();  
////        break;
////        
////            case "English":
////        fr = new FileReader(path+s2+".txt");   //English
////        while((c = fr.read())!=-1)
////            content=content+(char)c;
////        if(s1.equals("student"))
////            content=content+"\n\nStudent : ";
////        else
////            content=content+"\n\nTeacher : ";
////        jTextPane2.setText(content);
////        content="";        
////        fr.close();
////        break;
////        
////            case "Science":
////        fr = new FileReader(path+s2+".txt");  //Science
////        while((c = fr.read())!=-1)
////            content=content+(char)c;
////        if(s1.equals("student"))
////            content=content+"\n\nStudent : ";
////        else
////            content=content+"\n\nTeacher : ";
////        jTextPane2.setText(content);
////        content="";        
////        fr.close();
////        break;
////        
////        case "Maths":
////        fr = new FileReader(path+s2+".txt");    //Maths
////        while((c = fr.read())!=-1)
////            content=content+(char)c;
////        if(s1.equals("student"))
////            content=content+"\n\nStudent : ";
////        else
////            content=content+"\n\nTeacher : ";
////        jTextPane2.setText(content);
////        content="";        
////        fr.close();
////        break;
////    
////        case "SocialScience":
////        fr = new FileReader(path+s2+".txt");    //Social Science
////        while((c = fr.read())!=-1)
////            content=content+(char)c;
////        if(s1.equals("student"))
////            content=content+"\n\nStudent : ";
////        else
////            content=content+"\n\nTeacher : ";
////        jTextPane2.setText(content);
////        content="";        
////        fr.close();
////            break;
////        }
//        if(s1.equals("teacher"))
//            jButton2.setEnabled(true);
//        else
//            jButton2.setEnabled(false);        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Discussion Board");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1083, 501));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTextPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 102, 0)));
        jTextPane2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jTextPane2.setCaretColor(new java.awt.Color(204, 204, 255));
        jTextPane2.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextPane2.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jTextPane2.setSelectionColor(new java.awt.Color(255, 153, 0));
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jButton1.setText("Post");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
            client=new Socket("localhost",2014);
                in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                out=new PrintWriter(client.getOutputStream(),true);
            out.println("post");
            out.println(subject);
            out.println(jTextPane2.getText());
            String s=in.readLine();
            if(s.equals("success"))
                JOptionPane.showMessageDialog(this,"Your data has been posted.","Success",JOptionPane.INFORMATION_MESSAGE);
            else if(s.equals("error"))
                JOptionPane.showMessageDialog(this,"Data post unsuccessful","Error",JOptionPane.ERROR_MESSAGE);           
        } catch (UnknownHostException ex) {
            Logger.getLogger(Discussion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Discussion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            jTextPane2.setText("");
            client=new Socket("localhost",2014);
                in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                out=new PrintWriter(client.getOutputStream(),true);
            
            out.println("reset");
            out.println(subject);
            String s2=in.readLine();
            if(s2.equals("success"))
                JOptionPane.showMessageDialog(this,"Data reset successful for Discussion Board","Success",JOptionPane.INFORMATION_MESSAGE);
            else if(s2.equals("error"))
                JOptionPane.showMessageDialog(this,"Data reset unsuccessful","Error",JOptionPane.ERROR_MESSAGE);
            } catch (UnknownHostException ex) {
            Logger.getLogger(Discussion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Discussion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Home h=new Home();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

       /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Discussion("teacher","Computer").setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Discussion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
}
