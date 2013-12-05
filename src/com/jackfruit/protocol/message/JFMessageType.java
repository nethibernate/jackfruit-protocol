package com.jackfruit.protocol.message;

/**
 * This type is used to indicate the type of a message <br>
 * which is sent from client.<p>
 * 
 * This type is different from the message type which is used in <br>
 * the logic side. This type specifies that the status between the <br>
 * client and server.<br>
 * <br>
 * Details:<br>
 * <li>1: HandShake: The client connect the server at first time</li><br>
 * <li>2: HandShake Ack: The server response for the client connection</li><br>
 * <li>3: Logic: The detail logic</li><br> 
 * 
 * @author nethibernate
 *
 */
public enum JFMessageType {
	HAND_SHAKE(1),
	LOGIC(2),
	NULL(99),
	;
	
	private int type = 0;
	private JFMessageType(int type){
		this.type = type;
	}

	public static JFMessageType typeOf(int type){
		for(JFMessageType eachType : JFMessageType.values()){
			if(eachType.type == type) return eachType;
		}
		return NULL;
	}
}
