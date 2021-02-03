package Server;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class IdleEvent extends ChannelDuplexHandler {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            if(event.state()== IdleState.READER_IDLE){
                System.err.println("Close channel");
                ctx.close();
            }else if(event.state()==IdleState.WRITER_IDLE){
                System.err.println("Ping ");
                ctx.writeAndFlush("Ping\n");
            }
        }
    }
}
