package com.xubao.httpTest;

import javax.swing.UnsupportedLookAndFeelException;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---------------------");
		System.out.println("msg="+msg);
		FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,Unpooled.wrappedBuffer("hello".getBytes()));
		
		resp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
		resp.headers().set(HttpHeaderNames.CACHE_CONTROL, "no-cache no-store must-revalidate");
		resp.headers().set(HttpHeaderNames.EXPIRES, "Thu, 01 Jan 1970 00:00:00 GMT");
		//response.headers().set("Access-Control-Allow-Origin","*");
        resp.headers().set(HttpHeaderNames.CONTENT_LENGTH, resp.content().readableBytes());
        
        resp.headers().set(HttpHeaderNames.CONNECTION,HttpHeaders.Values.KEEP_ALIVE);
		
		ctx.writeAndFlush(resp);
	}

}
