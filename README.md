# Wordle Game Copy

## Overview
Wordle Game Copy is a Java-based recreation of the popular word puzzle game Wordle. This project emphasizes the core gameplay mechanics, allowing players to guess a five-letter word within a limited number of attempts. It features a graphical user interface (GUI) and implements essential game logic.

## Features
- **Graphical User Interface:** A user-friendly interface enhances the player's experience.
- **Game Logic:** Includes Wordle gameplay mechanics such as word guessing and feedback.
- **Dynamic Word Generation:** Randomly selects words for each session to ensure varied gameplay.

## Project Structure
- **`WordleApplication`:** 
  - The main class that launches the JavaFX application and serves as the entry point of the game.
- **`WordleController`:**
  - Manages user interactions with the GUI, handling events and updating the interface accordingly.
- **Core Classes:** 
  - **`Wordle`:** Implements the game's logic and manages gameplay.
  - **`WordleDictionary`:** Handles the wordlist used for the game.
  - **`WordleImplementation`:** Integrates parsing and word management for game sessions.

## How to Run

### Prerequisites
Ensure that Java and JavaFX are installed on your system.

### Steps
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/AkanMNdem/Wordle-Game-Copy.git
   cd Wordle-Game-Copy
   ```

2. **Compile the Application:**
   Use your preferred Java Integrated Development Environment (IDE) or command-line tools to build the project.

3. **Run the Game:**
   ```bash
   java -jar WordleGame.jar
   ```

## Technologies Used
- **Java:** Core programming language for game logic and mechanics.
- **JavaFX:** Used for graphical interface development.

## Note
This project is a clone of Wordle created for educational purposes. It demonstrates programming skills in game development and graphical interfaces.

## Contributing
This project is not open for external contributions as it is intended solely for educational demonstration.

## License
This repository is intended for research and educational purposes only and does not include an open-source license for general use.
