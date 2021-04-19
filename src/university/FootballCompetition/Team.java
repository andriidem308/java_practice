<<<<<<< HEAD
package FootballCompetition;
=======
package university.FootballCompetition;
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518

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