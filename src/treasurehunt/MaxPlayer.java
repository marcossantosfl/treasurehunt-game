/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.Scanner;

/**
 *
 * @author marcossantos
 */
public class MaxPlayer {

    public static int MAXPLAYER = 0;

    private Scanner scanner = null;

    void maxPlayer(int maxplayer) {

        new TreasureFile();
        
        scanner = new Scanner(System.in);

        while (maxplayer < 2 || maxplayer > 4) {
            try {
                System.out.println(ColorBackground.CYAN + "Welcome to treasure hunt!");
                System.out.print(ColorBackground.GREEN + "Please, enter the max of players. It must be 2 to 4: ");
                maxplayer = scanner.nextInt();

                if (maxplayer < 2 || maxplayer > 4) {
                    System.out.println(ColorBackground.RED + "Max of players has to be 2 to 4!");
                    maxplayer = 0;
                }
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                System.out.println(ColorBackground.RED + "An error ocurred, you must type the number of players again!");
                maxplayer = 0;
            }
        }

        MAXPLAYER = maxplayer;

        while (maxplayer > 0) {
            Player player = new Player();
            player.setPlayer();
            maxplayer--;
        }

        new Draw().DrawMatrix(false);

    }

}
