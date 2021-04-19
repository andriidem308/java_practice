package FootballCompetition;

import java.io.*;
import java.util.*;

public class Competition {
    HashMap<Integer, Team> teamsMap;
    ArrayList<ArrayList<Integer>> matches;
    ArrayList<Team> teams;

    Competition() {
        teamsMap = new HashMap<>();
        matches = new ArrayList<>();
        setTeamsList();
    }
    Competition(String teamsfilePath, String matchesfilePath) throws IOException {
        teamsMap = new HashMap<>();
        matches = new ArrayList<>();
        readTeams(teamsfilePath);
        readMatches(matchesfilePath);
        setTeamsList();
    }
    Competition(HashMap<Integer, Team> teamsMap, ArrayList<ArrayList<Integer>> matches){
        this.teamsMap = teamsMap;
        this.matches = matches;
        setTeamsList();
    }

    void readTeams(String filePath) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));

        HashMap<Integer, Team> teams = new HashMap<>();

        try {
            while (true) {
                int id = Integer.parseInt(dis.readLine().trim());
                Team team = new Team(id);
                teams.put(id, team);
            }
        }
        catch (EOFException | NullPointerException ignored) { dis.close(); }

        for (Map.Entry<Integer, Team> entry: teams.entrySet()){
            this.teamsMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Team> entry: teams.entrySet()){
            this.teamsMap.put(entry.getKey(), entry.getValue());
        }
    }

    void readMatches(String filePath) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));

        ArrayList<ArrayList<Integer>> matches = new ArrayList<>();

        try {
            while (true) {
                ArrayList<Integer> match = new ArrayList<>();
                
                String[] strMatchArr = dis.readLine().split(" ");
                for (String sm : strMatchArr) {
                    byte[] smBytes = sm.trim().getBytes();
                    String a = Character.toString(smBytes[0]);
                    match.add(Integer.parseInt(a));
                }

                matches.add(match);
            }
        } catch (EOFException | NullPointerException ignored) { dis.close(); }

        this.matches = matches;
    }

    void setTeamsList(){
        teams = new ArrayList<>();
        for (Map.Entry<Integer, Team> teamEntry: teamsMap.entrySet()){
            teams.add(teamEntry.getValue());
        }
    }

    void printTeamsMap(){
        for (Map.Entry<Integer, Team> teamEntry: teamsMap.entrySet()){
            System.out.println(teamEntry.getValue());
        }
    }

    void printMatches(){
        for (ArrayList<Integer> match: matches){
            for (Integer el: match){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    void printTeams(){
        for (Team team: teams){
            System.out.println(team);
        }
    }

    void processMatch(ArrayList<Integer> match){
        int t1 = match.get(0), t2 = match.get(1);
        int b1 = match.get(2), b2 = match.get(3);

        if (b1 > b2) {
            teamsMap.get(t1).total += 3;
        }
        else if (b1 < b2) {
            teamsMap.get(t2).total += 3;
        }
        else {
            teamsMap.get(t1).total += 1;
            teamsMap.get(t2).total += 1;
        }

        teamsMap.get(t1).scored += b1;
        teamsMap.get(t1).missed += b2;

        teamsMap.get(t2).scored += b2;
        teamsMap.get(t2).missed += b1;
    }

    void processAllMatches(){
        for (ArrayList<Integer> match: matches){
            processMatch(match);
        }
    }

    ArrayList<Team> get_sorted_teams(){
        ArrayList<Team> sorted_teams = new ArrayList<>(teams);

        int size = sorted_teams.size();
        boolean swapped = true;

        while (swapped){
            swapped = false;

            for (int i = 0; i < size - 1; i++){
                int t1 = sorted_teams.get(i).total;
                int t2 = sorted_teams.get(i+1).total;

                if (t1 < t2){
                    Collections.swap(sorted_teams, i, i+1);
                    swapped = true;
                }
                else if (t1 == t2) {
                    int d1 = sorted_teams.get(i).scored - sorted_teams.get(i).missed;
                    int d2 = sorted_teams.get(i+1).scored - sorted_teams.get(i+1).missed;

                    if (d1 < d2) {
                        Collections.swap(sorted_teams, i, i+1);
                        swapped = true;
                    }
                    else if (d1 == d2){
                        Random random = new Random();
                        boolean toSwap = random.nextBoolean();

                        if (toSwap){
                            Collections.swap(sorted_teams, i, i+1);
                        }
                    }
                }
            }
        }

        return sorted_teams;

    }

    void printTable() {
        processAllMatches();
        ArrayList<Team> sorted_teams = get_sorted_teams();
        // 6 7 8 8
        System.out.println(" Team | Total | Scored | Missed ");
        for (Team team: sorted_teams){
            String formatted = String.format("%3d%8d%9d%8d", team.id, team.total, team.scored, team.missed);
            System.out.println(formatted);
        }

        System.out.println("\nWinner: " + sorted_teams.get(0).id);
    }


}
