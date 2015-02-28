package aero;

import java.awt.Frame;

public class AeroFrame extends Frame
{

	AeroFrame(String title)
	{
		AeroWindowAdapter adapter=new AeroWindowAdapter(this);
		addWindowListener(adapter);
	}
	
	
}
