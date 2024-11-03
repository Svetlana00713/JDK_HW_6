package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
public class MontyHallGame {
    private final Random random = new Random();

    public boolean playGame(boolean switchDoor) {
        // 0 - дверь с автомобилем, 1 и 2 - двери с козами
        int carDoor = random.nextInt(3);
        int playerChoice = random.nextInt(3);

        // Определяем, какую дверь откроет ведущий
        int hostChoice;
        do {
            hostChoice = random.nextInt(3);
        } while (hostChoice == carDoor || hostChoice == playerChoice);

        // Если игрок решает поменять дверь
        if (switchDoor) {
            for (int i = 0; i < 3; i++) {
                if (i != playerChoice && i != hostChoice) {
                    playerChoice = i; // Меняем выбор
                }
            }
        }

        return playerChoice == carDoor; // Возвращаем результат
    }

    public static void main(String[] args) {
        MontyHallGame game = new MontyHallGame();
        HashMap<Integer, String> results = new HashMap<>();
        int wins = 0;
        int losses = 0;

        for (int i = 1; i <= 1000; i++) {
            boolean win = game.playGame(true); // Игрок всегда меняет дверь
            results.put(i, win ? "Win" : "Lose");
            if (win) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.println("Total Wins: " + wins);
        System.out.println("Total Losses: " + losses);
        System.out.println("Results: " + results);
    }
}
