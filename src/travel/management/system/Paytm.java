
package travel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
 
    JButton back;
    
    Paytm(){
        
        setBounds(500 , 200 , 800  , 600);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try{
           pane.setPage("https://paytm.com/rent-payment");
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load , Error 404</html>");
        }
        //I have to add scroll pane on (pane => editor pane) , so I am passing pane as argument
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        back = new JButton("Back");
        back.setBounds(610 , 20 , 80 ,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
        new Paytm();
    }
    
}
