package com.jackfruit.protocol.core;

/**
 * The message which uses between client and server. <p>
 * 
 * The format of the JFMessage:<br>
 * +---------------+------------+--------------+ <br>
 * | length(short) | route path | message body | <br>
 * +---------------+------------+--------------+ <br>
 * <br>
 * 1. The length is indicated the total length of the whole message <br>
 * 2. The route path is used by agent server to indicate which back server the message will dispatch to <br>
 * 3. The message body is the real body which represents the logic content <br>
 * <br>
 * The message body is usually defined by the back server according to the logic.
 * 
 * @author nethibernate
 *
 */
public class JFMessage {
	
	/** The length of the total message */
	private short msgLength = 0;
	
	/** The route path from the back server */
	private RoutePath routePath = null;
	
	/** The message body */
	private byte[] msgContent = null;
}
