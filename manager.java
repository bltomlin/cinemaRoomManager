package cinema;
import java.util.Scanner;

public class Cinema {

    static void printSeatArrangement(int numOfRows, int numOfSeats, char[][] seatLayout) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int y = 0; y <= numOfSeats - 1; y++) {
            System.out.print(y + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i <= numOfRows - 1; i++) {
            System.out.print(i + 1  + " ");
            for (int x = 0; x <= numOfSeats - 1; x++) {
                System.out.print(seatLayout[i][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static char[][] reserveSeat (int numOfSeats, int numOfRows, int totalSeats, char[][] seatLayout){
        int rowNum = rowNum() - 1;
        int seatNum = seatNum() - 1;
        ticketPrice(totalSeats, numOfRows, rowNum);
        for (int i = 0; i <= numOfRows - 1; i++) {
            for (int x = 0; x < numOfSeats; x++) {
                if (i == rowNum && x == seatNum) {
                    seatLayout[rowNum][seatNum] = 'B';
                }
            }
        } return seatLayout;
    }

    static char[][] initializeSeats(int numOfRows, int numOfSeats, char[][] seatLayout) {
        for (int i = 0; i <= numOfRows - 1; i++) {
            for (int x = 0; x < numOfSeats; x++) {
                seatLayout[i][x] = 'S';
            }
        }
        return seatLayout;
    }

    static void ticketPrice ( int totalSeats, int numOfRows, int rowNum){
        if (totalSeats > 60) {
            int divider = numOfRows / 2;
            if (rowNum < divider) {
                System.out.println("Ticket price: $10");
            } else {
                System.out.println("Ticket price: $8");
            }
        } else {
            System.out.println("Ticket price: $10");
        }
    }

    static int numOfRows () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numOfRows = scanner.nextInt();
        return numOfRows;

    }
    static int rowNum () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        return rowNum;
    }

    static int numOfSeats () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = scanner.nextInt();
        return numOfSeats;
    }

    static int seatNum () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();
        return seatNum;
    }

    static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }

    static void menu(int numOfSeats, int numOfRows, int totalSeats, char[][] seatLayout) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int option = scanner.nextInt();
        while (option != 0) {
            switch (option) {
                case 1:
                    printSeatArrangement(numOfRows, numOfSeats, seatLayout);
                    break;
                case 2:
                    reserveSeat(numOfSeats, numOfRows, totalSeats, seatLayout);
                    break;
                default:
                    System.out.println("Please pick an integer");
            }
            printMenu();
            option = scanner.nextInt();
        }
    }

    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        int numOfRows = numOfRows();
        int numOfSeats = numOfSeats();
        char[][] seatLayout = new char[numOfRows][numOfSeats];
        seatLayout = initializeSeats(numOfRows, numOfSeats, seatLayout);
        int totalSeats = numOfRows * numOfSeats;
        menu(numOfSeats, numOfRows, totalSeats, seatLayout);

    }
}
