package Main;

import Server.NettyServer;
import SpringJDBC.PlayerJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class mainClass {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        NettyServer.runServer();
        /*for (;;){
            String s = in.nextLine();
            switch (s){
                case("restartServer"):
                    NettyServer.restart();
                    break;
                case ("stopApp"):
                    System.out.println("Stop all.");
                    flag = true;
                    break;
                case ("runServer"):
                    NettyServer nettyServer = new NettyServer();
                    new Thread(nettyServer).run();
                    System.out.println("server is running");
                    break;
                case ("stopServer"):
                    NettyServer.shutdown();
                    break;
            }
            if(flag){break;}
            System.out.println(s);*/
        }
}
