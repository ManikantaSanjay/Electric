import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class ConnectedLoadChange extends JInternalFrame implements ActionListener
 { 
	JLabel conno,areacode,cl,prcl,chcl;
	JComboBox con_no;
	JTextField pr_cl,ch_cl,area_code;
	JButton ok,edit,cancel;
	
	public ConnectedLoadChange(String title)
  	{


		super("ConnectedLoadChange");
		setLayout(null);
		conno=new JLabel("CONSUMER NUMBER");
		try{
			QueryData qd = new QueryData();
			Vector v = qd.getConsumer(); 
			con_no=new JComboBox(v);
			}
			catch(Exception ex)
			{System.out.println("Error in DataEnt " + ex);}
		
	
		con_no.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("AREACODE");
		
		String area[]={"A01","A02","A03","A04","A05","A06","A07","A08","A09","A10","A11","A12","A13","A14","A15","A16","A17","A18","A19","A20","A21","A22","A23","A24","A25","B01","B02","B03","B04","B05","B06","B07","B08","B09","B10","B11","B12","B13","B14","B15","B16","B17","B18","B19","B20","B21","B22","B23","B24","B25"};

		area_code=new JTextField(5);
		area_code.setEditable(false);
		prcl=new JLabel("Present Connected Load");
		pr_cl=new JTextField(10);
		pr_cl.setEditable(false);
		chcl=new JLabel("Connected Load Changed to");
		ch_cl=new JTextField(10);
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

		p1.setLayout(layout);
		p2.setLayout(new GridLayout(2,2,10,10));
	
		p1. add(conno);
		p1.add(con_no);
		p1.add(areacode);
		p1.add(area_code);
		p1.add(new JLabel("Choose an Area Code and Consumer Number"));
		p1.setPreferredSize(new Dimension(380,70));
		p2.add(prcl);
		p2.add(pr_cl);
		p2.add(chcl);
		p2.add(ch_cl);

		/*p3.add(new JLabel("Note  :"));
		p3.add(note);*/

		p4.add(ok);
		//p4.add(edit);
		p4.add(cancel);
		
		p5.add(p1);
		p5.add(p2);

		p5.setBounds(80,100,400,160);
		//p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(20,20,20,20)));
		p5.setBorder(BorderFactory.createEtchedBorder());
		p3.setBounds(80,270,400,100);
		p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));
		p4.setBounds(120,300,300,35);

		add(p5);
		//add(p3);
		add(p4);
		
		setSize(550,550);
		setLocation(150,80);
		setVisible(true);
		
		cancel.addActionListener(this);
		con_no.addActionListener(this);
		ok.addActionListener(this);
		}	
		
		public void actionPerformed(ActionEvent e)
		{
			try{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
		
		                   else if(e.getSource()==con_no)
			{
				System.out.println("Selected ocnsumer NO");
				

					
					QueryData qd = new QueryData();
					String id=(String)con_no.getSelectedItem();
					Vector v8 = qd.getConsumerDetails(id.trim()); 
					//Vector v9=qd.get
					System.out.println("Consumer Details  " + v8);
					System.out.println(id + "Tc " + v8 );
					Enumeration em=v8.elements();
					area_code.setText((String)em.nextElement());	
					String cl=qd.getCldetails(id);
					if(cl!=null)
						pr_cl.setText(cl);
					
			
			}
			else if(e.getSource()==ok)
			{
				
				
				System.out.println("OK");
                                                                             QueryData qd = new QueryData();
				Connection con = qd.getConnect();
					//update consumer set connectedload ='1922' where conno='10'
				PreparedStatement st =con.prepareStatement("update consumer set connectedload=?  where consumer.conno=?");
				//st.setString(1,"500");
				//st.setString(2,"10");
				st.setString(1,(String)ch_cl.getText());
				st.setString(2,(String)con_no.getSelectedItem());
				
				int i=st.executeUpdate();
				if(i>0)
				System.out.println("Updated  ");
				JOptionPane.showInternalMessageDialog(this,"Connected Load Changed","CONNECTED LOAD ",1);
				
				
			}
		}catch(Exception ex){System.out.println("Error in Tc" + ex);}
	}
	
		
}