
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails , deletePersonalDetails,viewBookedHotel,viewPersonalDetails,exit,calculator , bookHotel,updatePersonalDetails , checkPackages , about,bookPackage ,viewPackage , viewHotels , destination , payment;
    
    Dashboard(String username){
        
        this.username = username;
        
        //setBounds(0 ,0 , 1600 , 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);//to create oyr own layout
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0 , 0 , 1600 , 65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5 , 0 , 70 , 70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80 , 10 , 300 , 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 30));
        p1.add(heading);
        
        
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0 , 65 , 300 , 900);
        add(p2);
        
        
        addPersonalDetails= new JButton("Add Personal Details"); 
        addPersonalDetails.setBounds(0 , 0 , 300 , 50);
        addPersonalDetails.setBackground(new Color(0 , 0 , 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        addPersonalDetails.setMargin(new Insets(0 ,0, 0 , 60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        
        updatePersonalDetails= new JButton("Update Personal Details"); 
        updatePersonalDetails.setBounds(0 , 50 , 300 , 50);
        updatePersonalDetails.setBackground(new Color(0 , 0 , 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        updatePersonalDetails.setMargin(new Insets(0 ,0, 0 , 30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        
        viewPersonalDetails= new JButton("View  Details"); 
        viewPersonalDetails.setBounds(0 , 100 , 300 , 50);
        viewPersonalDetails.setBackground(new Color(0 , 0 , 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        viewPersonalDetails.setMargin(new Insets(0 ,0, 0 , 130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        
        
        deletePersonalDetails= new JButton("Delete Personal Details"); 
        deletePersonalDetails.setBounds(0 , 150 , 300 , 50);
        deletePersonalDetails.setBackground(new Color(0 , 0 , 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        deletePersonalDetails.setMargin(new Insets(0 ,0, 0 , 40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        
        checkPackages= new JButton("Check Packages"); 
        checkPackages.setBounds(0 , 200 , 300 , 50);
        checkPackages.setBackground(new Color(0 , 0 , 102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        checkPackages.setMargin(new Insets(0 ,0, 0 , 110));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);
        
        
        
        
        bookPackage= new JButton("Book Package"); 
        bookPackage.setBounds(0 , 250 , 300 , 50);
        bookPackage.setBackground(new Color(0 , 0 , 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        bookPackage.setMargin(new Insets(0 ,0, 0 , 120));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);
        
        
        viewPackage= new JButton("View Package"); 
        viewPackage.setBounds(0 , 300 , 300 , 50);
        viewPackage.setBackground(new Color(0 , 0 , 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        viewPackage.setMargin(new Insets(0 ,0, 0 , 120));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        
        viewHotels= new JButton("View Hotels"); 
        viewHotels.setBounds(0 , 350 , 300 , 50);
        viewHotels.setBackground(new Color(0 , 0 , 102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        viewHotels.setMargin(new Insets(0 ,0, 0 , 130));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);
        
        
        bookHotel = new JButton("Book Hotel"); 
        bookHotel.setBounds(0 , 400 , 300 , 50);
        bookHotel.setBackground(new Color(0 , 0 , 102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        bookHotel.setMargin(new Insets(0 ,0, 0 , 140));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);
        
        
        viewBookedHotel = new JButton("View Booked Hotel"); 
        viewBookedHotel.setBounds(0 , 450 , 300 , 50);
        viewBookedHotel.setBackground(new Color(0 , 0 , 102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        viewBookedHotel.setMargin(new Insets(0 ,0, 0 , 70));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        
        destination = new JButton("Destinations"); 
        destination.setBounds(0 , 500 , 300 , 50);
        destination.setBackground(new Color(0 , 0 , 102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        destination.setMargin(new Insets(0 ,0, 0 , 125));
        destination.addActionListener(this);
        p2.add(destination);
        
        
        payment = new JButton("Payments"); 
        payment.setBounds(0 , 550 , 300 , 50);
        payment.setBackground(new Color(0 , 0 , 102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        payment.setMargin(new Insets(0 ,0, 0 , 155));
        payment.addActionListener(this);
        p2.add(payment);
        
        calculator = new JButton("Calculator"); 
        calculator.setBounds(0 , 600 , 300 , 50);
        calculator.setBackground(new Color(0 , 0 , 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        calculator.setMargin(new Insets(0 ,0, 0 , 145));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        
        about = new JButton("About"); 
        about.setBounds(0 , 650 ,300 , 50);
        about.setBackground(new Color(0 , 0 , 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        about.setMargin(new Insets(0 ,0, 0 , 155));
        about.addActionListener(this);
        p2.add(about);
        
        
        exit = new JButton("Exit"); 
        exit.setBounds(1350 , 730 , 150 , 50);
        exit.setBackground(new Color(0 , 0 , 102));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Tahoma" , Font.PLAIN,20));
        //to align it left side
        exit.setMargin(new Insets(10,10,10,10));
        exit.addActionListener(this);
        
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400 , 70 , 1200 , 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway" , Font.PLAIN ,55 ));
        image.add(text);
        image.add(exit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource() == updatePersonalDetails){
            new UpdateDetails(username);
        }else if(ae.getSource() == checkPackages){
            new CheckPackages();
        }else if(ae.getSource() == bookPackage){
            new BookPackage(username);
        }else if(ae.getSource() == viewPackage){
            new ViewPackage(username);
        }else if(ae.getSource() == viewHotels){
            new CheckHotels();
        }else if(ae.getSource() == destination){
            new Destinations();
        }else if(ae.getSource() == bookHotel){
            new BookHotel(username);
        }else if(ae.getSource() == viewBookedHotel){
            new ViewBookedHotel(username);
        }else if(ae.getSource() == payment){
            new Payment();
        }else if(ae.getSource() == calculator){
            try{
                //picks executable at run time
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == about){
            new About();
        }else if(ae.getSource() == deletePersonalDetails){
            new DeletePersonalDetails(username);
        }else if(ae.getSource() == exit){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Dashboard("");
    }
}