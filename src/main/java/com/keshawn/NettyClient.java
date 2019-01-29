package com.keshawn;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * Package: com.keshawn
 */
public class NettyClient {

    private static final int PORT = 25000;

    public static void main(String[] args) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup(1);
        Bootstrap b = new Bootstrap();

        b.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        b.connect("127.0.0.1",PORT).addListener(future -> {
            if(future.isSuccess()){
                System.out.println("Connected!");
            }else {
                System.out.println("Connect failed");
            }
        });
    }
}
