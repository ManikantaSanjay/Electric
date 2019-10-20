import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

	public class AddUser extends JInternalFrame implements ActionListener
 { 
	JLabel username,pswd1,pswd2 ;
	
	JTextField user_name, pwd1,pwd2;
	JButton ok,cancel;
	Connection con;
	public AddUser(String title)
  	{


		super("USER ADMINISTRATION");
		setLayout(null);
		username=new JLabel("User Name");
		user_name=new JTextField(10);
		//con_no.setPreferredSize(new Dimension(100,20));
		pswd1=new JLabel("Password            ");
		pwd1=new JTextField(10);
		pswd2=new JLabel("Confirm Password    ");
		pwd2=new JTextField(10);
		ok=new JButton("OK");
		cancel=new JButton("Cancel");
		
			JPanel p1,p2;
			p1=new JPanel();
		p1.setLayout(new GridLayout(3,2,5,5));
		p1.add(username);
		p1.add(user_name);
		p1.add(pswd1);
		p1.add(pwd1);		
		p1.add(pswd2);
		p1.add(pwd2);
			p2=new JPanel();
		p2.setLayout(new GridLayout(1,2,15,5));
		p2.add(ok);
		p2.add(cancel);
		
		p1.setBounds(60,30,250,90);
		add(p1);
		
		p2.setBounds(100,130,200,30);
		add(p2);
		setLocation(250,150);
			cancel.addActionListener(this);
			ok.addActionListener(this);
			}
		
             public void actionPerformed(ActionEvent e)
	    {    
		 try{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
			else
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:KSEB","sa","");
				PreparedStatement stmt = con.prepareStatement("select count(*) from users where username=?");
				stmt.setString(1,user_name.getText().trim());
				ResultSet rs =stmt.executeQuery();
				if(rs.next())
				{
					int i = rs.getInt(1);
					if(i>0)
						JOptionPane.showInternalMessageDialog(this,"User Alread Exists  !","Invalid User ",1);
					else
					{
						if(pwd1.getText().equals(pwd2.getText()))
						{
						stmt = con.prepareStatement("insert into users values(?,?,?)");
						stmt.setString(1,user_name.getText().trim());
						stmt.setString(2,pwd1.getText().trim());
						stmt.setString(3,"");
						int j = stmt.executeUpdate();
						if(j>0)
							System.out.println("Added USer");	
						}
						else
						JOptionPane.showInternalMessageDialog(this,"Retype Password  !","Confirm Password ",1);
					}
				}
			}
		}catch(Exception ex){System.out.println(ex);}			
	}
		
		
	

		public static void main(String arg[])
		{
	/*	AddUser au = new AddUser("ADD USER");
			au.setSize(400,250);
			au.setVisible(true);*/
	}

}
