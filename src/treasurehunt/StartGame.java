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
public class StartGame {

    private boolean found = false;

    private Scanner scanner = null;

    void Start() {
        
        Draw draw = new Draw();
        
        while (found == false) {
            for (int i = 0; i < Player.player.size(); i++) {

                Player p = Player.player.get(i);

                scanner = new Scanner(System.in);

                try {
                    System.out.print(ColorBackground.GREEN + "" + p.getName() + " " +p.getSurname()+ " pick up a letter and a number: ");
                    String text = scanner.nextLine();

                    if (text.length() > 2) {
                        System.out.println(ColorBackground.RED + "Allowed to type a letter and a number together!");
                        i--;
                    } else {
                        if (Character.getNumericValue(text.charAt(1)) <= 9) {
                            int textToPosition = this.ConvertStringtoPosition(text);

                            if (textToPosition >= 0 && textToPosition <= 100) {
                                for (int a = 0; a < SaveMap.saveMap.size(); a++) {
                                    if (textToPosition == a) {
                                        if (SaveMap.saveMap.get(a).getWhoPlayedIndex() == -1 && SaveMap.saveMap.get(a).getPosition() == -1) {
                                            SaveMap.saveMap.get(a).setPosition(a);
                                            SaveMap.saveMap.get(a).setWhoPlayedIndex(p.getIndex());
                                            if(SaveMap.saveMap.get(a).getWhereItIs() == textToPosition)
                                            {
                                                found = true;
                                                System.out.print(ColorBackground.BLUE + "You won! congratulations: " +p.getName()+" "+p.getSurname());
                                                draw.DrawMatrix(true);
                                                break;
                                            }
                                            else
                                            {
                                                draw.DrawMatrix(true);
                                            }
                                        } else {
                                            System.out.println(ColorBackground.RED + "you cannot play here");
                                            i--;
                                        }
                                    }
                                }
                            } else {
                                System.out.println(ColorBackground.RED + "Position must be letter + number, like: A0");
                                i--;
                            }
                        } else {
                            System.out.println(ColorBackground.RED + "Position must be letter + number, like: A0");
                            i--;
                        }
                    }
                } catch (Exception e) {
                    scanner = new Scanner(System.in);
                    System.out.println(ColorBackground.RED + "You must try again!");
                    i--;
                }
            }
        }
        
        if(found == true)
        {
        }

    }

    private int ConvertStringtoPosition(String text) {
        int position = -1;

        String textConverted = text.toUpperCase();

        String alpha = "ABCDEFGHIJ";

        for (int i = 0; i < alpha.length(); i++) {
            if (textConverted.startsWith(Character.toString(alpha.charAt(i)))) {
                position = Character.getNumericValue(textConverted.charAt(1));

                position = (position != 0 ? (position * 10) : position) + i;

            }
        }

        return position;
    }

    /**
     * @return the whereItIs
     */
}
