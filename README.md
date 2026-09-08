# DSA Practice

A small Java project for practicing data structures and algorithms. Each
structure/algorithm lives in its own class with a `main()` method, so it can
be run and inspected on its own.

## How it works

- **Build tool:** Maven (`pom.xml`), Java 21.
- **Layout:**
  - `src/main/java/com/practice/datastructures/...` — linked lists, stack, queue, BST
  - `src/main/java/com/practice/algorithms/...` — sorting (bubble/merge/quick) and binary search
  - `src/test/java/...` — JUnit 5 tests
- `Main.java` just prints the list of runnable classes.
- `run.sh` is a convenience wrapper around Maven commands.

## Setup

Run the install script once to get Java 21 and Maven set up:

```bash
./install.sh
```

## Running it

```bash
./run.sh list                 # show every runnable class
./run.sh run                  # run Main (prints the menu)
./run.sh run MergeSort        # run a class by short name (fuzzy match)
./run.sh run com.practice.algorithms.sorting.MergeSort  # run by full name
./run.sh test                 # run the test suite
./run.sh build                # compile only
```

Equivalent raw Maven commands also work, e.g.:

```bash
mvn compile exec:java -Dexec.mainClass="com.practice.algorithms.sorting.MergeSort"
mvn test
```
