
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField tfUserName , tfName , tfPassword , tfAnswer; 
    Choice securityQ;
    
    Signup(){
        //instead of using setLocation and setSize we can directly use setBounds
        setBounds(350 , 200 , 900 , 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel userName = new JLabel("Username");
        userName.setFont(new Font("Tahoma" , Font.BOLD , 14));
        userName.setBounds(50,20,125,25);
        p1.add(userName);
        
        
        tfUserName = new JTextField();
        tfUserName.setBounds(190,20,180,25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);
        
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma" , Font.BOLD , 14));
        name.setBounds(50,60,125,25);
        p1.add(name);
        
        
        tfName = new JTextField();
        tfName.setBounds(190,60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Tahoma" , Font.BOLD , 14));
        password.setBounds(50,100,125,25);
        p1.add(password);
        
        
        tfPassword = new JTextField();
        tfPassword.setBounds(190,100,180,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);
        
        
        JLabel security = new JLabel("Security Question");
        security.setFont(new Font("Tahoma" , Font.BOLD , 14));
        security.setBounds(50,140,125,25);
        p1.add(security);
        
        
        //creating drop down for security questions
        
        securityQ = new Choice();
        securityQ.add("Your high school name");
        securityQ.add("Your favourite game");
        securityQ.add("Your favourite hero");
        securityQ.setBounds(190,140,180,25);
        p1.add(securityQ);
        
        
        
        JLabel answer = new JLabel("Answer");
        answer.setFont(new Font("Tahoma" , Font.BOLD , 14));
        answer.setBounds(50,180,125,25);
        p1.add(answer);
        
        tfAnswer = new JTextField();
        tfAnswer.setBounds(190,180,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);
        
        //creating buttons
        
        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80 , 250,100,30);
        //we want an eventafter clicking the button
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250 , 250,100,30);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        //adding image on panel
        add(image);
        
        
        
        setVisible(true);
    }
    //ActionEvent tell us source of the action
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            //retrieving values from the teaxfields
            String username = tfUserName.getText();
            String name = tfName.getText();
            String password = tfPassword.getText();
            String question = securityQ.getSelectedItem();
            String answer = tfAnswer.getText();
            
            String query = "insert into account values('"+username+"' , '"+name+"','"+password+"','"+question+"', '"+answer+"')";
            try{
                //establishing connection
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                //showing popup if the query is successful
                JOptionPane.showMessageDialog(null , "AccountCreated Successfully");
                
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
         setVisible(false);
         new Login();
        }
    }
    
    
    public static void main(String[] args){
        new Signup();
    }
}
