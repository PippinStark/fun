//sorting algorithm from UMN CSCI_1933 by Chris Davolis

import java.util.Random;

public class Stats {
    private static String[] attributes = {"Dex", "Str", "Cha", "Con", "Wis", "Int"};


    //baseline D&D stats
    public static int newStat() {
        Random a = new Random();
        int[] raw = {a.nextInt(6)+1, a.nextInt(6)+1, a.nextInt(6)+1, a.nextInt(6)+1};
        for (int i = 0; i < raw.length; i++) {
            for (int j = 1; j < raw.length - i; j++) {
                if (raw[j] < raw[j - 1]) {
                    int temp = raw[j];
                    raw[j] = raw[j - 1];
                    raw[j - 1] = temp;
                }
            }
        }
        int stat = raw[1] + raw[2] + raw[3];
        return stat;
    }
    public static int newStat(int luck) {
        Random a = new Random();
        int roll = 7 - luck;
        int[] raw = {a.nextInt(roll)+luck, a.nextInt(roll)+luck, a.nextInt(roll)+luck, a.nextInt(roll)+luck};
        for (int i = 0; i < raw.length; i++) {
            for (int j = 1; j < raw.length - i; j++) {
                if (raw[j] < raw[j - 1]) {
                    int temp = raw[j];
                    raw[j] = raw[j - 1];
                    raw[j - 1] = temp;
                }
            }
        }
        int stat = raw[1] + raw[2] + raw[3];
        return stat;
    }
    public static void rollStats() {
       for(int i = 0; i < 5; i++ ) {
           System.out.println(attributes[i] + " : " + Stats.newStat());
       }
    }
    public static void rollLuckyStats(int luck) {//luck can go up to 6, and if it does it'll roll all 18s
        for(int i = 0; i < 5; i++ ) {
            System.out.println(attributes[i] + " : " + Stats.newStat(luck));
        }
    }
    public static void main(String[] args) {
        rollStats();
    }
}
