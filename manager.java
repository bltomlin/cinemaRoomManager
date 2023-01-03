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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = scanner.nextInt();
        printSeatArrangement(numOfRows, numOfSeats);
        int totalSeats = numOfRows * numOfSeats;
        calculateProfit(numOfRows, numOfSeats, totalSeats);
    }
}
