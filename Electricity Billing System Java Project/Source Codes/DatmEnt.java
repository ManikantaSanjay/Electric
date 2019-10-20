import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class DatmEnt extends JFrame //implements ActionListener
{
	JLabel presentmtrno,newmtrno,maker,maker_new,day,day1,month,month1,year,year1,finalreading,initialreading,areacode,mrcode,conno,conname,addr,mtrno,ir,cr,nodigit,tariff,phase,postno,cload,doc,dd1,mm1,yy1;
	JTextArea address;
	JTextField  mr_code,con_name,post_no,c_load,area_code,mtr_no,i_r,c_r,no_digit,pre_mtr_no,new_mtr_no,f_r;
	JButton add,edit,cancel,list, listall,ok;
	JComboBox con_no,ta_riff,cphase,d1,m1,y1,d2,m2,y2,d3,m3,y3,d4,m4,y4,d5,m5,y5,d6,m6,y6,con_no1,con_no2;
	 JTextField ac_d,rt_no1,cash_deposit,rt_no2,totno_inst,oyec_amt,inst_amt,paid_inst,bal_inst,ending_month;
 JTextArea note;
//	JButton ok,edit,cancel;
	String dw[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"Month","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String ac[]={"A01","A02","A03","A04","A05","A06","A07","A08","A09","A10","A11","A12","A13","A14","A15","A16","A17","A18","A19","A20","A21","A22","A23","A24","A25","B01","B02","B03","B04","B05","B06","B07","B08","B09","B10","B11","B12","B13","B14","B15","B16","B17","B18","B19","B20","B21","B22","B23","B24","B25"};
	String mc[]={"1","2","3","4","5","6","7","8"};
	String yw[]={"Year","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	String t[]={"IA","IB","IC","II","III","IV","V","VIA","IVB","IVC","IVD","VIIA","VIIB","VIIC","VIII"};
	String p[]={"Single","Three"};
	
	
	JTabbedPane tb;
	
	public DatmEnt(String title)
	{
		super("Data Entry");
		
		
        conno=new JLabel("CONSUMER NUMBER");
		con_no=new JComboBox();
		con_no.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("AREACODE");
		
		area_code=new JTextField(10);
		mrcode=new JLabel("Meter Reader Code");
		mr_code=new JTextField(10);
		
		mtrno=new JLabel("Metre Number");
		mtr_no=new JTextField(10);
		nodigit=new JLabel("No of Digits");
		no_digit=new JTextField(10);
		ir=new JLabel("Initial Reading");
		i_r=new JTextField(20);
		JButton save1=new JButton("save");
		JButton edit1=new JButton("edit");
		
		JPanel p9=new JPanel();
		p9.add(conno);
		p9.add(con_no);
		p9.add(mtrno);
		p9.add(mtr_no);
		p9.add(nodigit);
		p9.add(no_digit);
		p9.add(ir);
		p9.add(i_r);
		p9.setBounds(50,100,300,150);
		
	/*	JLabel fr=new JLabel("Final Reading");
		f_r=new JTextField(10);
		
		newmtrno=new JLabel("New Meter Number");
		new_mtr_no=new JTextField(10);
		JLabel ir=new JLabel("Initial Reading");
		i_r=new JTextField(10);
		
		note=new JTextArea(10,5);
		ok=new JButton("UPDATE");
		edit=new JButton("EDIT");
		cancel=new JButton("CANCEL");
		FlowLayout layout=new FlowLayout();
		
presentmtrno=new JLabel("Present Meter No:");
		pre_mtr_no=new JTextField(10);
		
		JPanel p1,p2,p3,p4,p5,p6;

		p1=new JPanel();
	
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();

//p9.add(conno1);
		;
		p1.setLayout(layout);
		p2.setLayout(new GridLayout(4,2,10,10));
		p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		p4.setLayout(new GridLayout(1,3,10,10));
		p5.setLayout(layout);
		p6.setLayout(new GridLayout(3,1));

		p1. add(conno);
		p1.add(con_no);
		p1.add(areacode);
		p1.add(area_code);
		p1.add(new JLabel("Choose an Area Code and Consumer Number"));
		p1.setPreferredSize(new Dimension(380,70));
		p2.add(presentmtrno);
		p2.add(pre_mtr_no);
		p2.add(fr);
		p2.add(f_r);
		
		p2.add(newmtrno);
		p2.add(new_mtr_no);
		p2.add(ir);
		p2.add(i_r);

		p3.add(new JLabel("Note  :"));
		p3.add(note);

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
		p5.add(p1);
		p5.add(p2);

		p5.setBounds(80,100,400,200);
		//p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(20,20,20,20)));
		p5.setBorder(BorderFactory.createEtchedBorder());
		p3.setBounds(80,300,400,100);
		p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));
		p4.setBounds(120,450,330,30);

		add(p5);
		add(p3);
		add(p4);
		
		setSize(550,550);
		setLocation(150,80);
		setVisible(true);
		/*	cancel.addActionListener(this);
			
					}
		
                               public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}*/
		tb.addTab("MeterDetails",panel2);
	}
		public static void main(String arg[])
		{
		DatmEnt mch = new DatmEnt("Meter Change");
			mch.setSize(550,550);
			mch.setVisible(true);
	}

}
