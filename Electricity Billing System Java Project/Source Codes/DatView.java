import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
public class DatView extends JInternalFrame implements ActionListener
{
	JLabel mrcode,conname,addr,mtrno,ir,cr,nodigit,tariff,phase,postno,cload,doc,dd1,mm1,yy1;
	JTextArea address;
	JTextField ta_riff,cphase,area_code1,area_code2,area_code3,mr_code1,mr_code2,mr_code3, con_name,post_no,c_load,mtr_no,i_r,c_r,no_digit,date1,m1,y1,d2,m2,y2,d3,m3,y3,d4,m4,y4,d5,m5,y5,d6,m6,y6,m505,m77;
	JButton qry,cancel,list, listall;
	JComboBox con_no1, con_no2,con_no3,con_no4;
	 JTextField ac_d,rt_no1,cash_deposit,rt_no2,totno_inst,oyec_amt,inst_amt,paid_inst,bal_inst,ending_month;
JTextField lemgamt,scmgamt,lramt,ilemg,iscmg,ilr,noofinst_lemg,noofinst_semg,noofinst_lr,pnoofinst_lemg,pnoofinst_semg,pnoofinst_lr;

	String dw[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"Month","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String ac[]={"A01","A02","A03","A04","A05","A06","A07","A08","A09","A10","A11","A12","A13","A14","A15","A16","A17","A18","A19","A20","A21","A22","A23","A24","A25","B01","B02","B03","B04","B05","B06","B07","B08","B09","B10","B11","B12","B13","B14","B15","B16","B17","B18","B19","B20","B21","B22","B23","B24","B25"};
	String mc[]={"1","2","3","4","5","6","7","8"};
	String yw[]={"Year","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	String t[]={"IA","IB","IC","II","III","IV","V","VIA","IVB","IVC","IVD","VIIA","VIIB","VIIC","VIII"};
	String p[]={"Single","Three"};
	
	
	JTabbedPane tb;
	
	public DatView(String title)
	{
		super("Data View");
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		
		JLabel cd=new JLabel("CONSUMER DETAILS");
			
		cd.setFont(new Font("Times New Roman",Font.BOLD,20));
		cd.setForeground(new Color(50,150,20));
		
			JPanel p65=new JPanel();
			p65.setLayout(new FlowLayout());
     			p65.setBounds(150,0,350,30);
     			p65.add(cd);
     			
     			panel1.add(p65);
			
//************************************NEW CONSUMER .1********************************
        		JLabel conno=new JLabel("Consumer Number");
		try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		con_no1=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		JLabel areacode=new JLabel("Area Code");
		area_code1=new JTextField(10);
		mrcode=new JLabel("Meter Reader Code");
		mr_code1=new JTextField(10);
		tariff=new JLabel("tariff");
		ta_riff=new JTextField(10);
		phase=new JLabel("phase");
		cphase=new JTextField(10);	
		postno=new JLabel("Postnumber");
		post_no=new JTextField(20);	
		cload=new JLabel("Connected Load");
		c_load=new JTextField(20);
		
		doc=new JLabel("Date of connection");
		date1=new JTextField(15);
		//m1=new JTextField(5);
		//y1=new JTextField(5);
		
		JPanel p1= new JPanel();
		
		
		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1.setLayout(new GridLayout(8,2,0,0));
	
		p1.add(conno);
		p1.add(con_no1);
		p1.add(areacode);
    		p1.add(area_code1);
    		area_code1.setEditable(false);
    		p1.add(mrcode);
    		p1.add(mr_code1);
    		mr_code1.setEditable(false);
		p1.add(tariff);
		p1.add(ta_riff);
	ta_riff.setEditable(false);
		p1.add(phase);
		p1.add(cphase);
		cphase.setEditable(false);
		p1.add(postno);
		p1.add(post_no);
		post_no.setEditable(false);
		p1.add(cload);
		p1.add(c_load);
		c_load.setEditable(false);
		
	

        		conname=new JLabel("Consumer name");
       		 con_name=new JTextField(60);
    		addr = new JLabel("Address");
		address= new JTextArea(5,5);
		JScrollPane scroll = new JScrollPane(address);
		JPanel p2 = new JPanel();
		
		p2.setLayout(new GridLayout(1,1,0,0));
		p2.add(conname);
		JPanel p3 = new JPanel();
		
		p3.setLayout(new GridLayout(1,1,0,0));
		p3.add(con_name);
		con_name.setEditable(false);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1,1,0,0));
		p4.add(addr);
		
		
		JPanel p5 = new JPanel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.X_AXIS));
		p5.setLayout(new GridLayout(1,1,0,0));
		p5.add(Box.createRigidArea(new Dimension(80,0)));
		p5.add(scroll);
		address.setEditable(false);

		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(1,1,0,0));
		p6.add(doc);
	
		
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(1,1,0,0));
		p7.add(date1);
		//p7.add(m1);
		//p7.add(y1);
		date1.setEditable(false);
		
		qry=new JButton("view all");
     		
		JPanel p8=new JPanel();
		p8.setLayout(new FlowLayout());
     		p8.setBounds(270,230,200,40);
     		//p8.add(qry);
     			
		p1.setBounds(20,30,230,200);
		p2.setBounds(300,30,100,20);
		p3.setBounds(402,30,225,20);
		p4.setBounds(300,90,75,20);
     		p5.setBounds(168,60,462,100);
		p6.setBounds(300,190,120,20);
		p7.setBounds(425,190,200,20);
		
		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		panel1.add(p5);
		panel1.add(p6);		
		panel1.add(p7);		
	
		panel1.add(p8);
	
	//************************METER DETAILS .2********************************

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		JLabel md=new JLabel("METER DETAILS");
			
		md.setFont(new Font("Times New Roman",Font.BOLD,25));
		md.setForeground(new Color(180,0,230));
	
		JPanel p55=new JPanel();
		p55.setLayout(new FlowLayout());
     		p55.setBounds(200,30,350,30);
     		p55.add(md);
         		panel2.add(p55);	
		JPanel p9 = new JPanel();
		p9.setLayout(new GridLayout(4,2,10,10));
		JLabel conno1=new JLabel("Consumer Number");
		Vector v2=null;
		try{
		QueryData qd = new QueryData();
		v2= qd.getConsumer(); 
		con_no2=new JComboBox(v2);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		System.out.println("Elements in V2 " + v2);
		
		mtrno=new JLabel("Metre Number");
		mtr_no=new JTextField(10);
		mtr_no.setEditable(false);
		nodigit=new JLabel("No of Digits");
		no_digit=new JTextField(10);
		no_digit.setEditable(false);
		ir=new JLabel("Initial Reading");
		i_r=new JTextField(20);
		i_r.setEditable(false);
		qry=new JButton("view all");
		p9.add(conno1);
		p9.add(con_no2);
		p9.add(mtrno);
		p9.add(mtr_no);
		p9.add(nodigit);
		p9.add(no_digit);
		p9.add(ir);
		p9.add(i_r);
		p9.setBounds(50,100,300,150);
		JPanel p10 = new JPanel();
		p10.setLayout(new GridLayout(1,2,10,10));
		//p10.add(qry);
		p10.setBounds(250,305,170,30);
		panel2.add(p9);
		panel2.add(p10);
		
			
//**************************************************************************************
//DEPOSIT DETAILS .3
	JLabel acd,rtno1,cashdeposit,rtno2,totnoinst,oyecamt;
			JPanel panel3 = new JPanel();
			panel3.setLayout(null);
			JLabel dd=new JLabel("DEPOSIT DETAILS");
			
			dd.setFont(new Font("Times New Roman",Font.BOLD,25));
			dd.setForeground(new Color(180,60,30));
		
			JPanel p45=new JPanel();
			p45.setLayout(new FlowLayout());
     			p45.setBounds(200,30,350,30);
     			p45.add(dd);
     			
     			panel3.add(p45);
				
			conno=new JLabel("Consumer No:");
			Vector v3=null;
			try{
				QueryData qd = new QueryData();
				v3= qd.getConsumer(); 
				con_no3=new JComboBox(v3);
			}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
			areacode=new JLabel("Area Code");                   
			area_code2=new JTextField(10);
			area_code2.setEditable(false);
			mrcode=new JLabel("Meter Reader Code");
			mr_code2=new JTextField(10);
			mr_code2.setEditable(false);
			
			JPanel p11=new JPanel();
			p11.setLayout(new GridLayout(1,1,0,0));
		
			p11.add(conno);
			p11.setBounds(10,10,80,20);
		
			
			JPanel p101=new JPanel();
	     		p101.setLayout(new GridLayout(1,1,0,0));
			p101.add(con_no3);
			p101.setBounds(95,10,100,20);
		
	
			JPanel p112=new JPanel();
			p112.setLayout(new FlowLayout());
			p112.setBounds(0,75,400,40);
			p112.add(p11);
			p112.add(p101);
	    		panel3.add(p112);
			JPanel p12=new JPanel();
			p12.setLayout(new GridLayout(4,2,0,10));                    
			cashdeposit=new JLabel("Cash deposit");
			cash_deposit=new JTextField(10);
			cash_deposit.setEditable(false);
			acd=new JLabel("A C D");
			ac_d=new JTextField(10);
			ac_d.setEditable(false);
			oyecamt=new JLabel("OYEC Amount");
			oyec_amt=new JTextField(10);
			oyec_amt.setEditable(false);
			totnoinst=new JLabel("Total no of instalments");
			totno_inst=new JTextField(10);
		totno_inst.setEditable(false);
		p12.add(cashdeposit);	
		p12.add(cash_deposit);
		p12.add(acd);	
		p12.add(ac_d);
		p12.add(oyecamt);	
		p12.add(oyec_amt);
		p12.add(totnoinst);
		p12.add(totno_inst);
		p12.setBounds(5,140,300,105);
		panel3.add(p12);

		rtno1=new JLabel("Receipt no");
		rt_no1=new JTextField(10);
		rt_no1.setEditable(false);
		rtno2=new JLabel("Receipt no");
		rt_no2=new JTextField(10);
		rt_no2.setEditable(false);
		d4=new JTextField(12);
		d4.setEditable(false);
		
		d5=new JTextField(12);
		d5.setEditable(false);
		
		JPanel p13,p14;
		p13=new JPanel(new FlowLayout());
		p13.add(rtno1);
		p13.add(rt_no1);
		p13.add(d4);
		
		p14 = new JPanel(new FlowLayout());
		p14.add(rtno2);
		p14.add(rt_no2);
		p14.add(d5);
		
		p13.setBounds(300,120,430,30);
		p14.setBounds(300,150,430,30);
		panel3.add(p13);
		panel3.add(p14);

		JLabel totinst,instamt,paidinst,balinst,endingmonth;
		JPanel p15=new JPanel();
		p15.setLayout(new GridLayout(3,2,0,10));
		instamt=new JLabel("Instalment Amt: ");
		inst_amt=new JTextField(10);
		inst_amt.setEditable(false);
		paidinst=new JLabel("Paid Instalments ");
		paid_inst=new JTextField(10);
			paid_inst.setEditable(false);			
		balinst=new JLabel("Balance Instalments ");
		bal_inst=new JTextField(10);
		bal_inst.setEditable(false);
		p15.add(instamt);
		p15.add(inst_amt);
		p15.add(paidinst);
		p15.add(paid_inst);
		p15.add(balinst);
		p15.add(bal_inst);
		p15.setBounds(390,190,250,100);
		panel3.add(p15);
		
		endingmonth=new JLabel("OYEC Instalment ends on the month");
	
		 m505=new JTextField(12);
		m505.setEditable(false);
		JPanel p16=new JPanel();
		p16.setLayout(new FlowLayout());
		p16.add(endingmonth);
		p16.add(m505);
		
		p16.setBounds(0,255,360,30);
		panel3.add(p16);
		
		qry=new JButton("QUIERY");
		JPanel p38=new JPanel();
		p38.setLayout(new FlowLayout());
     		p38.setBounds(270,330,200,40);
     		//p38.add(qry);
     		panel3.add(p38);
		
		
		
//************************MINIMUM  GAURENTEE .4****************************


JTextField y7;

           JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		JLabel mg=new JLabel("MINIMUM GAURENTEE");	
		mg.setFont(new Font("Times New Roman",Font.BOLD,25));
		mg.setForeground(new Color(80,0,230));
		JLabel lemg=new JLabel("           LEMG         ");
		JLabel scmg=new JLabel("                       SCMG         ");
		JLabel lr=new JLabel("               Line Rent");		
		JLabel amt=new JLabel("Amount");
		lemgamt=new JTextField(10);		
		scmgamt=new JTextField(10);
		lramt=new JTextField(10);
		JLabel iamt=new JLabel("Instalment Amt");
		ilemg=new JTextField(10);		
		iscmg=new JTextField(10);
		ilr=new JTextField(10);
	   	 conno=new JLabel("Consumer No:");
	   	 lemgamt.setEditable(false);
	   	 scmgamt.setEditable(false);
	   	 lemgamt.setEditable(false);
	   	 lramt.setEditable(false);
	   	 ilemg.setEditable(false);
	   	 ilr.setEditable(false);
	   	 iscmg.setEditable(false);

			Vector v4=null;
			try{
				QueryData qd = new QueryData();
				v4= qd.getConsumer(); 
				con_no4=new JComboBox(v4);
				con_no4.setEditable(false);

				area_code3=new JTextField(10);
				area_code3.setEditable(false);
				mr_code3=new JTextField(10);
				mr_code3.setEditable(false);
		
			}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
	
    		//con_no4=new JComboBox();
		//area_code3=new JTextField(10);
		//mr_code3=new JTextField(10);
		
		JPanel p17=new JPanel();
		p17.setLayout(new GridLayout(1,1,0,10));
		p17.setBounds(50,70,85,20);
		p17.add(conno);

		JPanel p18=new JPanel();
		p18.setLayout(new GridLayout(1,1,0,10));
		p18.setBounds(135,70,100,20);
     		p18.add(con_no4);
		
		JPanel p19=new JPanel();
		p19.setLayout(new GridLayout(1,1,0,10));
		p19.setBounds(240,70,65,20);	
		p19.add(areacode);
			
		JPanel p20=new JPanel();
		p20.setLayout(new GridLayout(1,1,0,10));
		p20.setBounds(308,70,80,20);
		p20.add(area_code3);
		
		JPanel p21=new JPanel();
		p21.setLayout(new GridLayout(1,1,0,10));
		p21.setBounds(400,70,120,20);
		p21.add(mrcode);
		
		JPanel p22=new JPanel();
		p22.setLayout(new GridLayout(1,1,0,10));
		p22.setBounds(520,70,90,20);
		p22.add(mr_code3);
		

    		JLabel p23=new JLabel("No of Instalments");			
		noofinst_lemg=new JTextField(10);				
		noofinst_semg=new JTextField(10);	
		noofinst_lr=new JTextField(10);	
		noofinst_lemg.setEditable(false);
	   	 
	   	 noofinst_lr.setEditable(false);
	   	
		
		JPanel p24=new JPanel();
		p24.setLayout(new GridLayout(2,4,0,10));
		p24.add(amt);
		p24.add(lemgamt);
		p24.add(scmgamt);
		p24.add(lramt);
		p24.add(iamt);
		p24.add(ilemg);
		p24.add(iscmg);
		p24.add(ilr);
		p24.setBounds(50,150,500,60);
		
		
		JPanel p25=new JPanel();
		p25.setLayout(new FlowLayout());
     		p25.setBounds(200,30,350,30);
     		p25.add(mg);
     	
   		JPanel p26=new JPanel();
		p26.setLayout(new FlowLayout());
     		p26.setBounds(170,130,350,30);
     		p26.add(lemg);
     		p26.add(scmg);
   		p26.add(lr);
   		
   		JLabel lim=new JLabel("MG ends as on");//ending month of minimum gaurentee
   		JLabel mm7=new JLabel("Month & Year");
	
		m77=new JTextField(10);
		m77.setEditable(false);
		//y7=new JTextField(5);
		
		
		JPanel p27=new JPanel();
		p27.setLayout(new GridLayout(1,2,0,10));
     		p27.setBounds(50,230,200,30);
     		p27.add(lim);
     		p27.add(m77);
     		//p27.add(y7);
     	
     		qry=new JButton("QUERY");
   		JPanel p28=new JPanel();
		p28.setLayout(new FlowLayout());
     		p28.setBounds(270,230,200,40);
     		//p28.add(qry);
     		//p28.add(edit);
     	
		
		panel4.add(p17);
		panel4.add(p18);
		panel4.add(p19);
		panel4.add(p20);
		panel4.add(p21);
		panel4.add(p22);
		panel4.add(p23);
		panel4.add(p24);
		panel4.add(p25);
		panel4.add(p26);
		panel4.add(p27);
		panel4.add(p28);
		
			tb = new JTabbedPane();
			
			panel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
			panel2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
	    		panel3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
			panel4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
	
	
			tb.addTab("ConsumerDetails",panel1);
	        		tb.addTab("MeterDetails",panel2);
		   	 tb.addTab("DepositDetails",panel3);
            			tb.addTab("Minimum gaurentee",panel4);
		
			cancel = new JButton("Cancel");

			JPanel pp = new JPanel();
			pp.setLayout(new FlowLayout());
			pp.add(cancel);
			getContentPane().add(tb,BorderLayout.CENTER);
			getContentPane().add(pp,BorderLayout.SOUTH);
			setLocation(120,70);		
			cancel.addActionListener(this);
			con_no1.addActionListener(this);
			con_no2.addActionListener(this);
			con_no3.addActionListener(this);
			con_no4.addActionListener(this);
				
					}

			 public void actionPerformed(ActionEvent e)
			{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}if(e.getSource()==con_no1)
			{
				//System.out.println("Selecte d ocnsumer NO");
				try{
					QueryData qd = new QueryData();

					String id=(String)con_no1.getSelectedItem();
					Vector v = qd.getConsumerDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					Enumeration em=v.elements();
					area_code1.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
					mr_code1.setText((String)em.nextElement());
					ta_riff.setText((String)em.nextElement());
					cphase.setText((String)em.nextElement());
					post_no.setText((String)em.nextElement());
					c_load.setText((String)em.nextElement());
					con_name.setText((String)em.nextElement());
					address.setText((String)em.nextElement());
					date1.setText((String)em.nextElement());			
					}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
			}
 			if(e.getSource()==con_no2)
			{
					System.out.println("Entered   CON_NO2");
			try{

				QueryData qd = new QueryData();

				String id=(String)con_no2.getSelectedItem();
				Vector v2 = qd.getMeterDetails(id.trim()); 
				System.out.println("ELements in V2 : " + v2);
				Enumeration em2=v2.elements();
				mtr_no.setText((String)em2.nextElement());
				no_digit.setText((String)em2.nextElement());
				i_r.setText((String)em2.nextElement());
				//no_digit.setText((String)em.nextElement());
				}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}

			}

		if(e.getSource()==con_no3)
			{
					System.out.println("Entered   CON_NO3");
			try{

				QueryData qd = new QueryData();
				System.out.println((String)con_no3.getSelectedItem());
				String id=(String)con_no3.getSelectedItem();
			//=============================================
				Vector v3 = qd.getDepositDetails(id.trim()); 
			//=============================================
				System.out.println("ELements in V3 : " + v3);
				Enumeration em3=v3.elements();
				cash_deposit.setText((String)em3.nextElement());
				ac_d.setText((String)em3.nextElement());
				oyec_amt.setText((String)em3.nextElement());
				totno_inst.setText((String)em3.nextElement());
				//System.out.println("Ending month" + em3.nextElement());
				
				m505.setText((String)em3.nextElement());
				System.out.println("Date     : " + m505.getText());
				rt_no1.setText((String)em3.nextElement());
				d4.setText((String)em3.nextElement());
				rt_no2.setText((String)em3.nextElement());
				
				d5.setText((String)em3.nextElement());
				inst_amt.setText((String)em3.nextElement());
				paid_inst.setText((String)em3.nextElement());
				bal_inst.setText((String)em3.nextElement());
				
				}catch(Exception ex){System.out.println("Error in DataView " + ex);}

			}
		

		if(e.getSource()==con_no4)
			{
					System.out.println("Entered   CON_NO4");
			try{

				QueryData qd = new QueryData();
				System.out.println((String)con_no4.getSelectedItem());
				String id=(String)con_no4.getSelectedItem();
				 
				Vector v5 = qd.getAreaCode(id);
				Enumeration em5 = v5.elements();
				area_code3.setText((String)em5.nextElement());
				mr_code3.setText((String)em5.nextElement()); 
				Vector v4 = qd.getMgDetails(id.trim());  
				System.out.println("ELements in V4 : " + v4);
				Enumeration em4=v4.elements();
				lemgamt.setText((String)em4.nextElement());
				scmgamt.setText((String)em4.nextElement());
				lramt.setText((String)em4.nextElement());
				ilemg.setText((String)em4.nextElement());
				iscmg.setText((String)em4.nextElement());
				ilr.setText((String)em4.nextElement());
				m77.setText((String)em4.nextElement());
				System.out.println("Date     : " + m77.getText());
				//System.out.println("Ending month" + em4.nextElement());
				}catch(Exception ex){System.out.println("Error in DataView " + ex);}		
		}
		
		

}

			
		public static void main(String arg[])
		{
		/*DatView dv=new DatView("Data View");
		dv.setVisible(true);
		dv.setSize(750,500);
		//de.pack();*/
		}
}

