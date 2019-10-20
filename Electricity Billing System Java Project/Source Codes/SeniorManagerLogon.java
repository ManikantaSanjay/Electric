import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class SeniorManagerLogon extends JFrame implements ActionListener
 { 
	JMenuBar mb;
	JMenu file,ca,report,csd,cd,dmd,csh;
	JMenuItem user,cpwd,exit,tc,woa,addcon,cln,acdcln,acd,modifycon,clc,nc,vc,vb,mc,vd,dw,id,cdaj,acdaj,adj,adv,DatEnt,DatView,acdrep,colln,sop14,sop141a,sop142,sop143,sop144,sop145,sop146a,sop146b,sop146c,sop146d,sop147a,sop147b,sop147c,sop148;
	Connection con;
	PreparedStatement stat;
  	JDesktopPane desktop;
	public SeniorManagerLogon(String title)
  	{

		super("   L  T  BILLING  ");
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception ex)
		{
			System.out.println("Exception in LookAnd Feel");
		}
		String category=title;
		desktop = new JDesktopPane();
		mb = new JMenuBar();
		file = new JMenu("OfficeAdministraton  ");
		user = new JMenuItem("Add User");
		cpwd = new JMenuItem("Change Password");
		exit = new JMenuItem("Exit");
		file.add(user);
		file.add(cpwd);
		file.addSeparator();
		file.add(exit);

		ca = new JMenu("  ConsumerAdministration   ");
		nc = new JMenuItem("Add / Edit Consumer");
		//addcon = new JMenuItem("Add New Consumer");
		//nc.add(addcon);
		vc = new JMenuItem("View Consumer Status");
		vb = new JMenuItem("View Bill details");
		
		//csd.add(modifycon);
		
		//mc = new JMenuItem("MeterChange");
		tc = new JMenuItem("Change Tariff");
		clc = new JMenuItem("Connected Load Change");
		cd = new JMenu("Cash Deposit ");
		
			cdaj=new JMenuItem("C D adjustment");
			acdaj=new JMenuItem("A C D");
			id = new JMenuItem("Intrest on deposit");
		cd.add(cdaj);
		cd.add(acdaj);
		cd.add(id);
		woa = new JMenuItem("WalkOrderAssignment");
	//	DatEnt=new JMenuItem("Entering new consuer");
	//	DatView=new JMenuItem("View a consuer");
		ca.add(nc);
		ca.add(vc);
		ca.add(vb);
	//	ca.add(mc);
		ca.add(tc);
		ca.add(clc);
		ca.add(cd);
		ca.add(woa);
		//ca.add(DatEnt);
		//ca.add(DatView);
		dmd=new JMenu("   Demand   ");
	vd = new JMenuItem("Generate/edit Demand ");
	dw = new JMenuItem("Demand Withdrawal");
	adj = new JMenuItem("Demand Adjustments");
	adv = new JMenuItem("Advance payment");
		dmd.add(vd);
		dmd.add(dw);
		dmd.add(adj);
		dmd.add(adv);

	     csh=new JMenu("   CASH   ");
	     cln = new JMenuItem("Spot Bill Collection ");
	     csh.add(cln);
	     acdcln=new JMenuItem("ACD Collection ");
	     csh.add(acdcln);
		report = new JMenu("  Report ");
		acdrep=new JMenuItem("ACD Collection Report");
		colln=new JMenuItem("Spot Bill Collecton Report");
		sop14=new JMenu("Spot Bill Collecton Report");

			sop141a=new JMenuItem("SOP 14 - IA");
			sop142=new JMenuItem("SOP 14 - II");
			sop143=new JMenuItem("SOP 14 - III");
			sop144=new JMenuItem("SOP 14 - IV");
			sop145=new JMenuItem("SOP 14 - V");
			sop146a=new JMenuItem("SOP 14 - VI A");
			sop146b=new JMenuItem("SOP 14 - VI B");
			sop146c=new JMenuItem("SOP 14 - VI C");
			sop146d=new JMenuItem("SOP 14 - VI D");
			sop147a=new JMenuItem("SOP 14 - VII A");
			sop147b=new JMenuItem("SOP 14 - VII B");
			sop147c=new JMenuItem("SOP 14 - VII C");
			sop148=new JMenuItem("SOP 14 - VIII ");
			
			
		sop14.add(sop141a);
		sop14.add(sop142);
		sop14.add(sop143);
		sop14.add(sop144);
		sop14.add(sop145);
		sop14.add(sop146b);
		sop14.add(sop146a);
		sop14.add(sop146c);
		sop14.add(sop146d);
		sop14.add(sop147a);
		sop14.add(sop147b);
		sop14.add(sop147c);
		sop14.add(sop148);
		
		mb.add(file);
		mb.add(ca);
		mb.add(dmd);
		mb.add(csh);
		mb.add(report);
		report.add(acdrep);
		report.add(colln);
		report.add(sop14);
		
		setJMenuBar(mb);
		desktop.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(700,0,0,0,new ImageIcon("pictures/peace.jpg")),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		getContentPane().add(desktop,BorderLayout.CENTER);
		
		user.addActionListener(this);
		cpwd.addActionListener(this);
		
		nc.addActionListener(this);
		vc.addActionListener(this);
		
		vb.addActionListener(this);
	//	mc.addActionListener(this);
		tc.addActionListener(this);
		clc.addActionListener(this);
/*---*/ cdaj.addActionListener(this); 
		acdaj.addActionListener(this);
		id.addActionListener(this);
		
		
		vd.addActionListener(this);
		dw.addActionListener(this);
		adj.addActionListener(this);
		adv.addActionListener(this);	
		cln.addActionListener(this);	
		acdcln.addActionListener(this);
		acdrep.addActionListener(this);
		colln.addActionListener(this);
		sop141a.addActionListener(this);
		sop142.addActionListener(this);
		sop143.addActionListener(this);			
		sop144.addActionListener(this);
		sop145.addActionListener(this);
		sop146a.addActionListener(this);
		sop146b.addActionListener(this);
		sop146c.addActionListener(this);
			sop146d.addActionListener(this);
			sop147a.addActionListener(this);
		sop147b.addActionListener(this);
		sop147c.addActionListener(this);
		sop148.addActionListener(this);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		if(category.equals(""))
		{
			// button enable
			// button disable
		}
		else if(category.equals(""))
		{

		}
		}
		public void actionPerformed(ActionEvent e)
		{
		

			if(e.getSource() == nc)
			{
			DatEnt de=new DatEnt("Add / Edit Consumer");
			desktop.add(de);
			de.setVisible(true);
		                 de.setSize(750,500);
			}  
			
			else if(e.getSource() == user)
			{
			AddUser au = new AddUser("ADD USER");
			desktop.add(au);
			au.setSize(400,250);
			//setLocation(400,400);
			au.setVisible(true);	
			}
			else if(e.getSource() == cpwd)
			{
			Chpwd chp= new Chpwd("CHANGE PASSWORD");
			desktop.add(chp);
			chp.setSize(420,270);
			chp.setVisible(true);
			}

			else if(e.getSource() == vc)
			{
			DatView dv=new DatView("View Consumer Status");
			desktop.add(dv);
			dv.setVisible(true);
		                 dv.setSize(750,500);
			}
			
			else if(e.getSource() == vb)
			{
			Billdetails bd = new Billdetails("BILL DETAILS");
			desktop.add(bd);
			bd.setVisible(true);
			bd.setSize(900,550);
				
			}
			
			
			
			
			/*else if(e.getSource() == mc)
			{
					MeterChange mch = new MeterChange("Meter Change");
					desktop.add(mch);
					mch.setSize(550,550);
					mch.setVisible(true);
			}*/
			
			
			
			else if(e.getSource() == tc)
			{
			TariffChange w = new TariffChange("Tariff Change");
			desktop.add(w);
			w.setVisible(true);
	        		w.setSize(600,550);
			}
			
			else if(e.getSource() == clc)
			{
			ConnectedLoadChange clch = new ConnectedLoadChange("ConnectedLoadChange");
			desktop.add(clch);
			clch.setSize(550,550);
			clch.setVisible(true);	
			}
	//-----------------------------------------------------------------------------		
			else if(e.getSource() == cdaj)
			{
			Cdadj cdad = new Cdadj("C D Adjustment");
			desktop.add(cdad);
			cdad.setSize(600,550);
			cdad.setVisible(true);
			}
  			else if(e.getSource() == acdaj)
			{
			Acd acd = new Acd("Addl: C.D");
			desktop.add(acd);
			  acd.setSize(400,550);
			 acd.setVisible(true);
			}
			else if(e.getSource()==id)
			{
			IntrestonDeposit id = new IntrestonDeposit("Intrest on Deposit");
			desktop.add(id);
                                                    id.setSize(550,550);
			id.setVisible(true);
			}	

 //--------------------------------------------------------------------------------			
			else if(e.getSource() == vd)
			{
		
			Demand d = new Demand("DEMAND");
			desktop.add(d);
			d.setSize(880,550);
			d.setVisible(true);
			}
			else if(e.getSource() == dw)
			{

					DemandWithdrawal wid = new DemandWithdrawal("Demand Withdrawal");
					desktop.add(wid);
					wid.setSize(550,550);
					wid.setVisible(true);
			}
			
			else if(e.getSource()==adj)
				{
			
			    Ccadj cadj = new Ccadj("Current Charge Adjustment");
			    desktop.add(cadj);
				cadj.setSize(600,550);
				cadj.setVisible(true);
				}
				
			else if(e.getSource()==adv)
			{
				Ccadv ccad = new Ccadv("ADVANCE PAYMENT");
				desktop.add(ccad);
				ccad.setSize(400,550);
				ccad.setVisible(true);
			}
			
				else if(e.getSource()==cln)
			{
				Collection c = new Collection("COLLECTION");
				desktop.add(c);
				c.setSize(400,550);
				c.setVisible(true);
			}

			else if (e.getSource()==acdcln)
			{
			System.out.println("Entered ACDC");
			AcdCollection acdc = new AcdCollection(" ACD COLLECTION WINDOW");
			desktop.add(acdc);
			acdc.setSize(450,550);
			acdc.setVisible(true);
			}
			else if (e.getSource()==acdrep)
			{
			System.out.println("Entered ACDreport");
			ACDReport acdr= new ACDReport();
			desktop.add(acdr);
			acdr.setSize(600,550);
			acdr.setVisible(true);
			}

			else if (e.getSource()==colln)
			{
			System.out.println("Entered collection report");
			SBcollection sb = new SBcollection();
		
			desktop.add(sb);
			sb.setSize(600,550);
			sb.setVisible(true);
			}
			
				else if (e.getSource()==sop141a)
			{
			System.out.println("Entered sop141a report");
			SOPforteen sop14a= new SOPforteen();
		
			desktop.add(sop14a);
			//sop14a.setSize(600,550);
			sop14a.setVisible(true);
			}
			
			
				else if (e.getSource()==sop142)
			{
			System.out.println("Entered sop142 report");
			SOPforteen2a sop142= new SOPforteen2a();
		
			desktop.add(sop142);
			//sop14a.setSize(600,550);
			sop142.setVisible(true);
			}
			
				else if (e.getSource()==sop143)
			{
			System.out.println("Entered sop143 report");
			SOPforteen3 sop143= new SOPforteen3();
		
			desktop.add(sop143);
			//sop14a.setSize(600,550);
			sop143.setVisible(true);
		   }
		   
		   	else if (e.getSource()==sop144)
			{
			System.out.println("Entered sop144 report");
			SOPforteen4 a= new SOPforteen4();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		   
		   else if (e.getSource()==sop145)
			{
			System.out.println("Entered sop145 report");
			SOPforteen5 a= new SOPforteen5();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		   
		    else if (e.getSource()==sop146a)
			{
			System.out.println("Entered sop146a report");
			SOPforteen6a a= new SOPforteen6a();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		    else if (e.getSource()==sop146b)
			{
			System.out.println("Entered sop146b report");
			SOPforteen6b a= new SOPforteen6b();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		    else if (e.getSource()==sop146c)
			{
			System.out.println("Entered sop146c report");
			SOPforteen6c a= new SOPforteen6c();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		   
		   else if (e.getSource()==sop146d)
			{
			System.out.println("Entered sop146d report");
			SOPforteen6d a= new SOPforteen6d();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		   
		   else if (e.getSource()==sop147a)
			{
			System.out.println("Entered sop147a report");
			SOPforteen7a a= new SOPforteen7a();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		   else if (e.getSource()==sop147b)
			{
			System.out.println("Entered sop147b report");
			SOPforteen7b a= new SOPforteen7b();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		   
		   else if (e.getSource()==sop147c)
			{
			System.out.println("Entered sop147c report");
			SOPforteen7c a= new SOPforteen7c();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		   
		   else if (e.getSource()==sop148)
			{
			System.out.println("Entered sop148 report");
			SOPforteen8 a= new SOPforteen8();
		
			desktop.add(a);
			//sop14a.setSize(600,550);
			a.setVisible(true);
		   }
		  } 	
		public static void main(String arg[])
		{
			SeniorManagerLogon ss = new SeniorManagerLogon("gf");
			Toolkit tool = Toolkit.getDefaultToolkit();
							Dimension d = tool.getScreenSize();
							ss.setSize((int)d.getWidth(),(int)d.getHeight());
							//ss.setOpaque(true);
							//ss.setDragEnabled(false);
							ss.setBackground(Color.white);
							ss.setVisible(true);
							//.setVisible(false);
		}
		
}
		
		
