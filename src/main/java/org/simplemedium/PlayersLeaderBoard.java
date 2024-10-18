package org.simplemedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
27. Players - Leaderboard
The leaderboard should display Players in the order of their level and Scores.
Logic -Consider Player class with fields -> Name, Level and Score
Needs to sort the players list - first sort by Level and then by score"
 */
public class PlayersLeaderBoard {

    public static void main(String[] args) {

        List<Player> playersList = Arrays.asList(
                new Player("Minesh", 3, 85),
                new Player("XYZ", 4, 70),
                new Player("PQE", 1, 95),
                new Player("PQE", 2, 90)
        );

        System.out.println("Initial List :" + playersList);
        List<Player> playersListSortedByLevel = playersList.stream().sorted(Comparator.comparingInt(Player::getLevel)).collect(Collectors.toList());
        System.out.println("List is sorted by level: " + playersListSortedByLevel);
        List<Player> playersListSortedByScore = playersList.stream().sorted(Comparator.comparingInt(Player::getScore).reversed()).collect(Collectors.toList());
        System.out.println("List is sorted by score (descending): " + playersListSortedByScore);
    }

    static class Player {
        private String name;
        private int level;
        private int score;

        public Player(String name, int level, int score) {
            this.name = name;
            this.level = level;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Player[name="+name+", level="+level+", score="+score+"]";
        }

        public int getLevel() {
            return level;
        }

        public int getScore() {
            return score;
        }
    }
}
