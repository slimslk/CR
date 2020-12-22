package Main;

import SpringJDBC.PlayerQuery;

import java.io.IOException;

public class messageSplitter {
    public Object splitMessage(String s) throws IOException {
        String[] splitMessage = s.split("\\|");
        for (String f : splitMessage){
            System.out.println("message: "+f);
        }
        switch (splitMessage[0])
        {
            case("r"):
                return new PlayerQuery().getPlayerListJson(20);
            case("w"):
                return new PlayerQuery().addPlayerToDB(splitMessage[1]);
            default:
                System.out.println("Message haven't attr");
                return null;
        }
    }
}
