import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class Billdetails extends JInternalFrame implements ActionListener
 { 
	JLabel conno,areacode,prereading,presentreading,mtrcode,unitcon ;
	
	JTextField ad_v,dem_id,area_code,mtr_code,d1,d2,d3,m1,m2,m3,y1,y2,y3,dty,cash,bcash,net_amt,cdint,tot,arrear,dem,sub,f_c,e_c,m_r,pre_reading,present_reading,ints,unit_con,day_code,r_f,s_c;
	JComboBox con_no;
	JButton qry,dd,mrd,exit;
		String dw[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"Month","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};

	String yw[]={"Year","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	String ac[]={"A01","A02","A03","A04","A05","A06","A07","A08","A09","A10","A11","A12","A13","A14","A15","A16","A17","A18","A19","A20","A21","A22","A23","A24","A25","B01","B02","B03","B04","B05","B06","B07","B08","B09","B10","B11","B12","B13","B14","B15","B16","B17","B18","B19","B20","B21","B22","B23","B24","B25"};
	String mc[]={"1","2","3","4","5","6","7","8"};
	Connection con ;
	public 	Billdetails(String title)
  	{


		super("BILL DETAILS");
		setLayout(null);
		conno=new JLabel("Consumer Number");
                                       try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		con_no=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		con_no.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		area_code=new JTextField();
	
		mtrcode=new JLabel("Meter Reader Code");
		//String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code=new  JTextField();
		prereading=new JLabel("Previous Reading");
		pre_reading=new JTextField(10); //read from the database
		presentreading=new JLabel("Present Reading");
		present_reading=new JTextField(10);
		unitcon=new JLabel("Units consumed");
		unit_con=new JTextField(10);
		JLabel demid= new JLabel("Demand ID");
		dem_id=new JTextField(10);
		
		//qry=new JButton("Quierry");
		//ok=new JButton("Update");
		//cancel=new JButton("Cancel");
		//edit=new JButton("edit");
		FlowLayout layout=new FlowLayout();
		dd=new JButton("Show Demand details");
		
		mrd=new JButton("Meter Reading details");

		exit=new JButton("exit");


		JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;

		p1=new JPanel();
		p1.setLayout(new GridLayout(9,2,0,5));

		p1.add(conno);
		p1.add(con_no);
		p1.add(areacode);
		p1.add(area_code);		
		p1.add(mtrcode);
		p1.add(mtr_code);
		
		p1.add(prereading);
		p1.add(pre_reading); 
		p1.add(presentreading);
		p1.add(present_reading);
		p1.add(unitcon);
		p1.add(unit_con);
		p1.add(demid);
		p1.add(dem_id);
		p1.setBounds(10,100,250,196);
		add(p1);
		con_no.setEditable(false);
	   	 area_code.setEditable(false);
	   	 mtr_code.setEditable(false);
	   	 pre_reading.setEditable(false);
	   	 present_reading.setEditable(false);
	   	 unit_con.setEditable(false);
	   	 dem_id.setEditable(false);


		/*p2=new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(qry);
		p2.setBounds(262,163,90,40);
		add(p2);*/
		
		JLabel c=new JLabel("BILL DETAILS");
		c.setFont(new Font("Times New Roman",Font.BOLD,30));
		c.setForeground(new Color(200,0,20));      
		
		        p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(250,30,350,50);
     			p6.add(c);
     			add(p6);
     			//panel1.add(p65);
			
		
		p5=new JPanel();
		p5.setLayout(new GridLayout(1,1,10,10));
	//	p5.add(dd);
	//	p5.add(mrd);
		p5.add(exit);
		
		
		
		p5.setBounds(400,425,80,30);
		add(p5);
	
		JLabel fc=new JLabel("Fixed Charge");
		f_c=new JTextField(10);
		JLabel ec=new JLabel("Energy Charge");
		e_c=new JTextField(10);
		JLabel mr=new JLabel("Meter Rent");
		m_r=new JTextField(10);
		
		JLabel duty=new JLabel("DUTY TO GOVT:");
		dty=new JTextField(10);
		
		JLabel rf=new JLabel("Re con: fee");
		r_f=new JTextField(10);
		JLabel sc=new JLabel("Surcharge");
		s_c=new JTextField(10);
		JLabel demd=new JLabel("Demand for  ..... ");
		dem=new JTextField(10);
		
		JLabel subsi=new JLabel("Subsidy");
		sub=new JTextField(10);
		
		JLabel adv=new JLabel("Advance Paid");
		ad_v=new JTextField(10);
		
		JLabel prebal=new JLabel("Previous arrears");
		arrear=new JTextField(10);
		
		JLabel total=new JLabel("Total");
		tot=new JTextField(10);	
		JLabel intcd=new JLabel("Intrest on CD");
		cdint=new JTextField(10);
		JLabel netamt=new JLabel("NET AMOUNT PAYABLE");
		net_amt=new JTextField(10);	
		
		p7=new JPanel();
		p7.setLayout(new GridLayout(12,2,0,7));
		p7.add(fc);
		p7.add(f_c);
		p7.add(ec);
		p7.add(e_c);
		
		f_c.setEditable(false);
	   	 e_c.setEditable(false);
	   	 dty.setEditable(false);

		
		p7.add(duty);
		p7.add(dty);
		
		
		p7.add(mr);
		p7.add(m_r);
		p7.add(rf);
		p7.add(r_f);
		
		p7.add(demd);
		p7.add(dem);
		p7.add(subsi);
		p7.add(sub);
		
		
		m_r.setEditable(false);
	   	 r_f.setEditable(false);
	   	 dem.setEditable(false);
	   	 sub.setEditable(false);


		//p7.add(demd);
		//p7.add(dem);
		
		p7.add(adv);
		p7.add(ad_v);
		
		
		p7.add(prebal);
		p7.add(arrear);
		
		p7.add(total);
		p7.add(tot);
		p7.add(intcd);
		p7.add(cdint);
		p7.add(netamt);
		p7.add(net_amt);
		 ad_v.setEditable(false);
	   	 arrear.setEditable(false);
		 tot.setEditable(false);
	   	 cdint.setEditable(false);
	   	 dem.setEditable(false);
	   	 net_amt.setEditable(false);

		
		p7.setBounds(352,100,270,260);
		add(p7);
		
		JLabel bdate=new JLabel("Bill Date");
		d1=new JTextField(10);
		//m1=new JTextField(5);
		//y1=new JTextField(5);
		JLabel ddate=new JLabel("Due Date");
		d2=new JTextField(10);
		//m2=new JTextField(5);
		//y2=new JTextField(5);
		JLabel disdate=new JLabel("Disconnnection date");
		d3=new JTextField(10);
		//m3=new JTextField(5);
		//y3=new JTextField(5);
		
		p8=new JPanel();
		p8.setLayout(new GridLayout(1,1,10,10));
		p8.add(bdate);
		p8.setBounds(650,100,120,20);
		add(p8);
		
		p9=new JPanel();
		p9.setLayout(new GridLayout(1,1,0,10));
		p9.add(d1);
		//p9.add(m1);
	    //p9.add(y1);
		p9.setBounds(650,120,150,20);
		add(p9);
	
		
		p10=new JPanel();
		p10.setLayout(new GridLayout(1,1,10,10));
		p10.add(ddate);
		p10.setBounds(650,140,120,20);
		add(p10);
		
		p11=new JPanel();
		p11.setLayout(new GridLayout(1,1,0,10));
		p11.add(d2);
		//p11.add(m2);
	    //p11.add(y2);
		p11.setBounds(650,160,150,20);
		add(p11);
		
		p12=new JPanel();
		p12.setLayout(new GridLayout(1,1,10,10));
		p12.add(disdate);
		p12.setBounds(650,180,120,20);
		add(p12);
		
		p13=new JPanel();
		p13.setLayout(new GridLayout(1,1,0,10));
		p13.add(d3);
		//p13.add(m3);
	   // p13.add(y3);
		p13.setBounds(650,200,150,20);
		add(p13);
	
		 d1.setEditable(false);
	   	 d2.setEditable(false);
	   	 d3.setEditable(false);

	setLocation(50,70);
	
JLabel amtpaid=new JLabel("Cash paid");
cash=new JTextField(10);
JLabel balamt=new JLabel("Balance adjustable ");
bcash=new JTextField(10);
//JLabel duty=new JLabel("DUTY TO GOVT:");
//dty=new JTextField(10);
p14=new JPanel();
p14.setLayout(new GridLayout(6,1,0,5));
//p14.add(duty);
//p14.add(dty);
p14.add(amtpaid);
p14.add(cash);
p14.add(balamt);
p14.add(bcash);

		 cash.setEditable(false);
	   	 bcash.setEditable(false);

p14.setBounds(650,225,120,130);
		add(p14);
exit.addActionListener(this);
con_no.addActionListener(this);			
					}
		
                               public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==exit)
			{
				this.dispose();
			}if(e.getSource()==con_no)
			{
				//System.out.println("Selecte d ocnsumer NO");
				try{

					
					QueryData qd = new QueryData();

					String id=(String)con_no.getSelectedItem();
					/*Vector v = qd.getBillDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					System.out.println(id + "Bill Details " + v );
					Enumeration em=v.elements();
					area_code.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
					mtr_code.setText((String)em.nextElement());
					
				
					String cl=qd.getInitialReading(id);
					if(cl!=null)
						pre_reading.setText(cl);*/
					
					Vector v11 = qd.getDmdwiew(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					System.out.println(id + "Bill  " + v11 );
					Enumeration em=v11.elements();
					
					area_code.setText((String)em.nextElement());
					mtr_code.setText((String)em.nextElement());
					pre_reading.setText((String)em.nextElement());
					present_reading.setText((String)em.nextElement());
					unit_con.setText((String)em.nextElement());
					dem_id.setText((String)em.nextElement());
					f_c.setText((String)em.nextElement());
					e_c.setText((String)em.nextElement());
					dty.setText((String)em.nextElement());
					m_r.setText((String)em.nextElement());
					r_f.setText((String)em.nextElement());
					dem.setText((String)em.nextElement());
					sub.setText((String)em.nextElement());
					ad_v.setText((String)em.nextElement());
					arrear.setText((String)em.nextElement());
					tot.setText((String)em.nextElement());
					cdint.setText((String)em.nextElement());
					net_amt.setText((String)em.nextElement());
					d1.setText((String)em.nextElement());
					d2.setText((String)em.nextElement());
					d3.setText((String)em.nextElement());			
					}catch(Exception ex){System.out.println("Error in Bill Details " + ex);}
			}	
	
	}

		public static void main(String arg[])
		{
		/*	Billdetails bd = new Billdetails("BILL DETAILS");
			bd.setSize(900,550);
			bd.setVisible(true);*/
	}

}

