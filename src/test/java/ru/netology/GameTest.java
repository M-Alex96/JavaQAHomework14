package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Game tournament = new Game();
    Player player1 = new Player(1, "Mark", 2);
    Player player2 = new Player(2, "Peter", 4);
    Player player3 = new Player(3, "Andrew", 1);
    Player player4 = new Player(4, "Frank", 2);


    @Test
    public void ShouldFindByName() {
        tournament.register(player1);
        tournament.register(player2);
        tournament.register(player3);
        tournament.register(player4);

        Player expected = player1;

        Player actual = tournament.Registered("Mark");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotFindByNameIfFalse() {
        tournament.register(player1);
        tournament.register(player2);
        tournament.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            tournament.Registered("Steven");
        });
    }

    @Test
    public void ShouldRegister() {
        tournament.register(player1);

        List<Player> expected = new ArrayList<>();
        expected.add(player1);

        List<Player> actual = tournament.findAll();

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void Player1ShouldWin() throws Exception {
        tournament.register(player2);
        tournament.register(player3);


        int expected = 1;
        int actual = tournament.round("Peter", "Andrew");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Player2ShouldWin() throws Exception {
        tournament.register(player1);
        tournament.register(player2);

        int expected = 2;
        int actual = tournament.round("Mark", "Peter");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldDraw() throws Exception {
        tournament.register(player1);
        tournament.register(player4);

        int expected = 0;
        int actual = tournament.round("Mark", "Frank");

        Assertions.assertEquals(expected, actual);
    }
}
