package Server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;
import io.netty.util.CharsetUtil;

public class NettyServerInit extends ChannelInitializer<SocketChannel> {
   // private final SslContext sslCntx;

    public NettyServerInit(){
       // this.sslCntx=sslCntx;
    }
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //pipeline.addLast(sslCntx.newHandler(ch.alloc()))
              pipeline.addLast(new DelimiterBasedFrameDecoder(8192,Delimiters.lineDelimiter()))
                .addLast(new StringDecoder(CharsetUtil.UTF_8))
                .addLast(new StringEncoder(CharsetUtil.UTF_8))
                .addLast(new NettyServerHandler());
                //.addLast(new NettyWriteHandler());

    }
}
