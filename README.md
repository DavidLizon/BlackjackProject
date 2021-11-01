# BlackjackProject

This program lets you play several rounds of blackjack with each round having a new deck to play with. The program checks to see if the player or the dealer have won with a natural blackjack and prints out who has won; If both the dealer and the player have a natural blackjack the program prints out that there is a push. If no one has a natural blackjack the program prints out the values and suits of the players cards as well as the total value of the cards. The program then displays the dealers top card and the player then has the option to hit or stand. If the value of the players cards exceeds 21 the player busts and the dealer is declared the winner; Both the player and dealers cards are shown with their respective card value totals. If the player stays the dealer hits while their card total is under 17; If the dealer busts the player is declared the winner. If the total value of the dealers cards is between 17 and 21 the total value of the players cards is compared against the total value of the dealers cards and whoever has the highest value is declared the winner; If the total values are equal the round is declare a push. After the round is over the player is prompted to enter yes or no to play again. If the player types yes the program repeats, if the player types no the program exits and thanks the player for playing. 

# Lessons Learned
This project was really difficult in the beginning with structuring how the program was going to run. There are several ways to accomplish the task and several ways to set up the classes. One sticking point was deciding on whether or not to have chained methods between classes or just access the required method by passing through a method and accessing the object. It was difficult to determine how open or locked down to make the objects and variables in the program. In the end I think the program ended up with enough security and protection without creating too many chained/repeated methods in the classes that are specific to blackjack. At first, I also had a hard time interacting with objects between classes but I was able to look at past projects and get an understanding of to access and use those objects to either get or set what was needed. This project can definitely be improved but further education and experience with the Java language and principles can help identify and correct those areas that need work. 

# Technologies used
Java, Eclipse, Git/GitHub