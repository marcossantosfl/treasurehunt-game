/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author marcossantos
 */
public final class SaveMap {

    public static List<SaveMap> saveMap = new ArrayList<SaveMap>();

    private int position;
    private int whoPlayedIndex;
    private static int whereItIs = -1;

    SaveMap() {
        this.setPosition(-1);
        this.setWhoPlayedIndex(-1);
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the whoPlayedIndex
     */
    public int getWhoPlayedIndex() {
        return whoPlayedIndex;
    }

    /**
     * @param whoPlayedIndex the whoPlayed to set
     */
    public void setWhoPlayedIndex(int whoPlayedIndex) {
        this.whoPlayedIndex = whoPlayedIndex;
    }

    /**
     * @return the whereItIs
     */
    public int getWhereItIs() {
        if(SaveMap.whereItIs == -1)
        {
            return SaveMap.whereItIs = new Random().nextInt(TreasureFile.treasureWhere);
        }
        else
        {
            return SaveMap.whereItIs;
        }
    }

}
