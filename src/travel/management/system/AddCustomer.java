
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername , labelname ;
    JComboBox comboId;
    JTextField tfNumber ,tfusername , tfname, tfCountry , tfAddress , tfEmail , tfphone;
    JRadioButton male , female;
    JButton add , back;
    String UserName;
    
    AddCustomer(String UserName){
        this.UserName = UserName;
        setBounds(450 , 200 , 850 , 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
            
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30 , 50 , 150 , 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220 ,50 , 150 , 25 );
        add(labelusername);
        
        JLabel id = new JLabel("Id");
        id.setBounds(30 , 90 , 150 , 25);
        add(id);
        
        //drop down for Id
        comboId = new JComboBox(new String[]{"Passport","Pan Card" , "Aadhar Card" });
        comboId.setBounds(220 , 90 , 150 , 25);
        comboId.setBackground(Color.WHITE);
        add(comboId);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30 , 130 , 150 , 25);
        add(lblnumber);
        
        tfNumber = new JTextField();
        tfNumber.setBounds(220 , 130 , 150 , 25);
        add(tfNumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30 , 170 , 150 , 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220 , 170 , 150 , 25);
        add(labelname);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30 , 210 , 150 , 25);
        add(gender);
        
        
       
        
        male = new JRadioButton("Male");
        male.setBounds(220 , 210 , 70 , 25);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(300 , 210 , 70 , 25);
        female.setBackground(Color.WHITE);
        add(female);
        
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
        
        
        
        add = new JButton("Add");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400 , 40 , 450 , 420);
        add(image);
        
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username='"+UserName+"'");
            while(rs.next()){
                
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
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
            String id = (String)comboId.getSelectedItem();
            String number = tfNumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String phone = tfphone.getText();
            String email = tfEmail.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer details added succeccfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }else {
            setVisible(false);
        }
    }
    
public static void main(String[] args){
 new AddCustomer("");   
}


    
}
