
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(600 , 200 , 500 , 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel label = new JLabel("ABOUT");
        label.setBounds(200 , 30 , 100 , 40);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Tahoma" , Font.BOLD,20));
        add(label);
        
        
        String s = "                                      ABOUT PROJECT          \n  "
                +"\n"
                
                + "\nThe objective of the Travel and Tourism Management System"
                + " project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                
                ;
        
        TextArea area = new TextArea(s,8 , 40 , Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20 , 120 , 450 , 250);
        area.setBackground(Color.WHITE);
        area.setFont(new Font("Tahoma" , Font.PLAIN , 12));
        add(area);
        
        
        back = new JButton("Back");
        back.setBounds(200 , 420 , 100 , 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
        new About();
    }
    
    
}
