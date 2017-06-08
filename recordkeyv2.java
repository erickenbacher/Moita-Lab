/*This program will time stamp when a person
  presses and then releases any button on the 
  keyboard
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.lang.System;

public class recordkeyv2 extends Applet
	implements KeyListener, ActionListener
{
	public static int num = 0;
	public static int active = 0;
	public static long progtime = 0;
	public static long initpress = 0;
	TextArea outdata = new TextArea();
	Button b = new Button("Start");
	Button r = new Button("Clear");
	public void init()
	{
		add(outdata);
		add(b);
		add(r);
		addKeyListener(this);
		b.addActionListener(this);
		r.addActionListener(this);
		requestFocus();
	}
	public void keyPressed(KeyEvent k)
	{
	  if (initpress == 0 && active == 1) {
		num++;
		long spressed = System.currentTimeMillis();
		long pstamp = spressed - progtime; 
		String disppress = new String(" " + pstamp);
		outdata.append(num + "  " + disppress);
		initpress = 1;
	  }
	}
	public void keyReleased(KeyEvent k)
	{
	  if (active == 1) 
	  {
		initpress = 0;
   		long sreleased= System.currentTimeMillis();
		long rstamp = sreleased - progtime; 
		String disprelease = new String(" " + rstamp);
		outdata.append('\t' + "  " + disprelease + '\n' );
	  }
	}
	public void keyTyped(KeyEvent k) {}
	public void actionPerformed(ActionEvent ae)
	{
	 if (ae.getSource() == b)
	 {
	   if (active == 0) 
	   {
   		  progtime = System.currentTimeMillis();
		  outdata.append("----Started 0000--------\n" );
		  active = 1;
		  b.setLabel("Stop");
		  this.requestFocus();
	    }
	    else if (active == 1)
	    {
    	  long sreleased= System.currentTimeMillis();
		  long rstamp = sreleased - progtime; 
		  outdata.append("----Stopped " + rstamp + " --------\n" );
		  active = 0;
		  b.setLabel("Start");
		  num = 0;
	    }
	  }
	  else
	  {
		outdata.setText(" ");
     	active = 0;
		b.setLabel("Start");
		num = 0;
		this.requestFocus();
	  }
		
	}
}
