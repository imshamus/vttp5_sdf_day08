"# vttp5_sdf_day08" 
javac -d classes --source-path . src/project01am/day08/*.java
java -cp classes day08.App

***Mastermind***
Sudo code

General idea: Com random generate 4 digits, 1-6 ea, 1111 - 6666 

1. Use random function to generate 4 digits number between 1111-6666
    a. 4 random number generator to generate ea digit (1-6).
2. Use console to prompt for 4 digit input
    a.This shld be inside a while loop
3. check for invalid inputs(e.g. input not between 1111 and 6666)
4. Use a for-loop for checking
    a. check the digit at each index at ea Char(index).
        i. increment CP by one if match number & position
    b. check whether the input digit occurs in other positions.
        i. if pt a fulfills, no need perform pt b,
        ii. otherwise loop thru to check if there are matching number
            . increment C if number matches but position doesn't match.
5. Repeat pt 4 until soln matches.
    a. Allow up to 12 tries
6. Display whether you win or lose.
7. Repeat the game.

javac -d classes --source-path . src/project01am/day08/ArithApp/*.java
java -cp classes day08.ArithApp.Server

