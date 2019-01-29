package com.keshawn;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Package: com.keshawn
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        ByteBuf byteBuf = (ByteBuf) msg;
//        System.out.println("Read from client: " + byteBuf.toString(Charset.forName("UTF-8")));
        ctx.channel().writeAndFlush(byteBuf);

    }
}
