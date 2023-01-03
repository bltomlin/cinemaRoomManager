package cinema;
import java.util.Scanner;
import java.lang.Math;

public class Cinema {
    static void calculateProfit(int numOfRows, int numOfSeats, int totalSeats) {
        System.out.println("Total income:");
        if (totalSeats < 60) {
            int profit = totalSeats * 10;
            String printProfit = "$" + String.valueOf(profit);
            System.out.println(printProfit);
        } else {
            if (numOfRows % 2 == 0) {
                numOfSeats= (numOfRows / 2) * numOfSeats;
                int profit = (numOfSeats * 8) + (numOfSeats * 10);
                String printProfit = "$" + String.valueOf(profit);
                System.out.println(printProfit);
            } else {
                int numOfBackRowSeats = ((int)Math.ceil(numOfRows / 2) + 1) * numOfSeats;
                int numOfFrontRowSeats = ((int)Math.floor(numOfRows / 2)) * numOfSeats;
                int profit = (numOfFrontRowSeats * 10) + (numOfBackRowSeats * 8);
                String printProfit = "$" + String.valueOf(profit);
                System.out.println(printProfit);
            }
        }
    }

    static void printSeatArrangement(int numOfRows, int numOfSeats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for(int y = 1; y <= numOfSeats; y++) {
            System.out.print(String.valueOf(y) + " ");
        }
        System.out.println();
        for(int i = 1; i <= numOfRows; i++) {
            System.out.print(String.valueOf(i) + " ");
            for (int x = 1; x <= numOfSeats; x++) {
                System.out.print("S ");
            }
            System.out.println();
        }
    }

    static void reserveSeat(int numOfSeats, int numOfRows, int rowNum, int seatNum) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for(int y = 1; y <= numOfSeats; y++) {
            System.out.print(String.valueOf(y) + " ");
        }
        System.out.println();
        for(int i = 1; i <= numOfRows; i++) {
            System.out.print(String.valueOf(i) + " ");
            for (int x = 1; x <= numOfSeats; x++) {
                if (x == seatNum && i == rowNum) {
                    System.out.print("B ");
                } else{
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }

    static void ticketPrice(int totalSeats, int numOfRows, int rowNum) {
        if (totalSeats > 60) {
            int divider = numOfRows / 2;
            if (rowNum <= divider) {
                System.out.println("Ticket price: $10");
            } else {
                System.out.println("Ticket price: $8");
            }
        } else {
            System.out.println("Ticket price: $10");
        }
    }
    static int numOfRows() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numOfRows = scanner.nextInt();
        return numOfRows;

    }
    static int rowNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        return rowNum;
    }

    static int numOfSeats() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = scanner.nextInt();
        return numOfSeats;
    }

    static int seatNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();
        return seatNum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfRows = numOfRows();
        int numOfSeats = numOfSeats();
        printSeatArrangement(numOfRows, numOfSeats);

        int totalSeats = numOfRows * numOfSeats;

        int rowNum = rowNum();
        int seatNum = seatNum();
        ticketPrice(totalSeats, numOfRows, rowNum);
        reserveSeat(numOfSeats, numOfRows, rowNum, seatNum);

    }
}
