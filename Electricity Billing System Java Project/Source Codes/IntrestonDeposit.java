import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class IntrestonDeposit extends JInternalFrame implements ActionListener
 { 
	JLabel conno,areacode,daycode,cdamt,intrest,mtrcode;
	JComboBox con_no,area_code,day_code,mtr_code;
	JTextField cd_amt,ints;
	
	JButton ok,edit,cancel;
	
	public IntrestonDeposit(String title)
  	{


		super("Intrest on Deposit");
		setLayout(null);
		conno=new JLabel("Consumer Number");
		con_no=new JComboBox();
		con_no.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		String area[] = {"A01","A02","A03","A04","A05","B01","B02","B03","B04","B05"};
		area_code=new JComboBox(area);
		//daycode=new JLabel("Day code");
		//day_code=new JComboBox();
		mtrcode=new JLabel("M R Code");
		String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code=new JComboBox(mtrcd);
		cdamt=new JLabel("Deposit Amount");
		cd_amt=new JTextField(10); //read from the database
		intrest=new JLabel("Intrest");
		ints=new JTextField(10);
		ok=new JButton("Allow Intrest");
		cancel=new JButton("Cancel");
		edit=new JButton("edit");
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p5,p6;

		
		p1=new JPanel();

		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1. add(areacode);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(area_code);		
		p1.add(Box.createRigidArea(new Dimension(20,0)));
		p1.add(mtrcode);
		p1.add(Box.createRigidArea(new Dimension(30,0)));
		p1.add(mtr_code);
		/*p1.add(mtrcode);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(mtr_code);	*/

	/*	p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
		p2. add(mtrcode);
		p2.add(Box.createRigidArea(new Dimension(10,0)));
		p2.add(mtr_code);*/
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(3,2,10,10));
		p3.add(conno);
		p3.add(con_no);     
		p3.add(cdamt);
		p3.add(cd_amt); 
		p3. add(intrest);
		//p2.add(Box.createRigidArea(new Dimension(10,0)));
		p3.add(ints);	       
		
		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
		/*
		//p1.add(new JLabel("Choose an Area Code and Consumer Number"));
		p1.setPreferredSize(new Dimension(880,70));
		
	
		
		
		

		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));
		
		
				
		p4.add(p1);
		p4.add(p3);
		p4.add(p2);

		p4.setBounds(80,100,400,160);
		//p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(20,20,20,20)));
		//p4.setBorder(BorderFactory.createEtchedBorder());
		
		//p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));
		//p4.setBounds(120,400,100,100); */

		p1.setBounds(80,100,350,25);
		add(p1);
	//	p2.setBounds(230,148,200,25);
	//	add(p2);
		p3.setBounds(80,200,450,80);
		add(p3);
		p4.setBounds(100,300,380,30);
		add(p4);
		
		
		
		JLabel c=new JLabel("INTREST ON DEPOSIT");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(90,0,20)); 
		
		
		p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(100,30,350,50);
     			p6.add(c);
     			add(p6);  
		
			setLocation(120,70);
cancel.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
   if(e.getSource()==cancel)
     {
	this.dispose();
      }
}
		
		
		
	//	setLocation(150,80);
		
	

		/*public static void main(String arg[])
		{
			IntrestonDeposit id = new IntrestonDeposit("Intrest on Deposit");
			id.setSize(550,550);
			id.setVisible(true);
	}*/

}
