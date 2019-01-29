package com.keshawn;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Package: com.keshawnd
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = getByteBuf(ctx);
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        ByteBuf buff = (ByteBuf) msg;
        System.out.println("read form server: " + buff.toString(Charset.forName("UTF-8")));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        ByteBuf buf = ctx.alloc().buffer();
        byte[] bytes = "Test communication".getBytes(Charset.forName("UTF-8"));
        buf.writeBytes(bytes);
        return buf;
    }
}
