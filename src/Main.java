import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getPlayerMove(scanner, "Player A");
            String playerB = getPlayerMove(scanner, "Player B");

            displayResults(playerA, playerB);

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.nextLine().toUpperCase();

        } while (playAgain.equals("Y"));

        scanner.close(); // Close the scanner
    }

    private static String getPlayerMove(Scanner scanner, String playerName) {
        String move;
        do {
            System.out.print(playerName + ", enter your move (R, P, S): ");
            move = scanner.nextLine().toUpperCase(); // Convert to uppercase for consistency
        } while (!isValidMove(move));
        return move;
    }

    private static boolean isValidMove(String move) {
        return move.equals("R") || move.equals("P") || move.equals("S");
    }

    private static void displayResults(String playerA, String playerB) {
        System.out.println("Player A chose: " + playerA);
        System.out.println("Player B chose: " + playerB);

        if (playerA.equals(playerB)) {
            System.out.println("It's a Tie!");
        } else if (playerA.equals("R") && playerB.equals("S")) {
            System.out.println("Rock breaks Scissors. Player A wins!");
        } else if (playerA.equals("P") && playerB.equals("R")) {
            System.out.println("Paper covers Rock. Player A wins!");
        } else if (playerA.equals("S") && playerB.equals("P")) {
            System.out.println("Scissors cuts Paper. Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }
}
