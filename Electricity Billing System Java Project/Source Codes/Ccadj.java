import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Ccadj extends JInternalFrame implements ActionListener
 { 
	JLabel conno,areacode,daycode,mtrcode,officename,dmd,dmid;
	JComboBox con_no,area_code,day_code,mtr_code,office_name;
	JTextField demand,dm_id;
	
	JButton ok,edit,cancel;
	
	public Ccadj (String title)
  	{


		super("Demand Adjustment");
		setLayout(null);
		conno=new JLabel("Consumer Number");
		con_no=new JComboBox();
		con_no.setPreferredSize(new Dimension(100,20));
		dmid=new JLabel("Demand ID");
dmid.setForeground(new Color(150,100,150)); 
		//String area[] = {"A01","A02","A03","A04","A05","B01","B02","B03","B04","B05"};
		dm_id=new JTextField(10);
		//daycode=new JLabel("Day code");
		//day_code=new JComboBox();
		mtrcode=new JLabel("Meter Reader Code");
		String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code=new JComboBox(mtrcd);
		officename=new JLabel("Name of the Office");
		
		String office[]={"Vydhuthi Bhavan,Kottarakkara","Oversear Office,Neduvathoor"};
		office_name=new JComboBox(office);
		dmd=new JLabel("Demand to be adjusted");
		demand=new JTextField(10); //read from the database
		
		ok=new JButton("Adjust");
		cancel=new JButton("Cancel");
		edit=new JButton("Edit");
		
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p6;

		p1=new JPanel();

		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1. add(conno);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(con_no);		
		p1.add(Box.createRigidArea(new Dimension(30,0)));
		p1.add(dmid);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(dm_id);

		//p2=new JPanel();
		//p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
		//p2. add(mtrcode);
		//p2.add(Box.createRigidArea(new Dimension(10,0)));
		//p2.add(mtr_code);	
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(2,2,10,10));
		p3.add(officename);
		p3.add(office_name);     
		p3.add(dmd);
		p3.add(demand);        
		
		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
			setLocation(120,70);

		p1.setBounds(80,100,450,30);
		add(p1);
		//p2.setBounds(320,138,212,30);
		//add(p2);
		p3.setBounds(80,180,450,60);
		add(p3);
		p4.setBounds(100,270,380,30);
		add(p4);
		
		
		JLabel c=new JLabel("DEMAND ADJUSTMENT");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(200,0,20)); 
		
		
		p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(100,30,350,50);
     			p6.add(c);
     			add(p6);  
		
		cancel.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
		}


		public static void main(String arg[])
		{
		/*	Ccadj cadj = new Ccadj("Current Charge Adjustment");
			cadj.setSize(600,550);
			cadj.setVisible(true);*/
	}

}
