package com.jackfruit.protocol.codec;

import java.util.List;

import com.jackfruit.protocol.message.JFInboundMessage;
import com.jackfruit.protocol.message.JFMessageType;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * This decoder is used to decode the byte stream which is sent from client to {@link JFInboundMessage}.<p>
 * 
 * The format of the inbound message:<br>
 * +------+---------------------+--------------+ <br>
 * | type | message body length | message body | <br>
 * +------+---------------------+--------------+ <br>
 * <br>
 * 1. (1 byte) The type is used to indicate the message function: <br>
 * 2. (2 bytes) The length is indicated the length of the message body <br>
 * 3. The message body is the real body which represents the logic content <br>
 * <br>
 * The message body is usually defined by the back server according to the logic.<br>
 * 
 * @author nethibernate
 * @see JFMessageType
 * @see JFInboundMessage
 *
 */
public class JFInboundMessageDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		in.markReaderIndex();
		//there is not enough data for decode.
		if(in.readableBytes() < 3) return;
		int type = in.readByte(); //read the type
		int length = ((in.readByte() | 0)<<8)|in.readByte(); //read the length
		if(in.readableBytes() < length){
			//the whole message is not arrived.
			in.resetReaderIndex();
			return;
		}
		//decode the message from the bytebuf
		out.add(new JFInboundMessage(type, in.readBytes(length).array()));
	}
	
}
