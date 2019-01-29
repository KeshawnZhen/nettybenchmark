package com.keshawn;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

/**
 * Package: com.keshawn
 */
public class NettyServer {

    private static final int PORT = 25000;

    public static void main(String[] args) {

        int bossThreadNum = 1;
        int workerThreadNum = 1;
        int a0 = 0;
        int a1 = 0;
        if(args != null && args.length > 0){
            try{
                a0 = Integer.valueOf(args[0]);
                a1 = Integer.valueOf(args[1]);
            }catch (NumberFormatException e){
                System.err.println("Usage: java NettyServer args0 args1");
                e.printStackTrace();
            }finally {
                bossThreadNum = a0 > 1 ? a0 : bossThreadNum;
                workerThreadNum = a1 > 1 ? a1 : workerThreadNum;
            }
        }

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(bossThreadNum);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(workerThreadNum);

        final ServerBootstrap b = new ServerBootstrap();

        b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ServerHandler());
                    }
                });


        b.bind(PORT).addListener(
                future -> {
                    if (future.isSuccess()) {
                        System.out.println(new Date() + ": port [" + PORT + "] bind successed !");
                    } else {
                        System.err.println("prot [" + PORT + "] bind failed!");
                    }

                });


    }
}