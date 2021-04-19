<<<<<<< HEAD
package FootballCompetition;
=======
package university.FootballCompetition;
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;


public class Main {
<<<<<<< HEAD
    static String TEAMS_FILE_PATH = "src/FootballCompetition/bteams.dat";
    static String MATCHES_FILE_PATH = "src/FootballCompetition/bmatches.dat";
=======
    static String TEAMS_FILE_PATH = "src/university/FootballCompetition/bteams.dat";
    static String MATCHES_FILE_PATH = "src/university/FootballCompetition/bmatches.dat";
>>>>>>> d04f2c57e2ac39b66203badaf35a0a09390dc518

    public static void main(String[] args) throws IOException {
        Competition competition = new Competition(TEAMS_FILE_PATH, MATCHES_FILE_PATH);
        competition.printTable();

    }
}
