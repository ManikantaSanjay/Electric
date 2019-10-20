import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Ccad extends JFrame //implements ActionListener
 { 
	JLabel conno,areacode,daycode,mtrcode,cdavailable,cdrefund,dmd;
	JComboBox con_no,area_code,day_code,mtr_code,prd;
	JTextField cd_available,cd_refund,demand,rbt,amt,m_rent,tot;
	JTextArea note;
	JButton ok,edit,cancel;
	String p[]={"6months","12months"};
	
	public Ccad (String title)
  	{


		super("ADVANCE PAYMENT");
		setLayout(null);
		conno=new JLabel("Consumer Number");
		con_no=new JComboBox();
		con_no.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		String area[] = {"A01","A02","A03","A04","A05","B01","B02","B03","B04","B05"};
		area_code=new JComboBox(area);
		daycode=new JLabel("Day code");
		day_code=new JComboBox();
		mtrcode=new JLabel("Meter Reader Code");
		String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code=new JComboBox(mtrcd);
		cdavailable=new JLabel("CD amount available");
		cd_available=new JTextField();
		dmd=new JLabel("Demand to be adjusted");
		demand=new JTextField(10); //read from the database
		cdrefund=new JLabel("CD refundable");
		cd_refund=new JTextField(10);
		
		ok=new JButton("OK");
		cancel=new JButton("Cancel");
		edit=new JButton("Edit");
		
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p5;
		p1=new JPanel();
		p1.setLayout(new GridLayout(3,2,0,0));
		p1.add(areacode);
		p1.add(area_code);
		p1. add(mtrcode);
		p1.add(mtr_code);
		p1. add(conno);
	    p1.add(con_no);		
		p1.setBounds(80,100,250,60);
		add(p1);
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(5,2,0,5));
		JLabel period=new JLabel("Period");
		prd=new JComboBox(p);
		p3.add(period);     
		p3.add(prd);
		
		JLabel amount=new JLabel("Expected C C");
		amt=new JTextField(10);
		p3.add(amount);     
		p3.add(amt);
		
		
		JLabel mrent=new JLabel("Expected M R");
		m_rent=new JTextField(10);
		p3.add(mrent);     
		p3.add(m_rent);
		
		
		JLabel rebate=new JLabel("Rebate");
		rbt=new JTextField();
		p3.add(rebate);        
		p3.add(rbt);
		
		JLabel total=new JLabel("TOTAL");
		tot=new JTextField();
		p3.add(total);        
		p3.add(tot);
		
		
		p3.setBounds(50,180,280,120);
		add(p3);
		      
		
		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
		
	
		
		p4.setBounds(100,400,200,30);
		add(p4);
		
		
		JLabel advpay=new JLabel("Make advance payment");
		p5=new JPanel();
			p5.setLayout(new GridLayout(1,2,10,0));

		p5.add(advpay);
		p5.add(ok);
		
		p5.setBounds(50,340,290,30);
		add(p5);
		
		
			JLabel cd=new JLabel("ADVANCE PAYMENT");
			
		cd.setFont(new Font("Times New Roman",Font.BOLD,20));
		cd.setForeground(new Color(50,150,20));
		
		JPanel p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(20,15,350,30);
     			p6.add(cd);
     			
     		     add(p6);
		
		
		
	}
		public static void main(String arg[])
		{
			Ccad Ccad = new Ccad("ADVANCE PAYMENT");
			Ccad.setSize(400,550);
			Ccad.setVisible(true);
	}

}
