package SpringJDBC;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.List;

public class PlayerJDBCTemplate implements PlayerDAO{

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplateObject=new JdbcTemplate(dataSource);

    }
    public void create(Player player) {
        String id = player.getPl_id();
        String name = player.getPl_name();
        int distance = player.getPl_distance();
        int clones = player.getPl_clones();
        Time time = player.getPl_time();
        int score = player.getPl_score();
        String SQL = "insert into crScore (pl_id, pl_name, pl_distance, pl_clones, pl_time, pl_score) value (?, ?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL, id, name, distance, clones, time, score);
        System.out.println("crScore created");
        return;
    }
    public List<Player> listPlayers(int limits) {
        String SQL = "Select * from crScore";
        List<Player> players= jdbcTemplateObject.query(SQL+" order by pl_score desc limit ?", new PlayerMapper(), new Object[]{limits});
        return players;
    }

    @Override
    public int definePosition(String pl_id) {
        String SQL = "Select num from(select pl_id, row_number() over (order by pl_score desc) as num from crScore) t where pl_id =?";
        int position = jdbcTemplateObject.queryForObject(SQL,new Object[]{pl_id}, Integer.class);
        return position;
    }

    public void update(Player player) {
        String id = player.getPl_id();
        String name = player.getPl_name();
        int distance = player.getPl_distance();
        int clones = player.getPl_clones();
        Time time = player.getPl_time();
        int score = player.getPl_score();
        String SQL = "update crScore set pl_name = ?, pl_distance = ?, pl_clones = ?, pl_time = ?, pl_score = ? where pl_id = ?";
        jdbcTemplateObject.update(SQL, name, distance, clones, time, score, id);
        System.out.println("Record updated");
        return;
    }

    @Override
    public String checkPlayerID(String pl_id) {
        try {
            String SQL = "select pl_id from crScore where pl_id = ?";
            String playerId = jdbcTemplateObject.queryForObject(SQL, new Object[]{pl_id},String.class);
            return playerId;
        }catch (EmptyResultDataAccessException emp){
            return null;
        }

    }
    public boolean isScoreSmaller(String pl_id, int curScore){
        String SQL = "select pl_score from crScore where pl_id=?";
        try{
            int dbScore=jdbcTemplateObject.queryForObject(SQL, new Object[]{pl_id},int.class);
            if(dbScore<curScore){
                return true;
            }else {
                return false;
            }
        }catch (NullPointerException ex){
            System.err.println(ex);
            return false;
        }
    }
    public String getNickname(int id){
        String SQL = "select nickname from names where id = ?";
        String nickname = jdbcTemplateObject.queryForObject(SQL, new Object[]{id},String.class);
        return nickname;
    }

    public Player player(String id){
        String SQL = "select * from crScore where pl_id=?";
        Player player = jdbcTemplateObject.queryForObject(SQL,new Object[]{id},Player.class);
        return player;
    }

}
