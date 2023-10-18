
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    
    JTextField tfUserName , tfName , tfQuestion , tfAnswer , tfPassword;
    JButton search , retrieve , back;
  
    ForgetPassword(){
        setBounds(350 , 200 , 850 , 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,  200 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580 , 70 , 200 ,200);
        add(image);
        
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);//(to avoid default border)
        p1.setBounds(30 , 30 , 500 , 280);
        add(p1);
        
        
        JLabel userName = new JLabel("Username");
        userName.setBounds(40 , 20 ,100 , 25);
        userName.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(userName);
        
        
        tfUserName = new JTextField();
        tfUserName.setBounds(220 , 20 , 150 ,25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);
        
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380 , 20 , 100 , 25);
        search.addActionListener(this);
        p1.add(search);
        
        
        JLabel Name = new JLabel("Name");
        Name.setBounds(40 , 60 ,150 , 25);
        Name.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(Name);
        
        
        tfName = new JTextField();
        tfName.setBounds(220 , 60 , 150 ,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
    
        
        JLabel question = new JLabel("Security Question");
        question.setBounds(40 , 100 ,150 , 25);
        question.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(question);
        
        
        tfQuestion = new JTextField();
        tfQuestion.setBounds(220 , 100 , 150 ,25);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion);
        
        
        
        JLabel answer = new JLabel("Answer");
        answer.setBounds(40 , 140 ,150 , 25);
        answer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(answer);
        
        
        tfAnswer = new JTextField();
        tfAnswer.setBounds(220 , 140 , 150 ,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);
        
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380 , 140 , 100 , 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        
        
        JLabel password = new JLabel("Password");
        password.setBounds(40 , 180 ,150 , 25);
        password.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(password);
        
        
        tfPassword = new JTextField();
        tfPassword.setBounds(220 , 180 , 150 ,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);
        
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150 , 230 , 100 , 25);
        back.addActionListener(this);
        p1.add(back);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfUserName.getText()+"'";
                //Creatinf conn object to execute query
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfName.setText(rs.getString("name"));
                    tfQuestion.setText(rs.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == retrieve){
            
            try{
            String query = "select * from account where answer = '"+tfAnswer.getText()+"' AND username = '"+tfUserName.getText()+"'";
            Conn c = new Conn();
             ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                    tfPassword.setText(rs.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            } 
            
        }else{
            setVisible(false);
            new Login();
        }
    }
    
    
    
    public static void main(String[] args){
        new ForgetPassword();
    }
}
