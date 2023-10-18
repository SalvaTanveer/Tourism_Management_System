
package travel.management.system;
import javax.swing.*;
import java.awt.*;


public class Destinations extends JFrame implements Runnable{
    Thread thread;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    JLabel[] label = new JLabel[]{label1,label2,label3,label4,label5,label6,label7,label8,label9,label10};
    
   
    public void run(){
        String[] text = new String[]{"JW Marriott Hotel","Mandarin Oriental Hotel","Four Seasons Hotel","Radisson Hotel","Classio Hotel","The Bay Club Hotel","Breeze Blows Hotel","Quick Stop Hotel","Happy Mornings Hotel","River View Hotel"};
        try{
            for(int i = 0 ; i < 9 ; i++){
                label[i].setVisible(true);
               
                Thread.sleep(1000);
                label[i].setVisible(false);
            }
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    Destinations(){
        
        
        
        setBounds(500 , 200 , 800 , 600);
        setLayout(null);
        
        
        
        
        
        
        
        
        
        
        
        ImageIcon i1= null , i2= null  , i3= null  , i4= null  , i5= null  , i6= null  , i7 = null , i8= null  , i9 = null , i10= null;
        ImageIcon[] image1 = new ImageIcon[]{i1 , i2 , i3 , i4 , i5 , i6 , i7 , i8 , i9 , i10};
        
        
        Image j1 = null , j2 = null, j3 = null, j4 = null , j5 = null, j6 = null, j7 = null, j8 = null, j9 = null, j10= null;
        Image[] image2 = new Image[]{j1 , j2 , j3 , j4 , j5 , j6 , j7 , j8 , j9 , j10};
        
        
        
        ImageIcon k1= null,k2= null,k3= null,k4= null,k5= null,k6= null,k7= null,k8= null,k9= null,k10= null;
        ImageIcon[] image3 = new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};
        
        for(int i = 0 ; i < 9 ; i++){
        
         image1[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
        image2 [i] = image1[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        image3[i] = new ImageIcon(image2[i]);
        label[i] = new JLabel(image3[i]);
        label[i].setBounds(0,0,800,600);
        add(label[i]);
    }
        
     thread = new Thread(this);
     thread.start();
        
        
        setVisible(true);
        
    }
    
  
    
    public static void main(String[] args){
        new Destinations();
    }
}
