package aero;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadData 
{
	public ArrayList readData()
	  {
	    ArrayList ar=new ArrayList();
	
	    try
	 
	    {
	    	
	    	//FileInputStream fstream = new FileInputStream("D:/draw/AircraftDataFile2.txt");
	    	FileInputStream fstream = new FileInputStream("D:/draw/radialturn.txt");
		  //  FileInputStream fstream = new FileInputStream("D:/draw/data.txt");
		    System.out.println("---------------------------------------------------------------------------------------------------------------------");
		   // System.out.println("Reading data");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    while ((strLine = br.readLine()) != null) 
		    {
		    
		    	//System.out.println (strLine);
		    	String str[]=strLine.split(",");
		    	double x=Double.parseDouble(str[0]);
		    	double y=Double.parseDouble(str[1]);
		    	double z=Double.parseDouble(str[2]);
		    	double vx=Double.parseDouble(str[3]);
		    	double vy=Double.parseDouble(str[4]);
		    	double vz=Double.parseDouble(str[5]);
		    	//System.out.println("Value of x,y,z=========="+x+""+y+""+z);
		    	//System.out.println("Value of velocity x,velocity y,velocity z=========="+vx+""+vy+""+vz);
		    	Value v=new Value();
		    	v.setX(x);
		    	v.setY(y);
		    	v.setZ(z);
		    	v.setVx(vx);
		    	v.setVy(vy);
		    	v.setVz(vz);
		    	
		    	ar.add(v);
		    	
		 	    }
		  
		    in.close();
		    }
	 catch (Exception e)
	 {
		      System.err.println("Error: " + e.getMessage());
		    }
	 return ar;
	  }
}
