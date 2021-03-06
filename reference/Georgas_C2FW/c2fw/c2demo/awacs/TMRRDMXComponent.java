package c2demo.awacs;

import java.util.*;

import c2.fw.*;

import edu.uci.isr.xarch.*;
import edu.uci.isr.xarch.types.*;

public class TMRRDMXComponent extends SimpleAWACSBrick{

	public TMRRDMXComponent(IComponent iComp){
		super(iComp);
	}

	public void handle(Message m){
		super.handle(m);
		if(m instanceof AWACSMessage){
			AWACSMessage am = (AWACSMessage)m;
			String payload = am.getPayload();
			
			System.out.println(getIdentifier() + " absorbed message: " + payload);
		}
	}
	
	public void tick(int timerCount){
		super.tick(timerCount);
		if((timerCount % 5) == 0){
			sendAWACSMessage("MAINRDMX" + getFTNumber(), "Timer Event");
		}
	}

}

