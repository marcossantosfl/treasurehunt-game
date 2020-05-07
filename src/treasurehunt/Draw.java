/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

/**
 *
 * @author marcossantos
 */
public class Draw {

    private final String alpha = "ABCDEFGHIJ";

    private void Clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private void DrawLetter() {
        for (int i = 0; i < 10; i++) {
            System.out.print(ColorBackground.PURPLE + "  " + alpha.charAt(i) + "  ");
            System.out.print("  ");
        }

        System.out.println();
    }

    public void DrawMatrix(boolean reDraw) {
        this.Clear();

        this.DrawLetter();

        if (reDraw == false) {
            for (int i = 0; i < 100; i++) {
                SaveMap.saveMap.add(new SaveMap());
            }
        }

        for (int z = 0; z < 10; z++) {
            for (int i = 0; i < 10; i++) {
                if (reDraw == false) {
                    System.out.print(ColorBackground.CYAN + "(_" + (z) + "_)" + ColorBackground.WHITE);

                } else {
                     int position = (10 * z) + i;
                     
                    if (SaveMap.saveMap.get(position).getPosition() == -1) {
                        System.out.print(ColorBackground.CYAN + "(_" + (z) + "_)" + ColorBackground.WHITE);
                    } else {
                        if(position == SaveMap.saveMap.get(position).getWhereItIs())
                        {
                            System.out.print(ColorBackground.BLUE + "( " + " " + " )" + ColorBackground.WHITE);
                        }
                        else
                        {
                            System.out.print(ColorBackground.YELLOW + "(_" + "X" + "_)" + ColorBackground.WHITE);
                        }
                    }
                }

                System.out.print("  ");
            }

            System.out.println();
        }

        if (reDraw == false) {
            new StartGame().Start();
        }
    }
}
