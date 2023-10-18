
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateDetails extends JFrame implements ActionListener{
    
    JLabel username , labelusername , labelName;
    JComboBox comboId;
    JTextField tfNumber , tfCountry , tfAddress , tfEmail , tfphone , tfid , tfgender;
    JRadioButton male , female;
    JButton add , back;
    
    
    UpdateDetails(String UserName){
        setBounds(500 , 200 , 850 , 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50 , 15, 300 , 25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
            
        
        username = new JLabel("Username");
        username.setBounds(30 , 50 , 150 , 25);
        
        add(username);
        
        
        
        labelusername = new JLabel();
        labelusername.setBounds(220 , 50 , 150 , 25);
        getContentPane().setBackground(Color.WHITE);
        add(labelusername);
        
        JLabel id = new JLabel("Id");
        id.setBounds(30 , 90 , 150 , 25);
        add(id);
        
        //drop down for Id
        tfid = new JTextField();
        tfid.setBounds(220 , 90 , 150 , 25);
        add(tfid);
        
        
        JLabel number = new JLabel("Number");
        number.setBounds(30 , 130 , 150 , 25);
        add(number);
        
        tfNumber = new JTextField();
        tfNumber.setBounds(220 , 130 , 150 , 25);
        add(tfNumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30 , 170 , 150 , 25);
        add(name);
        
        labelName = new JLabel();
        labelName.setBounds(220 , 170 , 150 , 25);
        add(labelName);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30 , 210 , 150 , 25);
        add(gender);
        
        
       
        
        tfgender = new JTextField();
        tfgender.setBounds(220 , 210 , 150 , 25);
        add(tfgender);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel country = new JLabel("Country");
        country.setBounds(30 , 250 , 150 , 25);
        add(country);
        
        tfCountry = new JTextField();
        tfCountry.setBounds(220 , 250 , 150 , 25);
        add(tfCountry);
        
        JLabel address = new JLabel("Address");
        address.setBounds(30 , 290 , 150 , 25);
        add(address);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(220 , 290 , 150 , 25);
        add(tfAddress);
        
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(30 , 330 , 150 , 25);
        add(phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220 , 330 , 150 , 25);
        add(tfphone);
        
        
        
        JLabel email = new JLabel("Email");
        email.setBounds(30 , 370 , 150 , 25);
        add(email);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(220 , 370 , 150 , 25);
        add(tfEmail);
        
        
        
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70 , 430 , 100 , 25);
        add.addActionListener(this);
        add(add);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220 , 430 , 100 , 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400 , 100 , 450 , 300);
        add(image);
        
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='"+UserName+"'");
            while(rs.next()){
                
                labelusername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfNumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfCountry.setText(rs.getString("country"));
                tfAddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
                
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
       setVisible(true); 
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = labelusername.getText();
            //returns object so we are type casting into string
            String id = tfid.getText();
            String number = tfNumber.getText();
            String name = labelName.getText();
            String gender = tfgender.getText();
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String phone = tfphone.getText();
            String email = tfEmail.getText();
          
            
            
            try{
                Conn c = new Conn();
                String query = "update  customer set username= '"+username+"', id= '"+id+"',number= '"+number+"', name='"+name+"', gender='"+gender+"',country= '"+country+"',address= '"+address+"',phone= '"+phone+"',email= '"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer details updated succeccfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }else {
            setVisible(false);
        }
    }
    
public static void main(String[] args){
 new UpdateDetails("sharukh");   
}


    
}
