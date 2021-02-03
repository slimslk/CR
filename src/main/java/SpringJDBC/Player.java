package SpringJDBC;

import java.sql.Time;

public class Player {
    private String pl_id;
    private String pl_name;
    private int pl_distance;
    private int pl_clones;
    private Time pl_time;
    private int pl_score;

    public Player(){};
    public Player(String pl_id, String pl_name, int pl_distance, int pl_clones, Time pl_time, int pl_score) {
        this.pl_id = pl_id;
        this.pl_name = pl_name;
        this.pl_distance = pl_distance;
        this.pl_clones = pl_clones;
        this.pl_time = pl_time;
        this.pl_score = pl_score;
    }

    public String getPl_id() {
        return pl_id;
    }

    public void setPl_id(String pl_id) {
        this.pl_id = pl_id;
    }

    public String getPl_name() {
        return pl_name;
    }

    public void setPl_name(String pl_name) {
        this.pl_name = pl_name;
    }

    public int getPl_distance() {
        return pl_distance;
    }

    public void setPl_distance(int pl_distance) {
        this.pl_distance = pl_distance;
    }

    public int getPl_clones() {
        return pl_clones;
    }

    public void setPl_clones(int pl_clones) {
        this.pl_clones = pl_clones;
    }

    public Time getPl_time() {
        return pl_time;
    }

    public void setPl_time(Time pl_time) {
        this.pl_time = pl_time;
    }

    public int getPl_score() {
        return pl_score;
    }

    public void setPl_score(int pl_score) {
        this.pl_score = pl_score;
    }

    @Override
    public String toString() {
        return String.format("->ID: "+pl_id+
                " ->Nickname: "+pl_name+
                " ->Distance: "+pl_distance+
                " ->Use clones: "+pl_clones+
                " ->Scores: "+pl_score);
    }
}
