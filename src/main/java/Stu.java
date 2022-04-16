public class Stu {
    private Integer sid;
    private String name;
    private Integer score;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
