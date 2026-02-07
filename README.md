# Rock-Game
Rock-Game is short for Rock-Paper-Scissors-Lizard-Spock.

## Project Description
Rock–Paper–Scissors–Lizard–Spock is an expanded version of the classic game, Rock-Paper-Scissors. It’s a recreation of Rock-Paper-Scissors with Lizard and Spock as additional features. In Rock-Game, the player competes against the computer.

## How To Play?

### Instead of 3 choices, players choose from 5:
* 🪨 Rock
* 📄 Paper
* ✂️ Scissors
* 🦎 Lizard
* 🖖 Spock

### What Beats What?
Scissors cuts Paper and decapitates Lizard 
* Paper covers Rock and disproves Spock 
* Rock crushes Scissors and crushes Lizard
* Lizard eats Paper and poisons Spock
* Spock smashes Scissors and Spock vaporizes Rock   
* If both players choose the same option → Tie

## Code Structure

### Main.java

The main method creates an instance of the RockGame class, which returns a result that allows the main method to increment the scores of either the user or the player until the player decides to leave.

### RockGame.java

The bulk of the code is run through runGame() which is run in the main function to access the result of the game.

It contains specific methods such as:

* pregameMessages()
* readyToProceed()
* getInputString()
* getValidAction()
* getComputerAction()
* compareAction()
* plus necessary outputs

The main method will run runGame() everytime the user want to play Rock Paper Scissors Lizard Spock.

### Additional Important Elements

#### Result

The enum that stores the three results: WIN, LOSS, and TIE

#### Action

The enum used to store each action (ROCK, PAPER, SCISSORS, LIZARD, and SPOCK) with their corresponding ascii art. The method of this enum, compareAction(), allows for the user and computer action to be compared and for return value of type Result.

#### createWinningMap()

The HashMap that stores an action with the corresponding actions that they win against. It is used to create a new HashMap in compareAction() in order to return the correct result.