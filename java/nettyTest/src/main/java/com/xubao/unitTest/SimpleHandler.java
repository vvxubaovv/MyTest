package com.xubao.unitTest;

import java.util.List;

import javax.swing.SingleSelectionModel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;

public class SimpleHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("msg=" + msg);
		ctx.writeAndFlush("what");
		ctx.fireChannelRead(msg);
	}

	public static void main(String[] args) throws InterruptedException {
		EmbeddedChannel e = new EmbeddedChannel(new SimpleHandler());
		e.writeInbound("hahah");
		Object out = e.readOutbound();
		System.out.println("out=" + out);
		System.out.println("---------------------------------");

		EmbeddedChannel e1 = new EmbeddedChannel(new DecoderHandler(), new SimpleHandler(),new SimpleHandler2(),new SimpleHandler3());
		ByteBuf buf = Unpooled.buffer();
		buf.writeInt(4848);
		buf.writeInt(7199);
		int x = 2222;
		for(int i = 0;i<3;i++) {
			buf.writeByte(x>>>((3-i)*8)&0xff);
		}
		e1.writeInbound(buf);
		
		Thread.sleep(5000);
		
		e1.writeInbound((byte)(x&0xff));
		
		System.out.println(e1.readOutbound());
	}

	public static class DecoderHandler extends ByteToMessageDecoder {

		@Override
		protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
			// TODO Auto-generated method stub
			int len = in.readableBytes();
			System.out.println("len=" + len);
			len = len-len%4;
			byte[] buf = new byte[len];
			in.readBytes(buf);
			System.out.println("str=" + new String(buf, "utf-8"));

			int x = 0;
			for (int i = 0; i <buf.length; i++) {
				System.out.println(buf[i]+0);
				x=x<<8|buf[i]&0xff;
				if((i+1)%4==0) {
					out.add(x);
				}
			}
			
			
		}

	}
	
	
	public static class SimpleHandler2 extends SimpleChannelInboundHandler<Integer>{

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, Integer msg) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("SimpleHandler2 msg="+msg);
			ctx.fireChannelRead(msg);
		}
		
	}
	
	
	public static class SimpleHandler3 extends SimpleChannelInboundHandler<Integer>{

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, Integer msg) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("SimpleHandler3 msg="+msg);
		}
		
	}
}
