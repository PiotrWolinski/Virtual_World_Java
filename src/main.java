import World.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rozmiary planszy: ");
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        World world = new World(Y, X);
    }
}
