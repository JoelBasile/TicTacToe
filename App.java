import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Create board
        Board board = new Board();
        int turn_num = 0;

        // Prints initial board
        board.print();

        while (true) {

            int row_num = ask_for_input("row");
            int col_num = ask_for_input("column");

            if (!board.check_empty(row_num, col_num)) {
                System.out.println("Slot already filled");
                continue;
            }

            board.set_marker(row_num, col_num, turn_num);
            turn_num++;
            if (board.check_win()) {
                System.out.println("  WINNER");
                board.print();
                break;
            }
            board.print();
        }
    }

    static int ask_for_input(String section) {
        System.out.println("Enter " + section + " number (1 - 3)");

        Scanner myObj = new Scanner(System.in);
        int input = Integer.parseInt(myObj.nextLine());

        //myObj.close();
        return input - 1;
    }
}