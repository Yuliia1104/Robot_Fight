package robotsFight;

import java.util.Random;

public class RobotParent {
    private String robotName;
    private int robotHealth;
    //private char[] fiveLetters = new char[5];
    private String fiveLetters = "";
    private String alphabet = "QWEASDZXC";

    // Randomizer
    char getRandomKey() {
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }

    public String getAlphabet() {
        return alphabet;
    }

    // Constructor
    public RobotParent(String robotName) {
        this.robotName = robotName;
        this.robotHealth = 100;
        for (int i = 0; i < 5; i++) {
            this.fiveLetters = fiveLetters + getRandomKey();
        }
    }

    // getter for names
    public String getRobotName() {
        return robotName;
    }

    // getter and setter for health
    public int getRobotHealth() {
        return robotHealth;
    }

    public void setRobotHealth(int robotHealth) {
        this.robotHealth = robotHealth - 20;
    }

    // getter and setter for array of fighting letters
    public String getFiveLetters() {
        return fiveLetters;
    }

    public void setFiveLetters(String fiveLetters) {
        this.fiveLetters = getFiveLetters().replace(fiveLetters, "");
    }


    public void analyseKey(String key){
        if (getAlphabet().contains(key)){
            System.out.println(key + " - Key does not damage!");
            System.out.println(" ");
        }else if (getFiveLetters().contains(key)){
            setRobotHealth(getRobotHealth());
            System.out.println(String.format("Good shot!!! Babah, the health of %s decreased on 20 points", getRobotName()));
            setFiveLetters(key);
        }else {
            System.out.println(key + " - Key is not active anymore!");
            System.out.println(" ");
        }
    }
}
