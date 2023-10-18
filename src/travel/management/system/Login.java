
package travel.management.system;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*; 

public class Login extends JFrame implements ActionListener{
    JButton login , signup , forget;
    
    JTextField tfUserName , tfpassword;
    
    Login(){
        setSize(900 , 400);
        setLocation(350 , 200);
        setLayout(null);//not using swing layout we are creating our custom layout
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));//creating color object to use rgb values
        //creating custom layout
        p1.setBounds(0 , 0,400,400);
        p1.setLayout(null);//to use setBounds functions we are making layout null
        add(p1);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        //adding image on panel
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400 , 30 ,450,300);
        add(p2);
        
        
        JLabel userName = new JLabel("Username");
        userName.setBounds(60,20,100,25);
        userName.setFont(new Font("SAN SERIE",Font.PLAIN, 20));
        p2.add(userName);
        
        tfUserName = new JTextField();
        tfUserName.setBounds(60 ,60, 300 ,30);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUserName);
        
        JLabel password = new JLabel("Password");
        password.setBounds(60,110,100,25);
        password.setFont(new Font("SAN SERIE",Font.PLAIN, 20));
        p2.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60 ,150, 300 ,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        //creating buttons
        
        login = new JButton("Login");
        login.setBounds(60 , 200 , 130 , 30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);
        
        
        signup = new JButton("Signup");
        signup.setBounds(230 , 200 , 130 , 30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        
        
        forget = new JButton("Forget Password");
        forget.setBounds(130 , 250 , 130 , 30);
        forget.setBackground(new Color(133,193,233));
        forget.setForeground(Color.WHITE);
        forget.setBorder(new LineBorder(new Color(133,193,233)));
        forget.addActionListener(this);
        p2.add(forget);
        
        
        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(280,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
          if(ae.getSource() == login){
              
              try{
                  String username = tfUserName.getText();
                  String password = tfpassword.getText();
                  
                  
                  String query = "select * from account where username ='"+username+"'AND password = '"+password+"'";
                  Conn c = new Conn();
                  ResultSet rs = c.s.executeQuery(query);
                  //we are retrieving only one row so we are using if rather than while
                  if(rs.next()){
                      setVisible(false);
                      new Loading(username);
                  }else{
                      JOptionPane.showMessageDialog(null,"Incorrect username or password");
                  }
                  
                  
              }catch(Exception e){
                  e.printStackTrace();
              }
              
          }  else if(ae.getSource() == signup){
              setVisible(false);
              new Signup();
          }else{
              setVisible(false);
              new ForgetPassword();
          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
