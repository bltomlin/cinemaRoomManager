# Cinema Room Manager
## Installation
1. Install Java (JRE)
[https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
2. `gh repo clone bltomlin/cinemaRoomManager`
## Usage
#### Navigate to program directory
1. `cd ~/cinemaRoomManager`
#### Run the program
2. `java manager.java`

##### The program will prompt the user for two positive integer numbers: the number of rows and the number of seats in each row. The ticket price is determined by the following rules:

###### If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
###### In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the other 5 rows.

`The greater-than symbol followed by a space ( > ) represents the user input. Note that it's not part of the input.`

**Example 1**

```no-highlight
Enter the number of rows:
> 4
Enter the number of seats in each row:
> 5
Total income:
$200
```

**Example 2**

```no-highlight
Enter the number of rows:
> 8
Enter the number of seats in each row:
> 9
Total income:
$648
```

**Example 3**

```no-highlight
Enter the number of rows:
> 9
Enter the number of seats in each row:
> 7
Total income:
$560
```
