# Anagram Generator

## Overview
This Java utility generates all possible anagrams (permutations) of a given string containing distinct letters. It uses recursion with backtracking to generate permutations.

## Features
- Accepts any group of distinct letters as input.
- Uses a recursive backtracking approach for permutation generation.
- Ensures input validation (only alphabetic characters allowed).
- Returns a sorted list of all anagrams.
- Includes unit tests to validate functionality.

## Usage
### Running the Program
1. Clone the repository:
   ```sh
   git clone https://github.com/Deivison-Costa/AnagramGenerator.git
   ```
2. Navigate to the project directory:
   ```sh
   cd AnagramGeneratorProject
   ```
3. Compile the Java files:
   ```sh
   javac -d bin src/com/example/*.java
   ```
4. Run the program (example usage):
   ```java
   List<String> anagrams = AnagramGenerator.generateAnagrams("abc");
   System.out.println(anagrams);
   ```

## Installation
Ensure you have Java `openjdk-23.0.2` installed. Compile and execute the program using a Java IDE or terminal.

## Unit Tests
Run the included JUnit tests:
```sh
mvn test
```

## Example Output
Input: `abc`
Output:
```
[abc, acb, bac, bca, cab, cba]
```

