package aero;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AeroWindowAdapter extends WindowAdapter
{
	AeroFrame aero;
	
	public AeroWindowAdapter(AeroFrame aero)
	{
		this.aero=aero;
	}
	
	public void windowClosing(WindowEvent ev)
	{
		aero.setVisible(false);
	}

}
