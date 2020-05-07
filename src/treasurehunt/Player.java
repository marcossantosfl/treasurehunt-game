/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marcossantos
 */
public class Player {

    public static List<Player> player = new ArrayList<Player>();

    private static int countPlayer = 0;

    private int index;
    private String name;
    private String surname;
    private int age = 0;

    private Scanner scanner = null;

    void setPlayer() {
        scanner = new Scanner(System.in);

        while (age < 18) {
            try {
                System.out.println();
                System.out.print(ColorBackground.GREEN + "Please enter the age of the player: ");
                setAge(scanner.nextInt());

                if (getAge() < 18 || getAge() > 65) {
                    System.out.println(ColorBackground.RED + "The age has to be 18 or above (max 65 years old)!");
                    setAge(0);
                }
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                System.out.println(ColorBackground.RED + "An error ocurred, you must type the age again!");
                setAge(0);
            }

        }

        this.setAge(age);

        scanner = new Scanner(System.in);

        while (true) {
            try {

                System.out.print(ColorBackground.GREEN + "Please enter your name and surname: ");
                String fullname = scanner.nextLine();

                String[] breakname = fullname.split(" ");

                if (breakname.length < 2) {
                    System.out.println(ColorBackground.RED + "You must enter your name and surname!");
                    continue;
                } else {
                    this.setName(breakname[0]);
                    this.setSurname(breakname[1]);
                    break;
                }

            } catch (Exception e) {
                System.out.println(ColorBackground.RED + "An error ocurred, you must type the age again!");
                return;
            }
        }

        this.setIndex(countPlayer++);

        player.add(this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
