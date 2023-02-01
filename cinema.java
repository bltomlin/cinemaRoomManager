/**
 * An application that helps manage a cinema theatre: sell tickets, check available seats, see sales statistics, and more.
 *
 * @author bltomlin
 */
package cinema;

import java.util.Scanner;

public class Cinema {

    /**
     * Prints the seating arrangement to console.
     */
    static void printSeatArrangement(int numOfRows, int numOfSeats, char[][] seatLayout) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int seatCoordinate = 0; seatCoordinate <= numOfSeats - 1; seatCoordinate++) {
            System.out.print(seatCoordinate + 1 + " ");
        }
        System.out.println();
        for (int row = 0; row < numOfRows; row++) {
            System.out.print(row + 1 + " ");
            for (int seat = 0; seat <= numOfSeats - 1; seat++) {
                System.out.print(seatLayout[row][seat] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Returns updated seating arrangement after customer reserves seat.
     * <p>
     * The desired seat will status change to 'reserved'.
     *
     * @return seatLayout
     */
    static char[][] reserveSeat(int numOfSeats, int numOfRows, int totalSeats, char[][] seatLayout) {
        int rowNum = rowNum() - 1;
        int seatNum = seatNum() - 1;
        if (rowNum >= numOfRows || seatNum >= numOfSeats || rowNum < 0 || seatNum < 0) {
            System.out.println("Wrong input!");
            reserveSeat(numOfSeats, numOfRows, totalSeats, seatLayout);
        } else if (seatLayout[rowNum][seatNum] != 'B') {
            seatLayout[rowNum][seatNum] = 'B';
            ticketPrice(totalSeats, numOfRows, rowNum);
        } else {
            System.out.println("That ticket has already been purchased");
            reserveSeat(numOfSeats, numOfRows, totalSeats, seatLayout);
        }
        return seatLayout;
    }

    /**
     * Returns default movie theater seating.
     *
     * @return seatLayout
     */
    static char[][] initializeSeats(int numOfRows, int numOfSeats, char[][] seatLayout) {
        for (int row = 0; row <= numOfRows - 1; row++) {
            for (int seat = 0; seat < numOfSeats; seat++) {
                seatLayout[row][seat] = 'S';
            }
        }
        return seatLayout;
    }

    /**
     * Returns real time income made on seat reservations.
     *
     * @return currentIncome
     */
    static int currentIncome(int numOfSeats, int numOfRows, int totalSeats, char[][] seatLayout) {
        int currentIncome = 0;
        int divider = numOfRows / 2;
        for (int row = 0; row <= numOfRows - 1; row++) {
            for (int seat = 0; seat < numOfSeats; seat++) {
                if (seatLayout[row][seat] == 'B') {
                    if (totalSeats > 60) {
                        if (row < divider) {
                            currentIncome += 10;
                        } else {
                            currentIncome += 8;
                        }
                    } else {
                        currentIncome += 10;
                    }
                }
            }
        }
        return currentIncome;
    }

    /**
     * Returns potential income based on seats available.
     *
     * @return potentialIncome
     */
    static int calculatePotentialIncome(int numOfRows, int numOfSeats, int totalSeats) {
        int potentialIncome;
        int divider = numOfRows / 2;
        if (totalSeats > 60) {
            potentialIncome = ((divider) * numOfSeats * 10) + ((divider + 1) * numOfSeats * 8);
        } else {
            potentialIncome = totalSeats * 10;
        }
        return potentialIncome;
    }

    /**
     * Prints the cost of a ticket.
     */
    static void ticketPrice(int totalSeats, int numOfRows, int rowNum) {
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

    /**
     * Prints
     * <p>
     * -The number of purchased tickets;
     * -The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places.
     * -Current income.
     * -The total income that shows how much money the theatre will get if all the tickets are sold.
     */
    static void statistics(int numOfRows, int numOfSeats, int soldTickets, int totalSeats, int currentIncome) {
        System.out.println("Number of purchased tickets: " + soldTickets);
        double ticketPercent = ((double) soldTickets / (double) totalSeats) * 100.0;
        String strPercent = String.format("%.2f", ticketPercent);
        System.out.println("Percentage: " + strPercent + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + calculatePotentialIncome(numOfRows, numOfSeats, totalSeats));

    }

    /**
     * The following methods return user input based on prompts.
     */
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

    /**
     * Prints the program menu.
     */
    static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    /**
     * Program Logic for the menu.
     */
    static void menu(int numOfSeats, int numOfRows, int totalSeats, char[][] seatLayout, int soldTickets) {
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
                    soldTickets += 1;
                    break;
                case 3:
                    int currentIncome = currentIncome(numOfSeats, numOfRows, totalSeats, seatLayout);
                    statistics(numOfRows, numOfSeats, soldTickets, totalSeats, currentIncome);
                default:
                    System.out.println("Please pick an integer");
            }
            printMenu();
            option = scanner.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soldTickets = 0;
        int currentIncome = 0;
        int numOfRows = numOfRows();
        int numOfSeats = numOfSeats();
        char[][] seatLayout = new char[numOfRows][numOfSeats];
        seatLayout = initializeSeats(numOfRows, numOfSeats, seatLayout);
        int totalSeats = numOfRows * numOfSeats;
        int potentialIncome = calculatePotentialIncome(totalSeats, numOfRows, currentIncome);
        menu(numOfSeats, numOfRows, totalSeats, seatLayout, soldTickets);

    }
}
