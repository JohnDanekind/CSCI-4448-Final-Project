# CSCI 4448 Final Project: MancalaAI


Team Members:

1. John Danekind

Java Version:
16

## Description: ##
MancalaAI is an object-oriented GUI implementation of the popular board game Mancala.
Mancala is one of the oldest board games in the world.
Mancala is a two-player board game played with a tray and small stones or seeds. 
The board consists of two rows of pits, with each player controlling one row. 
The players take turns picking up the stones from one of their pits and distributing them counterclockwise, 
dropping one stone in each pit, including their own Mancala
(a larger pit at the end of each row), but skipping the opponent's Mancala. 
The aim is to capture more stones in your Mancala than your opponent by strategic moves and captures. 
The game ends when one player's row is empty, and the player with the most stones in their Mancala wins.
MancalaAI allows for two players to play against each other using several different strategies. 
You can have a human player play against a robot player or another human player. The robot player can 
choose it's next optimal move with several different strategies. These range from very basic to more advanced. 
The minimax strategy has the given player select the next optimal move through the use of the minimax algorithm. 
The minimax algorithm is commonly used in zero-sum, adversarial, deterministic environments. I have made use of four
different design patterns throughout the implementation. This includes an observer, that allows the board data structure and the board
GUI to communicate with each other, a strategy pattern for selecting the next move, a singleton to ensure events caused by the mouse clicking
only occur once, and a factory for setting up a given game with certain configurations.

## Information for  the Graders: ##
All the BDD tests, the UML diagram, screenshots of code coverage, and other important information 
can be found in a PDF called "**Final Project Deliverables**"