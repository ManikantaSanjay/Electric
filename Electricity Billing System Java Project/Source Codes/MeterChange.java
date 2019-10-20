import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*; 
import javax.swing.border.*;

public class MeterChange extends JInternalFrame implements ActionListener
 { 
	JLabel conno,areacode,mrcode,presentmtrno,newmtrno,maker,maker_new,day,day1,month,month1,year,year1,finalreading,initialreading;
	JComboBox mtr_dgts,mtr_dgts_new,con_no,area_code,mr_code;
	JTextField pre_mtr_no,new_mtr_no,f_r,i_r;
	 JTextArea note;
	JButton ok,edit,cancel;
	
	public MeterChange(String title)
  	{


		super("Meter Change");
		setLayout(null);
		conno=new JLabel("CONSUMER NUMBER");
		con_no=new JComboBox();
		con_no.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("AREACODE");
		String area[] = {"A01","A02","A03","A04","A05","B01","B02","B03","B04","B05"};
		area_code=new JComboBox(area);
		mrcode=new JLabel("Meter Reader Code");
		mr_code=new JComboBox();
		presentmtrno=new JLabel("Present Meter No:");
		pre_mtr_no=new JTextField(10);
		JLabel fr=new JLabel("Final Reading");
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
		

		JPanel p1,p2,p3,p4,p5,p6;

		p1=new JPanel();
	
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();


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
	/*	MeterChange mch = new MeterChange("Meter Change");
			mch.setSize(550,550);
			mch.setVisible(true);*/
	}

}
