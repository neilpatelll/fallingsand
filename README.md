# FallingSand

This repository contains a Java implementation of the FallingSand simulation, a simple cellular automaton that models the behavior of falling sand particles.

## Project Structure
fallingsand/
├── src/
│   ├── FallingSand.java
│   ├── SandDisplay.java
│   └── SandLab.java
└── README.md

## Files

- `FallingSand.java`: The main class responsible for the falling sand simulation logic.
- `SandDisplay.java`: A class that handles the graphical display of the falling sand simulation.
- `SandLab.java`: The entry point of the application, containing the `main` method.

## Installation

1. Clone the repository: `git clone https://github.com/your-username/fallingsand.git`
2. Navigate to the project directory: `cd fallingsand`

## Usage

To run the FallingSand simulation, navigate to the `src` directory and compile the Java files:
cd src
javac *.java

Then, execute the `SandLab` class to start the simulation:
java SandLab

This will launch the graphical display, and you can observe the falling sand particles in action.

## Simulation Rules

The FallingSand simulation follows these simple rules:

1. Sand particles start at the top of the grid.
2. Sand particles fall down if the cell below is empty.
3. If a sand particle encounters an obstacle (a non-empty cell), it comes to rest on top of that obstacle.
4. The simulation continues until all sand particles have settled or the grid is filled.
