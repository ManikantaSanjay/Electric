import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class WalkOrder extends JFrame implements ActionListener
{
	JComboBox area_code,day_code,mtr_code,con_no;
	JList con1,con2;
	JButton cancel;
	
	public WalkOrder(String title)

	{
	
	JLabel areacode=new JLabel("Area Code");
	String area[] = {"A01","A02","A03","A04","A05","B01","B02","B03","B04","B05"};
	area_code=new JComboBox(area);

	JLabel mtrcode=new JLabel("Meter Reader Code");
	String mtrcd[]={"1","2","3","4","5","6","7","8"};
	mtr_code=new JComboBox(mtrcd);
	JLabel conno=new JLabel("Consumer No:");
	con_no=new JComboBox();
	
	
	con1=new JList("In numeric order");
	con2=new JList("In Waking order");
	cancel=new JButton("cancel");
	
	JPanel p1=new JPanel();
	p1.setLayout(new GridLayout(1,3,0,0));
	
	p1.add(areacode);
		p1.add(area_code);
		p1. add(mtrcode);
		p1.add(mtr_code);
		p1. add(conno);
	    p1.add(con_no);		
		p1.setBounds(80,100,250,60);
		add(p1);
		
		 	setLocation(250,70);
     		     
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
			WalkOrder wo = new WalkOrder("WALK ORDER ASSIGNMENT");
		wo.setSize(400,550);
			wo.setVisible(true);
	}

}
