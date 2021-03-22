package universitymanagement;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class InputMarks extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b1;

    InputMarks(){

        setSize(500,550);
        setLocation(400,200);
        setLayout(null);

        l1 = new JLabel("Enter subjects and marks of Student");
        l1.setFont(new Font("serif", Font.BOLD, 20));
        l1.setBounds(80,0,500,80);
        add(l1);

        l2 = new JLabel("Enter Roll Number");
        l2.setBounds(50,70,200,40);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(180,80,200,20);
        add(t1);

        l3 = new JLabel("Subject");
        l3.setBounds(130,150,200,40);
        add(l3);

        l4 = new JLabel("Marks");
        l4.setBounds(330,150,200,40);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(50,200,200,20);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(250,200,200,20);
        add(t3);

        t4 = new JTextField();
        t4.setBounds(50,230,200,20);
        add(t4);

        t5 = new JTextField();
        t5.setBounds(250,230,200,20);
        add(t5);

        t6 = new JTextField();
        t6.setBounds(50,260,200,20);
        add(t6);

        t7 = new JTextField();
        t7.setBounds(250,260,200,20);
        add(t7);

        t8 = new JTextField();
        t8.setBounds(50,290,200,20);
        add(t8);

        t9 = new JTextField();
        t9.setBounds(250,290,200,20);
        add(t9);

        t10 = new JTextField();
        t10.setBounds(50,320,200,20);
        add(t10);

        t11 = new JTextField();
        t11.setBounds(250,320,200,20);
        add(t11);

        b1 = new JButton("Submit");
        b1.setBounds(50,360,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b1.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == b1){
            	if(t1.getText().equals("") ||
            			t2.getText().equals("") ||
            			t4.getText().equals("") ||
            			t6.getText().equals("") ||
            			t8.getText().equals("") ||
            			t10.getText().equals("") ||
            			t3.getText().equals("") ||
            			t5.getText().equals("") ||
            			t7.getText().equals("") ||
            			t9.getText().equals("") ||
            			t11.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog(null,"Enter all the fields");
            	}
            
            else {
                Connec c1 = new Connec();

                String s1 = "insert into subject values('"+t1.getText()+"','"+t2.getText()+"','"+t4.getText()+"','"+t6.getText()+"','"+t8.getText()+"','"+t10.getText()+"')";
                String s2 = "insert into marks values('"+t1.getText()+"','"+t3.getText()+"','"+t5.getText()+"','"+t7.getText()+"','"+t9.getText()+"','"+t11.getText()+"')";

                c1.s.executeUpdate(s1);
                c1.s.executeUpdate(s2);
                
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                this.setVisible(false);
            }
            }
        
        }catch(Exception e){}
    }

    public static void main(String[] args){
        new InputMarks().setVisible(true);
    }
}
