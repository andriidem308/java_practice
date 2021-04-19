package FootballCompetition;

public class Team {
    public int id;
    public int total, scored, missed;

    public Team(int id) {
        this.id = id;
        total = scored = missed = 0;
    }

    @Override
    public String toString() {
        return String.format("Team %d\ntotal: %d\nscored: %d\nmissed: %d\n", id, total, scored, missed);
    }
}