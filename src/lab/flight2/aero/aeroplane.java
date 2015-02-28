package aero;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;




public class aeroplane extends Applet implements ActionListener
{

	TextField text1;
	TextField text2;
	TextField text3;
	TextField text4;
	TextField text5;
	TextField text6;
	
	Panel pane;
	
    Label label;
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;
    
	int width;
	
	Button bt;
	Button stop;
	int width1;
	
	Thread delay;
	//Thread my_start=null;
	//boolean flag;
	
	 ReadData read_file=new ReadData();
  	 GetCoordinates xycordinate=new GetCoordinates();
  	 DisplayAircraft displayaircraft=new DisplayAircraft();
  	 
  	ArrayList top=new ArrayList();
   	ArrayList side=new ArrayList();
	ArrayList front=new ArrayList();
	ArrayList plotdata=new ArrayList();
	
	double input1=0,input2=0,input3=0;
	double vx=0,vy=0,vz=0;
	int datalen=0;
	
	int u_max_pixel=1000;
	int v_max_pixel=512;
	
	double width_scaling_factor=1.2;
	double height_scaling_factor=.6;
	
	double max_velocity=250;
	
	public void init()
    {
		 setSize(u_max_pixel,v_max_pixel);
		 pane=new Panel();
		 GridLayout over = new GridLayout(7,2);
		 over.setHgap(2);
		 over.setVgap(5);
		 pane = new Panel(over);
		// add(pane);
		 
		 label=new Label("Angle of Attack--");
		 label1=new Label("Roll Angle-----");
		 label2=new Label("Yaw Angle------");
		 label3=new Label("Velocity XY ---");
		 label4=new Label("Velocity YZ----");
		 label5=new Label("Velocity ZX----");
		   
		 bt=new Button("START");
		 stop=new Button("STOP");
		 
		  stop.addActionListener(this);
		
		    
		 text1=new TextField(15);
		 text1.setText("0");
		 text2=new TextField(15);
		 text2.setText("0");
		 text3=new TextField(15);
		 text3.setText("0");
			
		 text4=new TextField(15);
		 text4.setText("0");
			
		 text5=new TextField(15);
		 text5.setText("0");
			
		 text6=new TextField(15);
		 text6.setText("0");
			
		 pane.add(label);
		 pane.add(text1);
			
		 pane.add(label1);
		 pane.add(text2);
			
		 pane.add(label2);
		 pane.add(text3);
			
		 pane.add(label3);
		 pane.add(text4);
			
		 pane.add(label4);
		 pane.add(text5);
			
		 pane.add(label5);
		 pane.add(text6);
			
		//pane.add(bt);
		 pane.add(stop);
		 delay = new Thread();
		 
		 //pane.setSize(getSize().width, getSize().height);
		
		 
	     
	     if (delay == null) 
	        {  
	            delay.start();   
	        } 
	   
	        top=xycordinate.readTop();
	    	side=xycordinate.readSide();
	     	front=xycordinate.readFront();
	     	plotdata=read_file.readData();     
   
    }

	public void paint(Graphics g)
       {
		
    	double width = getSize().width*width_scaling_factor;
		width1=(int) width;
		double depth= getSize().width*height_scaling_factor;
		int depth1=(int)depth;
		double height=depth;
		int height1=(int)height;
		
	//	pane.setLocation(width1/2+50, 10);
		
		System.out.println("Width---------------"+width1);
		System.out.println("Height--------------"+depth1);
		System.out.println("Depth---------------"+height1);
		
		double fx_origin=width1/4;
	  	double fy_origin=depth1/2+height1/4;
	  
	  	double topx_origin=width1/4;
	  	double topy_origin=depth1/4;
	  
	  	double sidex_origin=width1/2+depth1/4;
	  	double sidey_origin=depth1/2+height1/4;
    		  	 		  	
	  	int top_right_x=width1/2+depth1/2;
	  	int bottom_right_y=depth1/2+height1/2;
	  	int top_middle_x=width1/2; 
	  	int left_middle_y=depth1/2;
   	
	  	int top_view_centerx=width1/4;
	  	int top_view_centery=depth1/4;
   	
	  	int front_view_centerx=width1/4;
	  	int front_view_centery=depth1/2+height1/4;
   	
	  	int side_view_centerx=width1/2+depth1/4;
	  	int side_view_centery=depth1/2+height1/4;
   
   	   	g.drawLine(0, 0,top_right_x , 0);
    	g.drawLine(top_right_x, 0, top_right_x,bottom_right_y );
    	g.drawString("Top View", top_view_centerx-100, 50);
    	g.drawLine(top_right_x,bottom_right_y,0,bottom_right_y);
    	g.drawString("Front View", top_view_centerx-100,left_middle_y+50 );
    	g.drawLine(0,bottom_right_y, 0, 0);
    	g.drawString("Side View",top_middle_x+100,left_middle_y+50 );
    	g.drawLine(top_middle_x ,0 ,top_middle_x, bottom_right_y);
    	g.drawLine( 0,left_middle_y ,top_right_x,left_middle_y);
    	  
    	drawCenterLine(g,top_view_centerx,top_view_centery,front_view_centerx,front_view_centery,side_view_centerx,side_view_centery); 
    	
       	datalen=plotdata.size();
    	displayaircraft.static_aircraft_plot(g,top,side,front,fx_origin,fy_origin,topx_origin,topy_origin,sidex_origin,sidey_origin);
    	 
		  for(int a=0;a<datalen;a++)
		   {		 
				
			  Value v=(Value) plotdata.get(a);
				 
				 input1=v.getX();
				 input2=v.getY();
				 input3=v.getZ();
				 vx=v.getVx();
				 vy=v.getVy();
				 vz=v.getVz();
			 
				try
				 { 
				
				
				 displayaircraft.dynamic_aircraft_plot(g,width1,max_velocity,top,side,front,fx_origin,fy_origin,topx_origin,topy_origin,sidex_origin,sidey_origin,input1,input2,input3,vx,vy,vz);
				 SetText(input1,input2,input3,vx,vy,vz);
				 drawCenterLine(g,top_view_centerx,top_view_centery,front_view_centerx,front_view_centery,side_view_centerx,side_view_centery);
				 delay.sleep(100);  
				
				 } 
				
			    catch (InterruptedException e) 
			     {  
			       e.printStackTrace();  
			     }  

			 }
		  
    	 SetText(0,0,0,0,0,0);
		 displayaircraft.static_aircraft_plot(g,top,side,front,fx_origin,fy_origin,topx_origin,topy_origin,sidex_origin,sidey_origin);	 
		 // System.exit(0);
       }
	
    public void drawCenterLine(Graphics g,int top_view_centerx,int top_view_centery,int front_view_centerx,int front_view_centery,int side_view_centerx,int side_view_centery)   
    {
    	g.setColor(Color.black);
		g.drawLine( top_view_centerx-100, top_view_centery,  top_view_centerx+100, top_view_centery);
	    g.drawLine(front_view_centerx-100, front_view_centery, front_view_centerx+100,front_view_centery);
	    g.drawLine(side_view_centerx-100, side_view_centery, side_view_centerx+100,side_view_centery);
    }
	
    public void SetText(double txt1,double txt2,double txt3,double txt4,double txt5,double txt6)
    {
    	 text1.setText(String.valueOf(txt1));
		 text2.setText(String.valueOf(txt2));
		 text3.setText(String.valueOf(txt3));
		 text4.setText(String.valueOf(txt4));
		 text5.setText(String.valueOf(txt5));
		 text6.setText(String.valueOf(txt6));
    }
     
    public void start()
     {
    	System.out.println("Start method calleddddddddddddddddd.................");
    	// setVisible(true);
     }
    public void stop()
    {
    	System.out.println("Stop method calleddddddddddddddddd.................");
    	// flag=true;
    	// my_start=null;
    	// setVisible(false);
    	 System.exit(0);
    }
    
  public void actionPerformed(ActionEvent ae)
       {
    	
	    Button source = (Button)ae.getSource();
    	System.out.println(source+"---------------------"+source.getLabel());
        
    		if(source.getLabel().equalsIgnoreCase("Stop"))
         {
        	 System.out.println("In stop method..................");
        	 
        	// System.exit(0);
        	 stop();
         }
       }

       }

        


