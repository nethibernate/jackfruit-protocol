package com.jackfruit.protocol.message;

/**
 * The message which uses between client and server. <p>
 * 
 * @author nethibernate
 *.
 */
public class JFInboundMessage {
	
	private JFMessageType type = JFMessageType.NULL;
	
	private byte[] content = null;
	
	public JFInboundMessage(int type, byte[] content){
		this.type = JFMessageType.typeOf(type);
		this.content = content;
	}
}
