import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("Pratham", MarkType.X);
        Player player2 = new Player("Ross", MarkType.O);

        Player currentPlayer = player1;
        Scanner scanner = new Scanner(System.in);
        int moveCount = 0;

        while (moveCount < 9) {
            printBoard(board);
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getMark() + ")");
            System.out.print("Enter row and column (0-2): ");
            
            int row, col;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid position! Row and column must be between 0 and 2.");
                    continue;
                }

                board.placeMark(row, col, currentPlayer.getMark());
                moveCount++;
                currentPlayer = (currentPlayer == player1) ? player2 : player1;

            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Invalid move: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input (in case of InputMismatchException)
            }
        }

        printBoard(board);
        System.out.println("Game Over!");
        scanner.close();
    }

    public static void printBoard(Board board) {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                MarkType mark = board.getCell(i, j).getMark();
                System.out.print((mark == MarkType.EMPTY ? "-" : mark) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
