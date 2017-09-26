package edu.uclm.esi.iso2.multas;

import edu.uclm.esi.iso2.multas.funcionario.presentation.*;

import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.status.StatusLogger;


public class App {
	
	static {
		 	    StatusLogger.getLogger().setLevel(Level.OFF);
		 	}

	public static void main(String[] args) {
		
		 LoginInterface window=new LoginInterface();
		 window.framePrincipal.setVisible(true);
		 
	

	}

}
