# Rock-Game
Rock-Game is short for Rock-Paper-Scissors-Lizard-Spock.

## Project Description
Rock–Paper–Scissors–Lizard–Spock is an expanded version of the classic game, Rock-Paper-Scissors. Lizard and Spock as additional features. In Rock-Game, the player competes against the computer.

## How To Play?

### Instead of 3 choices, players choose from 5:
* 🪨 Rock
* 📄 Paper
* ✂️ Scissors
* 🦎 Lizard
* 🖖 Spock

### What Beats What?
* **Rock** crushes **Scissors** and crushes **Lizard**
* **Paper** covers **Rock** and disproves **Spock**
* **Scissors** cuts **Paper** and decapitates **Lizard** 
* **Lizard** eats **Paper** and poisons **Spock**
* **Spock** smashes **Scissors** and **Spock** vaporizes **Rock**   
* If both players choose the same action → **Tie**



## Code Structure

### Main Class (Main.java)

The main method:
1. initializes the static variables
2. initializes a specific instance of the `RockGame` class and assigns it to the variable `game`.
3. runs a `while` loop until the user wishes to exit the game.

It contains specific methods such as:

### updateScore()
The function `updateScore()` updates the static variables `numOfWins`, `numOfLosses`, `numOfTies`, and `numOfRounds`, which are printed in the console after each round.
`RockGame.Result` is the enum returned by the class `RockGame`. It is passed into `updateScore` with the name `result`.
The function updates the score based on the value of `result`. 
Possible value are `WIN`, `LOSE`, and `TIE`.

**NOTE**: `game.runGame()` is simultaneously called and passed into `updateScore` because it returns the result of the round.

### promptUserForInput()
The function `promptUserForInput` prints the string, which is passed into the function, in the console.
It also takes in the user input in the console and assigns it to the variable `input`.
It also converts `input` to uppercase using the method `.toUpperCase()`.

### printFinalScore()
The function `printFinalScore()` prints message in the console when the user has decided to exit the game.
The message depends on whether the user won, lost, or tied with the computer.

### RockGame Class (RockGame.java)

The bulk of the code is run through runGame() which is run in the main function to access the result of the game.

It contains specific methods such as:

* pregameMessages()
* readyToProceed()
* getInputString()
* getValidAction()
* getComputerAction()
* compareAction()
* plus necessary outputs

The main method will run runGame() everytime the user wants to play Rock Paper Scissors Lizard Spock.

### Additional Important Elements

#### Result

The enum that stores the three results: WIN, LOSS, and TIE.

#### Action

The enum used to store each action (ROCK, PAPER, SCISSORS, LIZARD, and SPOCK) with their corresponding ASCII art. The method of the enum, compareAction(), allows the user and computer action to be compared and to return a value of the Enum Result.

#### createWinningMap()

The hashmap that stores an action with the corresponding actions that it wins against. It is used to create a new HashMap in compareAction() in order to return the correct result.
