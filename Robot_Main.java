package robotsFight;

public class Robot_Main {
    public static void main(String[] args) {

        System.out.println("Enter robot_1 name: ");
        RobotParent robot_1 = new RobotParent(ReadFromConsole.getName());

        System.out.println("Enter robot_2 name: ");
        RobotParent robot_2 = new RobotParent(ReadFromConsole.getName());


        final String PLAYING_LETTERS = "QWEASDZXC";

        final String EXIT_LETTER = "P";
        String inputLetter = "";
        RobotParent workingRobot = robot_1;

        do {
            System.out.println(" ");
            GameMenu.startMenu(workingRobot);
            inputLetter = GameMenu.consoleLetter();
            if (!inputLetter.equals(EXIT_LETTER)) {

                if (PLAYING_LETTERS.contains(inputLetter)) {
                    workingRobot.analyseKey(inputLetter);
                } else if (!inputLetter.contains(EXIT_LETTER)) {
                    System.out.println(inputLetter + " - is wrong input, please use letter from the list " + PLAYING_LETTERS);
                    continue;
                }
            }

            if (workingRobot.getRobotHealth() != 0) {
                if (workingRobot == robot_1) {
                    workingRobot = robot_2;
                } else {
                    workingRobot = robot_1;
                    System.out.println("----------");
                    System.out.println(robot_1.getRobotName() + ", " + robot_1.getRobotHealth());
                    System.out.println(robot_2.getRobotName() + ", " + robot_2.getRobotHealth());
                    System.out.println("----------");
                    System.out.println(" ");
                }
            }

        } while (!inputLetter.equals(EXIT_LETTER) && workingRobot.getRobotHealth() != 0);

        if (workingRobot == robot_1 && robot_1.getRobotHealth() == 0) {
            System.out.println(robot_1.getRobotName() + " has been killed.");
            System.out.println(robot_2.getRobotName() + " - Winner!!!");
            System.out.println("----------");
            System.out.println(robot_2.getRobotName() + ", " + robot_2.getRobotHealth());
        } else if (workingRobot == robot_2 && robot_2.getRobotHealth() == 0) {
            System.out.println(robot_2.getRobotName() + " has been killed.");
            System.out.println(robot_1.getRobotName() + " - Winner!!!");
            System.out.println("----------");
            System.out.println(robot_1.getRobotName() + ", " + robot_1.getRobotHealth());
        } else {
            System.out.println("Key does not damage");
            System.out.println("----------");
            System.out.println("robot_1 ," + robot_1.getRobotHealth());
            System.out.println("robot_2 ," + robot_2.getRobotHealth());
            System.out.println("----------");
        }
    }

}
