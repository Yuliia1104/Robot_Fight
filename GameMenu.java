package robotsFight;

public class GameMenu extends ReadFromConsole {
    public static void startMenu(RobotParent robotParent){
        System.out.println("To Exit press P");
        System.out.println("Shoot the first robot: " + robotParent.getRobotName());
        System.out.println("Your step: press key \"QWEASDZXC\"");
    }

}