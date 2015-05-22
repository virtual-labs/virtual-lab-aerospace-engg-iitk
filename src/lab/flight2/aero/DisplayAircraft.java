package aero;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DisplayAircraft 
{
	double input1=0,input2=0,input3=0;
	double vx=0,vy=0,vz=0;
	 int length_top=0,length_side=0,length_front=0;
	 int max= 200;
	 
	 double new_x[]=new double[max];
	 double new_y[]=new double[max];
	 
	 double new_x1[]=new double[max];
 	 double new_y1[]=new double[max];
 	
 	 double new_x2[]=new double[max];
 	 double new_y2[]=new double[max];
	  
	 double xt[]=new double[max];
	 double yt[]=new double[max];
	  
	 double xs[]=new double[max];
	 double ys[]=new double[max];
	  
	 double xf[]=new double[max];
	 double yf[]=new double[max];
	     	
	 int int_tx[]=new int[max];
	 int int_ty[]=new int[max];
	  
	 int int_sx[]=new int[max];
	 int int_sy[]=new int[max];
	  
	 int int_fx[]=new int[max];
	 int int_fy[]=new int[max];
	  	
	 double sf=50;
	 
	public void static_aircraft_plot(Graphics g,ArrayList top,ArrayList side,ArrayList front,double fx_origin,double fy_origin,double topx_origin,double topy_origin,double sidex_origin,double sidey_origin) 
	{   
		length_top=top.size();
		length_side=side.size();
		length_front=front.size();
     
		g.setColor(Color.white);
		g.fillPolygon(int_tx,int_ty,length_top);
		g.fillPolygon(int_sx,int_sy,length_side);
		g.fillPolygon(int_fx,int_fy,length_front);
   	
  	 for(int i=0,j=0;i<top.size();i=i+2,j++)
		{
		Value v=(Value) top.get(i);
		
		xt[j]=v.getX()*sf;
		yt[j]=-v.getY()*sf;
		}

	    	 
    for(int i=0,j=0;i<side.size();i=i+2,j++)
		{
		Value v=(Value) side.get(i);
				
		xs[j]=v.getX()*sf;
		ys[j]=v.getY()*sf;
		
		}
    
    for(int i=0,j=0;i<front.size();i=i+2,j++)
		{
		Value v=(Value) front.get(i);
		
		xf[j]=v.getX()*sf;
		yf[j]=v.getY()*sf;
		
		}
    
    for(int i=0;i<length_top;i++)//Top view
		{
		 int_tx[i]=(int)yt[i]+(int)topx_origin;
		 int_ty[i]=(int)topy_origin+(int)xt[i];
		}
	 
	
	 for(int i=0;i<length_side;i++)//Side view
		{
			int_sx[i]=(int)sidex_origin-(int)xs[i];
			int_sy[i]=(int)sidey_origin+(int)ys[i];
		}
	 for(int i=0;i<length_front;i++)//Front View
		{
			int_fx[i]=(int)xf[i]+(int)fx_origin;
			int_fy[i]=(int)fy_origin+(int)yf[i];
		}
	 
	 
	  	 g.setColor(Color.red);
     
		 g.fillPolygon(int_tx,int_ty,length_top);
		 g.fillPolygon(int_sx,int_sy,length_side);
		 g.fillPolygon(int_fx,int_fy,length_front);
	
	}
	
	
	public void dynamic_aircraft_plot(Graphics g,int width1,double max_velocity,ArrayList top,ArrayList side,ArrayList front,double fx_origin,double fy_origin,double topx_origin,double topy_origin,double sidex_origin,double sidey_origin,double input1,double input2,double input3,double vx,double vy,double vz) 
	{ 
		
		g.setColor(Color.white);
		g.fillPolygon(int_tx,int_ty,length_top);
		g.fillPolygon(int_sx,int_sy,length_side);
		g.fillPolygon(int_fx,int_fy,length_front);
	
		double pixel_per_meter=100/max_velocity;
				
		double distance_along_x=vx*pixel_per_meter;
		double distance_along_y=vy*pixel_per_meter;
		double distance_along_z=vz*pixel_per_meter;
		
		/*System.out.println("pixel_per_meter"+pixel_per_meter);
		System.out.println("vx:"+vx);
		System.out.println("vy:"+vy);
		System.out.println("Distance along x-------------" +distance_along_x);
		System.out.println("Distance along y-------------"+distance_along_y);*/
		
		//System.out.println("inc_z--------inc_z2-------"+inc_z+" "+inc_z2);
		
		
		int inc_x=0;
		int inc_y=0;
		int inc_z=0;
		
		/*int inc_x=width1*(int)vx/max_velocity/10;		
		int inc_y=width1*(int)vy/max_velocity/10;	
		int inc_z=width1*(int)vz/max_velocity/10;*/	
		
		/*System.out.println("inc_x--------inc_x2-------"+inc_x+" "+inc_x2);
		System.out.println("inc_y--------inc_y-------"+inc_y+" "+inc_y2);
		System.out.println("inc_z--------inc_z2-------"+inc_z+" "+inc_z2);
		*/
		
		double alpha=(input1*Math.PI)/180;//Angle of Attack
		double theta=(input2*Math.PI)/180;//Yaw Angle
		double phi=(input3*Math.PI)/180;//Roll Angle/
		
		/*
		System.out.println("alpha---------------"+alpha);
		System.out.println("theta---------------"+theta);
		System.out.println("phi---------------"+phi);*/
		
		
				
		//*******************************Top view with Yaw angle********************************************
	  	
	  	
		double ct=Math.cos(theta);
		double st=Math.sin(theta);
		 for(int i=0;i<length_top;i++)
			{
			 new_x2[i]=yt[i]*ct-xt[i]*st;
			 new_y2[i]=yt[i]*st+xt[i]*ct;
				 
			// System.out.println("x2 and y2 theta yt xt ========================="+new_x2[i]+" "+new_y2[i]+" "+theta+" "+yt[i]+" "+xt[i]);
				
			}
		 
		 //&&&&&&&&&&&&&&&&&&&&&&& Translation&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		 
		 for(int i=0;i<length_top;i++)
			{
			  	inc_x=(int)vy/2;
			    inc_y=(int)vx/2;
				
				/*for(int k=0;k<5;k++)
				{
					*/
					 g.setColor(Color.white);
					 g.fillPolygon(int_tx,int_ty,length_top);
					 
					 int uu=(int)new_x2[i]+(int)distance_along_y;
					 int vv=(int)new_y2[i]+(int)distance_along_x;
					 /*int uu=(int)new_x2[i]+inc_x;
					 int vv=(int)new_y2[i]+inc_y;*/
					 
					 int_tx[i]=(int)topx_origin+uu;
					 int_ty[i]=(int)topy_origin+vv;
					 
					 
					 
					 g.setColor(Color.red);
					 g.fillPolygon(int_tx,int_ty,length_top);
				 //	}
			
			}
		
		

		
		 
		//************************Side View************************************************** 
		    double ca=Math.cos(-alpha);
			double sa=Math.sin(-alpha);
		 
		 for(int i=0;i<length_side;i++)
			{
			 new_x[i]=xs[i]*ca-ys[i]*sa;
			 new_y[i]=xs[i]*sa+ys[i]*ca;
			}
		 
		 //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Translation&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		 for(int i=0;i<length_side;i++)
			{
							
			    inc_x=(int)vx/2;
			    inc_z=(int)vz/2;
			
				/*for(int k=0;k<5;k++)
				{*/
					
				 g.setColor(Color.white);
				 g.fillPolygon(int_sx,int_sy,length_side);
				 
				 int uu=(int)new_x[i]+(int)distance_along_x;
				 int vv=(int)new_y[i]-(int)distance_along_z;
				 
				// int uu=(int)new_x[i]+inc_x;
				// int vv=(int)new_y[i]-inc_z;
				 
				 int_sx[i]=(int)sidex_origin-uu;
				 int_sy[i]=(int)sidey_origin+vv;
				 
				
				 g.setColor(Color.red);
				 g.fillPolygon(int_sx,int_sy,length_side);
			//  }
			}
		
		 
		
		 
	//**************************Change in Front view with Roll Angle********************************
		   double cp=Math.cos(-phi);
		   double sp=Math.sin(-phi);
			
		 for(int i=0;i<length_front;i++)//front view
			{
			 
			 new_x1[i]=xf[i]*cp-yf[i]*sp;
			 new_y1[i]=xf[i]*sp+yf[i]*cp;
			 
			}
		 
		 //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Translation&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		 for(int i=0;i<length_front;i++)
			{
			    inc_y=(int)vy/2;
			    inc_z=(int)vz/2;		
			
			/*for(int k=0;k<5;k++)
			{*/
	
			 g.setColor(Color.white);
			 g.fillPolygon(int_fx,int_fy,length_front);
			 
			// int uu=(int)new_x1[i]+inc_y;
			// int vv=(int)new_y1[i]-inc_z;
			 
			 int uu=(int)new_x1[i]+(int)distance_along_y;
			 int vv=(int)new_y1[i]-(int)distance_along_z;
			 
			 int_fx[i]=(int)fx_origin+uu;
			 int_fy[i]=(int)fy_origin+vv;
			 
			
			 g.setColor(Color.red);
			 g.fillPolygon(int_fx,int_fy,length_front);
		   // }
			}


}
	/*public void dynamic_Aircraft_Plot(Graphics g,int width1,int max_velocity,ArrayList plotdata,ArrayList top,ArrayList side,ArrayList front,double fx_origin,double fy_origin,double topx_origin,double topy_origin,double sidex_origin,double sidey_origin)
	{
		int datalen=plotdata.size();
    	
    		 
		  for(int a=0;a<datalen;a++)
			 {		 
				
			  Value v=(Value) plotdata.get(a);
				 
				 input1=v.getX();
				 input2=v.getY();
				 input3=v.getZ();
				 vx=v.getVx();
				 vy=v.getVy();
				 vz=v.getVz();
				 
				 int inc_x=0;
					int inc_y=0;
					int inc_z=0;
					
					int inc_x=width1*(int)vx/max_velocity/10;		
					int inc_y=width1*(int)vy/max_velocity/10;	
					int inc_z=width1*(int)vz/max_velocity/10;	
					 
					System.out.println("inc_x--------inc_x2-------"+inc_x+" "+inc_x2);
					System.out.println("inc_y--------inc_y-------"+inc_y+" "+inc_y2);
					System.out.println("inc_z--------inc_z2-------"+inc_z+" "+inc_z2);
					
					
					double alpha=(input1*Math.PI)/180;//Angle of Attack
					double theta=(input2*Math.PI)/180;//Yaw Angle
					double phi=(input3*Math.PI)/180;//Roll Angle/
					
					
					System.out.println("alpha---------------"+alpha);
					System.out.println("theta---------------"+theta);
					System.out.println("phi---------------"+phi);
					
					g.setColor(Color.white);
					g.fillPolygon(int_tx,int_ty,length_top);
					g.fillPolygon(int_sx,int_sy,length_side);
					g.fillPolygon(int_fx,int_fy,length_front);
					 
					
					//*******************************Top view with Yaw angle********************************************
				  	
				  	
					double ct=Math.cos(theta);
					double st=Math.sin(theta);
					 for(int i=0;i<length_top;i++)
						{
						 new_x2[i]=yt[i]*ct-xt[i]*st;
						 new_y2[i]=yt[i]*st+xt[i]*ct;
							 
						// System.out.println("x2 and y2 theta yt xt ========================="+new_x2[i]+" "+new_y2[i]+" "+theta+" "+yt[i]+" "+xt[i]);
							
						}
					 
					 //&&&&&&&&&&&&&&&&&&&&&&& Translation&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
					 
					 for(int i=0;i<length_top;i++)
						{
						 			
						 	inc_x=(int)vy/2;
						    inc_y=(int)vx/2;
							
							for(int k=0;k<5;k++)
							{
								
								 g.setColor(Color.white);
								 g.fillPolygon(int_tx,int_ty,length_top);
								 
								 int xx=(int)new_x2[i]+inc_x;
								 int yy=(int)new_y2[i]+inc_y;
								 
								 int_tx[i]=(int)topx_origin+xx;
								 int_ty[i]=(int)topy_origin+yy;
								 					
								 g.setColor(Color.red);
								 g.fillPolygon(int_tx,int_ty,length_top);
							 //	}
						
						}
					
					

					
					 
					//************************Side View************************************************** 
					    double ca=Math.cos(-alpha);
						double sa=Math.sin(-alpha);
					 
					 for(int i=0;i<length_side;i++)
						{
						 new_x[i]=xs[i]*ca-ys[i]*sa;
						 new_y[i]=xs[i]*sa+ys[i]*ca;
						}
					 
					 //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Translation&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
					 for(int i=0;i<length_side;i++)
						{
										
						    inc_x=(int)vx/2;
						    inc_z=(int)vz/2;
						
							for(int k=0;k<5;k++)
							{
								
							 g.setColor(Color.white);
							 g.fillPolygon(int_sx,int_sy,length_side);
							 
							 int xx=(int)new_x[i]+inc_x;
							 int yy=(int)new_y[i]-inc_z;
							 
							 int_sx[i]=(int)sidex_origin-xx;
							 int_sy[i]=(int)sidey_origin+yy;
							 
							
							 g.setColor(Color.red);
							 g.fillPolygon(int_sx,int_sy,length_side);
						//  }
						}
					
					 
					
					 
				//**************************Change in Front view with Roll Angle********************************
					   double cp=Math.cos(-phi);
					   double sp=Math.sin(-phi);
						
					 for(int i=0;i<length_front;i++)//front view
						{
						 
						 new_x1[i]=xf[i]*cp-yf[i]*sp;
						 new_y1[i]=xf[i]*sp+yf[i]*cp;
						 
						}
					 
					 //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Translation&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
					 for(int i=0;i<length_front;i++)
						{
						    inc_y=(int)vy/2;
						    inc_z=(int)vz/2;		
						
						for(int k=0;k<5;k++)
						{
				
						 g.setColor(Color.white);
						 g.fillPolygon(int_fx,int_fy,length_front);
						 
						 int xx=(int)new_x1[i]+inc_y;
						 int yy=(int)new_y1[i]-inc_z;
						 
						 int_fx[i]=(int)fx_origin+xx;
						 int_fy[i]=(int)fy_origin+yy;
						 
						
						 g.setColor(Color.red);
						 g.fillPolygon(int_fx,int_fy,length_front);
					   // }
						}
				
				
			 }
			  
	}*/
}
