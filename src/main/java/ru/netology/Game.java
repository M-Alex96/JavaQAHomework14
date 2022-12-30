package ru.netology;

import java.util.ArrayList;
import java.util.List;


public class Game {


    private List<Player> players = new ArrayList<>();

    public List<Player> findAll() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player Registered(String name) {
        for (Player item : players) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new NotRegisteredException("Player" + name + " is not registered");
    }


    public int round(String playerName1, String playerName2) throws Exception {
        Player player1 = Registered(playerName1);
        Player player2 = Registered(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
