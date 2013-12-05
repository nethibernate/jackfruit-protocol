package com.jackfruit.protocol.message;

/**
 * The message which uses between client and server. <p>
 * 
 * @author nethibernate
 *.
 */
public class JFInboundMessage {
	
	private JFMessageType type = JFMessageType.NULL;
	
	private byte[] router = null;
	
	private byte[] content = null;
	
	public JFInboundMessage(int type, byte[] router, byte[] content){
		this.type = JFMessageType.typeOf(type);
		this.content = content;
	}

	public JFMessageType getType() {
		return type;
	}

	public void setType(JFMessageType type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public byte[] getRouter() {
		return router;
	}

	public void setRouter(byte[] router) {
		this.router = router;
	}
}
