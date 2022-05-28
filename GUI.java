package homework1;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JTextField;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


import static javax.swing.JOptionPane.showMessageDialog;

public class GUI extends JFrame implements ActionListener {

    //password Text field
    static JTextField passwordText;

    //Username text feild
    static JTextField usernameText;

    static JButton enterButton = new JButton("Enter");

    //Creates date object
    static LocalDate loginDate = LocalDate.now();

    //creates time object
    static LocalTime loginTime = LocalTime.now();

    //file handler variable
    FileHandler fHandler;

    //creates a logger so we can create a log file using java lib
    static Logger logger = Logger.getLogger("My Homework 1 Log");


    public GUI() throws IOException {

        //new file handler object to create a file log to save username, date, and time to, appending it means it adds to the file
        fHandler = new FileHandler("/Users/autumn/IdeaProjects/HelloWorld/src/homework1/log.txt", true);
        logger.addHandler(fHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fHandler.setFormatter(formatter);
        logger.info("logger is working");



        //Frame or window creation  amd title of window
        JFrame f = new JFrame("Testing class Homework 1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creates the GUI text feilds so user can enter user and password
        passwordText = new JTextField(10);
        usernameText = new JTextField(10);


        //username text field and label
        JPanel inFieldPane = new JPanel();
        inFieldPane.setLayout(new GridLayout(2, 2));
        //username field,label and actionlistener
        inFieldPane.add(new JLabel("Username: "));
        inFieldPane.add(usernameText);
        //usernameText.addActionListener(this);
        f.add(inFieldPane, BorderLayout.NORTH);
        //password field label and actionlistener
        inFieldPane.add(new JLabel("Password: "));
        inFieldPane.add(passwordText);
        //passwordText.addActionListener(this);
        f.add(inFieldPane, BorderLayout.NORTH);




        //EnterButton and action listener
        JPanel enterPane = new JPanel();
        enterPane.setLayout(new FlowLayout());
        enterPane.add(new JLabel("Press Enter to Login"));
        enterPane.add(enterButton);
        enterButton.addActionListener((ActionListener) this);
        f.add(enterPane, BorderLayout.CENTER);
        // f.add(usernameText);
        //f.add(passwordText);
        //f.add(enterButton);


        //Sets frame
        f.setSize(500, 500);
        f.pack();
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        //call GUI class starts GUI
        new GUI();

        //System.out.print(loginDate);
    }

//this class give the enter button function, I also included the logger methods here to record data
    @Override
    public void actionPerformed (ActionEvent e)
    {
        //gives enter button function
        if (e.getSource() == enterButton)
        {
            String userText =  usernameText.getText();

            //This is where we use the logger methods to record the username, time, date and if it was sucessful
            logger.info("Username:" +userText);
            logger.info(String.valueOf("Login Date:" +loginDate));
            logger.info(String.valueOf("Login time:"+  loginTime));
            String pwdText = passwordText.getText();
            if (userText.trim().equals("user") && pwdText.trim().equals("secret")) {
                JOptionPane.showMessageDialog(this, "Login was Successful");
                logger.info("login was successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                logger.info("Username or password was invalid");
            }
        }

    }


}