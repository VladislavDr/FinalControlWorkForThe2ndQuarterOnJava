public class Toy {
    Integer id;
    String name;
    Integer count;
    Integer chanceOfFallingOut;

    public Toy(Integer id, String name, Integer count, Integer chanceOfFallingOut) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.chanceOfFallingOut = chanceOfFallingOut;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getChanceOfFallingOut() {
        return chanceOfFallingOut;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setChanceOfFallingOut(Integer chanceOfFallingOut) {
        this.chanceOfFallingOut = chanceOfFallingOut;
    }

    @Override
    public String toString() {
        return name +
                ": id " + id +
                ", count " + count +
                ", percent " + chanceOfFallingOut +
                '.';
    }
}
