import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        char answer = 'Y';
        Scanner scanner = new Scanner(System.in);

        while (answer == 'Y') {
            play(scanner);
            System.out.println("Play again? 'Y' or 'N'");
            answer = scanner.nextLine().charAt(0);
        }

        scanner.close();
    }

    static void play(Scanner scanner) {
        // Create board
        Board board = new Board();
        int turn_num = 0, result;
        char player = 'O';
        boolean game_still_going = true;

        // Prints initial board
        board.print();

        while (game_still_going) {

            if (turn_num % 2 == 0) {
                player = 'O';
            } else {
                player = 'X';
            }

            System.out.println("  " + player + "'s turn");

            int row_num = ask_for_input("row", scanner);
            int col_num = ask_for_input("column", scanner);

            if (!board.check_empty(row_num, col_num)) {
                System.out.println("\nSlot already filled");
                board.print();
                continue;
            }

            board.set_marker(row_num, col_num, player);
            turn_num++;

            System.out.println("");
            
            if ((result = board.check_win(turn_num)) == 1) {
                System.out.println(player + " IS THE WINNER");
                game_still_going = false;
                
            } else if (result == 2) {
                System.out.println(" IT'S A DRAW");
                game_still_going = false;
            }

            board.print();
        }
    }

    static int ask_for_input(String section, Scanner scanner) {
        System.out.println("Enter " + section + " number (1 - 3)");

        int input = scanner.nextInt();

        return input - 1;
    }
}