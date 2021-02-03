package SpringJDBC;

import JsonGenerator.JsonSerialization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        ApplicationContext cntx =new ClassPathXmlApplicationContext("Bean.xml");
        PlayerJDBCTemplate playerJDBCTemplate = (PlayerJDBCTemplate)cntx.getBean("PlayerJDBCTemplate");

//        List<Player> players = playerJDBCTemplate.listPlayers(1);
//        try{
//            String jsonPlayers = new JsonSerialization().writeObjectArrayToString(players);
//            System.out.println(jsonPlayers);
//            List<Player> playerList= new JsonSerialization().getPlayersFromJson(jsonPlayers);
//            for(Player pl : playerList){
//                System.out.println(pl);
//            }
//        }catch (IOException e){
//            System.out.println(e);
//        }
        //System.err.println(playerJDBCTemplate.definePosition("dwIt6u2w-nMzk-2zWj-0WnR-AcyyFnnz4kGG"));


        for (int i=0; i<25; i++){
            String pl_id = randomString(8)+"-"+randomString(4)+"-"+(randomString(4))+"-"+randomString(4)+"-"+randomString(12);
            String pl_name = playerJDBCTemplate.getNickname((int)(Math.random()*3)+1);
            int pl_distance = (int)(Math.random()*4999);
            int pl_clones = (int)(Math.random()*10);
            Time pl_time = Time.valueOf(LocalTime.now());
            int pl_score = Math.round(pl_distance)-20*pl_clones;
            pl_score=pl_score<0?0:pl_score;
            //String checkID = playerJDBCTemplate.checkPlayerID(pl_id);
            playerJDBCTemplate.create(new Player(pl_id,pl_name,pl_distance,pl_clones,pl_time,pl_score));
//            if (checkID != null) {
//                playerJDBCTemplate.update(player);
//            } else {
//                playerJDBCTemplate.create(player);
//            }
            System.out.println("PlayerID: "+pl_id+" Player nickname:"+pl_name);
        }
    }
    private static final String randomString(int textLength) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(textLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
        return generatedString;
    }
}
