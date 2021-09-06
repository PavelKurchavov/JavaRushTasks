package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Простая программа
*/

public class SymbolGame extends Game {
    @Override
    public void initialize() {
        setScreenSize(8, 3);

        char[] word = "JAVARUSH".toCharArray();
        int x = 0;
        for (Character c: word) {
            setCellValueEx(x, 1, Color.ORANGE, c.toString());
            x++;
        }
    }
}
