/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author marcossantos
 */
public class TreasureFile {

    public static int treasureWhere = 0;
    
    TreasureFile() {
        try {
            try 
                (BufferedReader br = new BufferedReader(new FileReader(new File("src/treasurehunt/treasure.txt")))) {
                while (br.ready()) 
                {
                    TreasureFile.treasureWhere = br.read();
                }
            }
        } catch (IOException ioe) {
            System.out.println(ColorBackground.RED + ioe.getLocalizedMessage());
        }
    }

}
