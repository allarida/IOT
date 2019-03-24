/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serealread;

import javax.comm.CommPortIdentifier;

/**
 *
 * @author PERSO
 */
public class NewClass {
    
    
     public static void main(String args[]) throws Exception {
     
         System.out.println("serial est : "+findSerialPort());
     
     }
    
    public static CommPortIdentifier findSerialPort() throws Exception {
	CommPortIdentifier serialPort = null;
        //System.out.println("-----"+ CommPortIdentifier.getPortIdentifier());
       @SuppressWarnings("unchecked")
	java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
       while ( portEnum.hasMoreElements() ) 
       {
          System.out.println(" in  ");
       	CommPortIdentifier portIdentifier = portEnum.nextElement();
       	if (CommPortIdentifier.PORT_SERIAL==portIdentifier.getPortType()) {
       		if (serialPort==null)
       			serialPort = portIdentifier;
       		else
       			throw new Exception("More than one serial port found! "+serialPort.getName()+" and "+portIdentifier.getName());
       	}
       }
       return serialPort;
}
}
