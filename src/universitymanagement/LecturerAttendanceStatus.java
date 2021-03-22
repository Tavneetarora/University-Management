package universitymanagement;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LecturerAttendanceStatus  extends JFrame implements ActionListener{
	JTable j1;
    JButton b1;
    String h[]={"EMPLOYEE ID","DATE and TIME","FIRST HALF ATTENDANCE","SECOND HALF ATTENDANCE"};
    String d[][]=new String[15][4];  
    int i=0,j=0;
    
    LecturerAttendanceStatus(){
        super("Show Lecturer Attendance");
        setSize(800,300);
        setLocation(450,150);

        try{
            String q="select * from lecturer_attendance";
            Connec c1=new Connec();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("employee_id");
                d[i][j++]=rs.getString("Date");
                d[i][j++]=rs.getString("first_half");
                d[i][j++]=rs.getString("second_half");
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);

        }catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new LecturerAttendanceStatus().setVisible(true);
    }
}
