package Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyServer{

    static final int PORT = Integer.parseInt(System.getProperty("port","8787"));

    private static EventLoopGroup bossGroup;
    private static EventLoopGroup workerGroup;
    public static void runServer() throws Exception{
      //  SelfSignedCertificate ssl = new SelfSignedCertificate();
      //  SslContext sslCntx = SslContextBuilder.forServer(ssl.privateKey(),ssl.certificate()).build();
        ServerBootstrap b = new ServerBootstrap();
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup();
            try {
                b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                        .handler(new LoggingHandler(LogLevel.INFO))
                        .childHandler(new NettyServerInit());
                b.bind(PORT).sync().channel().closeFuture().sync();
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
    }
    public static void shutdown(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
    
    public static void restart() throws Exception {
        shutdown();
        runServer();
    }
}
