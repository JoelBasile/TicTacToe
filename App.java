import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        char answer = 'Y';

        while (answer == 'Y') {
            play();
            Scanner myObj = new Scanner(System.in);
            System.out.println("Play again? 'Y' or 'N'");
            answer = myObj.nextLine().charAt(0);
        }
    }

    static void play() {
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
            System.out.println(player);

            System.out.println("  " + player + "'s turn");

            int row_num = ask_for_input("row");
            int col_num = ask_for_input("column");

            if (!board.check_empty(row_num, col_num)) {
                System.out.println("Slot already filled");
                continue;
            }

            board.set_marker(row_num, col_num, player);
            turn_num++;

            System.out.println("");
            
            if ((result = board.check_win(turn_num)) == 1) {
                System.out.println(player + " IS THE WINNER");
                game_still_going = false;
                
            } else if (result == 2) {
                System.out.println("IT'S A DRAW");
                game_still_going = false;
            }

            board.print();
        }
    }

    static int ask_for_input(String section) {
        System.out.println("Enter " + section + " number (1 - 3)");

        Scanner myObj = new Scanner(System.in);
        int input = Integer.parseInt(myObj.nextLine());

        return input - 1;
    }
}