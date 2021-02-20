# TicTacToe
Needed to Self learn Java for School, so I decided to create a TicTacToe game to test my knowledge on basic Java Syntax and logic. I built this with only 2 hours of studying Java, so the program may be a little simple, but I learned a lot!

# DEMO
![](https://github.com/Dennayz/TicTacToe-Rule-based-AI/blob/master/tictactoe-demo.gif)

# Learning Experience
- Learnt minimax algorithm
- Java’s Hashmap interface and classes
- Problem solving and game theory
- A little about backtracking
- Broad understanding of Alpha-Beta Pruning
    - Search algorithm that decreases the number of nodes evaluated by minimax algorithm in search tree

# Update
I modified my game so I can play with a "cpu" player. I used the minimax algorithm to make the AI play smarter in the case where it's not possible for you to win. The algorithm is a decision based approach where it picks the best move to make next. There are two components in the recursive algorithm. One is the Maximizer and the other is the Minimizer. The Maximizer tries to maximize the chances of it winning and the Minimizer tries to minimizes the chances of Maximizer's chance of winning. By doing so, The Maximizer checks three different types of values and always picks the highest value to determine its next move. For my case, it is 10 (Win), 0 (Tie), and -10 (loose). </br>

Here is an example I found online: </br>

![](https://media.geeksforgeeks.org/wp-content/uploads/TIC_TAC.jpg)
