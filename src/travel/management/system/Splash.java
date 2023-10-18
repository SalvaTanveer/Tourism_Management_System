
package travel.management.system;

import java.awt.*;
import javax.swing.*;


public class Splash extends JFrame implements Runnable {
    Thread thread;
   
    Splash() {
        
//       //setting frame size 
//        setSize(1200 , 600);
//        
//        
//        //frame will be displayed at a distance of 200 from left and 100 from top
//        setLocation(200 , 100);
        
        //creating object of ImgaeIcon for accessing images
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        //scaling image(setting size)
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //for placing image on frame we need to place it in label
        JLabel image = new JLabel(i3);
        //adding image on frame
        add(image);
        //making frame visible on the screen
        setVisible(true);
        
        thread = new Thread(this);
        thread.start();
    }
    
    //overriding run method of runnable interface
    public void run(){
        try{
            //taking a pause of 7 sec and closing the frame after 7 seconds
            Thread.sleep(4000);//7 sec = 7000 ms 
            new Login();
           setVisible(false);
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        Splash frame = new Splash();
        
        int x = 1;
        for(int i = 1 ; i <= 500; x+=7 , i+=6){
            frame.setLocation(750 - (x+i)/2 , 400 - i/2 );
            frame.setSize(x+i , i);
            //image will open at a pause of 10 milli seconds
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }

        
    }

    
   
}
