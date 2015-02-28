package aero;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetCoordinates
{
	public ArrayList readTop()
	  {
	    ArrayList art=new ArrayList();
	
	    try
	 
	    {
		    
		    FileInputStream fstream = new FileInputStream("D:/draw/TOP2.txt");
		    System.out.println("---------------------------------------------------------------------------------------------------------------------");
		   // System.out.println("Reading Top view data");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    while ((strLine = br.readLine()) != null) 
		    {
		    	
		    	//System.out.println (strLine);
		    	String str[]=strLine.split(",");
		    	double x=Double.parseDouble(str[0]);
		    	double y=Double.parseDouble(str[1]);
		    	
		    //	System.out.println("Value of x,y=========="+x+""+y);
		    	Value vt=new Value();
		    	vt.setX(x);
		    	vt.setY(y);
		    	art.add(vt);
		    	
		    }
		 
		    
		    in.close();
		    }
	 catch (Exception e)
	 {
		      System.err.println("Error: " + e.getMessage());
		    }
	 return art;
	  }
	
	
	public ArrayList readSide()
	  {
	    ArrayList arf=new ArrayList();
	
	    try
	 
	    {
		    
		    FileInputStream fstream = new FileInputStream("D:/draw/side2.txt");
		    System.out.println("---------------------------------------------------------------------------------------------------------------------");
		   // System.out.println("Reading Side view data");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    while ((strLine = br.readLine()) != null) 
		    {
		    	
		    	//System.out.println (strLine);
		    	String str[]=strLine.split(",");
		    	double x=Double.parseDouble(str[0]);
		    	double y=Double.parseDouble(str[1]);
		    	
		    	//System.out.println("Value of x,y=========="+x+""+y);
		    	Value vf=new Value();
		    	vf.setX(x);
		    	vf.setY(y);
		    	arf.add(vf);
		    	
		    }
		 
		    
		    in.close();
		    }
	 catch (Exception e)
	 {
		      System.err.println("Error: " + e.getMessage());
		    }
	 return arf;
	  }
	
	public ArrayList readFront()
	  {
	    ArrayList ars=new ArrayList();
	
	    try
	 
	    {
		    
		    FileInputStream fstream = new FileInputStream("D:/draw/Front2.txt");
		  //  System.out.println("---------------------------------------------------------------------------------------------------------------------");
		  //  System.out.println("Reading Front view data");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    while ((strLine = br.readLine()) != null) 
		    {
		    	
		    	//System.out.println (strLine);
		    	String str[]=strLine.split(",");
		    	double x=Double.parseDouble(str[0]);
		    	double y=Double.parseDouble(str[1]);
		    	
		    	//System.out.println("Value of x,y=========="+x+""+y);
		    	Value vs=new Value();
		    	vs.setX(x);
		    	vs.setY(y);
		    	ars.add(vs);
		    	
		    }
		 
		    
		    in.close();
		    }
	 
	catch (Exception e)
	 {
		    
		 System.err.println("Error: " + e.getMessage());
		   
	 }
	 return ars;
	  }
	
	
	
	/*public void writeTop1(double[] x,double[] y) throws IOException
	{
		 File f=new File("D:/Newfiles/top1.txt");
	      FileOutputStream fop=new FileOutputStream(f);
 
	      
	      for(int i=0;i<x.length;i++)
	      {
	      
	      String value=String.valueOf(x[i])+","+String.valueOf(y[i])+"\n";
	      fop.write(value.getBytes());
	      }
	     
	          fop.close();
	          System.out.println("The data has been written");
	          
	}
	
	public void writeSide1(double[] x,double[] y) throws IOException
	{
		 File f=new File("D:/Newfiles/side1.txt");
	      FileOutputStream fop=new FileOutputStream(f);
 
	      
	      for(int i=0;i<x.length;i++)
	      {
	      
	      String value=String.valueOf(x[i])+","+String.valueOf(y[i])+"\n";
	      fop.write(value.getBytes());
	      }
	     
	          fop.close();
	          System.out.println("The data has been written");
	          
	}
	public void writeFront1(double[] x,double[] y) throws IOException
	{
		 File f=new File("D:/NewFiles/Front1.txt");
	      FileOutputStream fop=new FileOutputStream(f);
 
	      
	      for(int i=0;i<x.length;i++)
	      {
	      
	      String value=String.valueOf(x[i])+","+String.valueOf(y[i])+"\n";
	      fop.write(value.getBytes());
	      }
	     
	          fop.close();
	          System.out.println("The data has been written");
	          
	}*/
}
