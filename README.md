# Sudoku Solver
This is a clone project of an adjacent sudoku game which I implemented using JavaFX, a Java framework. The flow of the application goes like, the user enter random number between 1-9 in any cell of 9x9 grid. As this is solver application, the application will first verify the user input and if it does't satisfy the rules then it will show a warning message. 

Rules : 

  Rule 1 - Each row must contain the numbers from 1 to 9, without repetitions
  Rule 2 - Each column must contain the numbers from 1 to 9, without repetitions
  Rule 3 - Each 3×3 block can only contain numbers from 1 to 9.
  Rule 4 - Each number in the 3×3 block, vertical column or horizontal row can be used only once.

And if the user inputs are correct then the application will generate the whole solution by filling all the blank cell in the grid. In this way the application contains two main feature that is verification the input and building the solution.


# Requirements 
1. JavaFX SDK, You can download from given link (https://gluonhq.com/products/javafx/) 
2. JSON (http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm)

# Setup
For setup for different IDE, you can follow (https://openjfx.io/openjfx-docs/) the given link.
