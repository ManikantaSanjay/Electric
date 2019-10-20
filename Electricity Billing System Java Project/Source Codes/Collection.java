import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class Collection extends JInternalFrame implements ActionListener
 { 
	JLabel conno,areacode,mtrcode,a_cd ;
	
	JTextField f_c,e_c,m_r,oyec,tariff,ints,unit_con,acd,area_code,mtr_code;
	JComboBox con_no;
	JButton qry,bd,pr,exit;
	String ac[]={"A01","A02","A03","A04","A05","A06","A07","A08","A09","A10","A11","A12","A13","A14","A15","A16","A17","A18","A19","A20","A21","A22","A23","A24","A25","B01","B02","B03","B04","B05","B06","B07","B08","B09","B10","B11","B12","B13","B14","B15","B16","B17","B18","B19","B20","B21","B22","B23","B24","B25"};
	String mc[]={"1","2","3","4","5","6","7","8"};
	public Collection(String title)
  	{


		super("COLLECTION WINDOW");
		setLayout(null);
		conno=new JLabel("Consumer Number");

		try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		con_no=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		//con_no=new JComboBox();
		con_no.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		area_code=new JTextField (10);
		mtrcode=new JLabel("Meter Reader Code");
	
		mtr_code=new JTextField (10);
		JLabel tarif=new JLabel("Tariff");
		tariff=new JTextField(10);
		JLabel oyecinst=new JLabel("Pending OYEC");
		oyec=new JTextField(10); //read from the database
		
		a_cd=new JLabel("ACD");
		acd=new JTextField(10);
		
		qry=new JButton("Quierry");
		
		FlowLayout layout=new FlowLayout();
		bd=new JButton("Offset");
		pr=new JButton("Receipt");
		exit=new JButton("exit");

		JPanel p1,p2,p3,p4,p5,p6,p7;
	setLocation(200,150);
	
		p1=new JPanel();
		p1.setLayout(new GridLayout(6,2,0,5));
		p1.add(conno);
		p1.add(con_no);
		p1.add(areacode);
		p1.add(area_code);		
		p1.add(mtrcode);
		p1.add(mtr_code);
		p1.add(tarif);
		p1.add(tariff);
		p1.add(oyecinst);
		p1.add(oyec); 
		
		p1.add(a_cd);
		p1.add(acd);
		p1.setBounds(50,100,265,196);
		add(p1);

		//p2=new JPanel();
		//p2.setLayout(new FlowLayout());
		//p2.add(qry);
		//p2.setBounds(270,95,90,40);
		//add(p2);
		
		JLabel c=new JLabel("COLLECTION");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(150,0,200));      
		
		        p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(60,50,250,30);
     			p6.add(c);
     			add(p6);
     			
		
		p5=new JPanel();
		p5.setLayout(new GridLayout(1,3,10,10));
		p5.add(bd);
		p5.add(pr);
		p5.add(exit);
		p5.setBounds(10,400,300,30);
		add(p5);
	
		JLabel amtc=new JLabel("Energy Charge to be collected");
		f_c=new JTextField(10);
		JLabel amtcd=new JLabel("Amount  collected");
		e_c=new JTextField(10);
;
		p7=new JPanel();
		p7.setLayout(new GridLayout(3,2,0,5));
		p7.add(amtc);
		p7.add(f_c);
		p7.add(amtcd);
		p7.add(e_c);

		p7.setBounds(5,320,340,80);
		add(p7);
		
		
			setLocation(200,70);
		
		exit.addActionListener(this);
		con_no.addActionListener(this);
		bd.addActionListener(this);
		
		}
			public void actionPerformed(ActionEvent e)
			{
			if(e.getSource()==exit)
				{
				this.dispose();
				}
				if(e.getSource()==con_no)
				{
					System.out.println("Entered   CON_NO");
					try{

					QueryData qd = new QueryData();

					String id=(String)con_no.getSelectedItem();
					Vector v = qd.getConsumerDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					Enumeration em=v.elements();
					area_code.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
					mtr_code.setText((String)em.nextElement());
					tariff.setText((String)em.nextElement());
				//___________________________________________________
						//if((tariff=em.nextElement())!=null)
						//tariff.setText(tariff);
				//-----------------------------------------------------------------------------	
					
				
					
				}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
			}



    			if(e.getSource()==con_no)
				    {
				System.out.println("Entered   CON_NO");
				try{

				QueryData qd = new QueryData();

					String id=(String)con_no.getSelectedItem();
					Vector v13 = qd.getOyecdues(id.trim()); 
					if(!(v13.isEmpty())){
					//System.out.println("Consumer Details  " + v);
					Enumeration em1=v13.elements();
					oyec.setText((String)em1.nextElement());
					//System.out.println((String)em.nextElement());
					}else
						oyec.setText("");
				}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
		}

		
		
		if(e.getSource()==con_no)
			{
					System.out.println("Entered   CON_NO");
					f_c.setText("");
			try{

				QueryData qd = new QueryData();

					String id=(String)con_no.getSelectedItem();
					Vector v14 = qd.getNetdem(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					String c="";
					if(!(v14.isEmpty())){
						System.out.println("Entered loop");
						Enumeration em2=v14.elements();
						c=(String)em2.nextElement();							
						System.out.println("Value of C :" + c);
						f_c.setText(c);
						
					}
						
					//f_c.setText((String)em2.nextElement());
					//System.out.println((String)em.nextElement());
					
				//___________________________________________________
						
				//-----------------------------------------------------------------------------	
					
					
				
					
				}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
		}
		
		
			if(e.getSource()==bd)
			{
					System.out.println("Entered   offset");
			try{
				
				QueryData qd = new QueryData();
					PreparedStatement pst2 = 			qd.getConnect().prepareStatement("insert into sbcollection values(?,?,?,?)");
					pst2.setString(1,(String)con_no.getSelectedItem());
					pst2.setString(2,area_code.getText());
					pst2.setString(3,mtr_code.getText());
					pst2.setString(4,e_c.getText());
					//pst2.setString(5,totno_inst.getText());
					
					
					int i=pst2.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"Collectin details entered","COLLECTION ",1);
					}
					
					
						}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
		}
		
	
		
		
}



		/*public static void main(String arg[])
		{
			Collection c = new Collection("COLLECTION WINDOW");
			c.setSize(450,550);
			c.setVisible(true);
	}*/

}
