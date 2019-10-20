import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.io.*;
import java.awt.event.*;
import java.awt.print.*;
public class SOPforteen7b extends JInternalFrame implements ActionListener
{
	DefaultTableModel tb;
	JTable tab;
	JScrollPane scroll;
	JButton print;
	DefaultTableCellRenderer dtc;
	public SOPforteen7b()
	{
		/*try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception ex)
		{
			System.out.println("Exception in LookAnd Feel");
		}*/
		//this.setOpaque(true);
		setBackground(Color.white);
		dtc= new DefaultTableCellRenderer();
		print = new JButton("   Print   ");
		tb = new DefaultTableModel();
		Font f = new Font("TimesNewRoman",Font.BOLD,30);
		JLabel l1 = new JLabel("SOP 14_VII A");
		l1.setFont(f);
		//tb.addColumn(l1.getText().toString()); 
		JPanel p = new JPanel();
		p.add(l1);
		p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createEmptyBorder(20,20,20,20)));
		tb.addColumn("Consumer Number");
		tb.addColumn("Tariff");
		tb.addColumn("demand");
		tb.addColumn("arrear");
		tb.addColumn("totaldemand");
		tb.addColumn("subsidy");
		tb.addColumn("collection");
		//tb.addColumn("balance");
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:kseb","sa","");
			PreparedStatement pst = con.prepareStatement("select demand.conno,consumer.tariff,demand.demand,demand.previousarrears,demand.netamt,demand.subsidy,sbcollection.amtcollected from consumer,demand,sbcollection where consumer.conno=demand.conno and demand.conno=sbcollection.conno and consumer.tariff='VIIB'");//and consumer.conno=sbcollection.conno
			ResultSet rs=pst.executeQuery();
			Vector v;
			while(rs.next())
			{
				v=new Vector();
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(rs.getString(7));
				//v.addElement(rs.getString(5);
				tb.addRow(v);
			}
			tab=new JTable(tb);
			tab.setPreferredScrollableViewportSize(new Dimension(600,200));

			tab.setRowHeight(25);
			tab.setGridColor(Color.green);
			print.addActionListener(this);
			scroll = new JScrollPane(tab);
			scroll.setOpaque(true);
			scroll.setBackground(Color.white);
		 }
		catch(Exception ex){System.out.println(ex);}
		getContentPane().add(p,BorderLayout.NORTH);
		getContentPane().add(scroll,BorderLayout.CENTER);
		JPanel p1 = new JPanel();
		//p1.setLayout(null);
		//print.setBounds(200,20,50,30);
		p1.add(print,BorderLayout.WEST);
		p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createEmptyBorder(10,10,10,10)));
		getContentPane().add(p1,BorderLayout.SOUTH);
		pack();
	}
	public void actionPerformed(ActionEvent e)
	{	try{
		tab.print();
		}catch(PrinterException ex)
		{
			JOptionPane.showMessageDialog(this,"No Printer Connected");
		}
	}
/*	public static void main(String arg[])throws Exception
	{
		SOPforteen7b  sop147b= new SOPforteen7b();
		sop147b.setVisible(true);
	}*/
}