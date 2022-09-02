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

-If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
-In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the other 5 rows.
`
<br>
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.
<br>
Example 1
<br>
Enter the number of rows:
<br>
> 4
<br>
Enter the number of seats in each row:
<br>
> 5
<br>
Total income:
<br>
$200
<br>
Example 2
<br>
Enter the number of rows:
<br>
> 8
<br>
Enter the number of seats in each row:
<br>
> 9
<br>
Total income:
<br>
$648
<br>
Example 3
<br>
Enter the number of rows:
<br>
> 9
<br>
Enter the number of seats in each row:
<br>
> 7
<br>
Total income:
<br>
$560
`
