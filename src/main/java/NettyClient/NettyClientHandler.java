package NettyClient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client channel active");
        //String str= "r;\n";
        //String str  ="restartserver\n";
        String str = "w|{\"pl_id\":\"VDlHegHF-T5Yu-prHz-5ZKV-yRRQdcPLmpl4\",\"pl_name\":\"Ykras\",\"pl_distance\":2805,\"pl_clones\":0,\"pl_time\":\"23:34:28\",\"pl_score\":-30}\n";
        ctx.writeAndFlush(str);
        str = "r|\n";
        ctx.writeAndFlush(str);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println(s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
