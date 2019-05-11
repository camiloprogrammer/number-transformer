# What is the number-transformer project?

This project provides a library to transform numbers into their text representation (like "10" -> "Ten")

More examples can be found in the [specification file](https://github.com/camiloprogrammer/number-transformer/blob/master/core/src/test/java/number/transformer/core/specs/english/EnglishNumberTransformationTest.feature)

# How to run locally?

To try the project locally we provide a command line interface (similar to a REPL) to convert numbers to English.

To run it:

1. Clone this project 
2. Open a terminal (or command prompt in Windows) and head to the folder where you cloned the project
3. Run the build:

   Windows:

   ```bash
   gradlew clean buildRepl
   ```

   Linux/Mac:

   ```bash
   ./gradlew clean buildRepl
   ```

  This should build and package the application and put it inside a `launcher` folder. 

4. Run the application:

   Windows:

   ```bash
   launcher\bin\repl
   ```

   Linux/Mac:

   ```bash
   ./launcher/bin/repl
   ```

   NOTE: The steps above have been tried in Windows and Linux. But they should work in Mac as well.

# Contributing changes / developer documentation

## Build system

The project uses Gradle to handle the project build. The main project is divided into 2 sub-projects:

* `core`: That contains the main library that performs the number transformation
* `repl`: A command-line application that allows users to quickly try the main transformation library

## About the code

The code is written in Java, targeting Java 8.

## Basic concepts

The number transformers are built as a set of reusable "Lego" bricks that handle each part of a number for a particular transformer.

For example, to transform numbers to English, one of the bricks is the *million transformer* that is responsible of:

1. For a number of the form `XXXYYYYYY` (like `102000450`), it will take care of the `XXX` part and handle the millions part. The number might not define anything in the millions section, and in this case it skips straight to part 2 below, for example, a number like `123` has no millions defined).
2. Delegate the YYYYYY part to the next appropriate "Lego" brick, in this case, the *thousand transformer*.

In this sense, you will find that the `BillionTransformer` class uses the `MillionTransformer` which uses the `ThousandTransformer` and so on...

The `internal` packages define this reusable components.
The `core` (non-internal` packages define interfaces & classes that expose a combination of these "Lego" bricks put together to serve a specific requirement.

Different languages might use the "Lego" bricks in a different way or will need to define their own set of components and they should evolve as more features are added to the `core` library.

## Code style

If you use Eclipse, you'll find the code formatters and clean up configurations in the `devconf` folder.

For IDEA users, IDEA offers a way to import Eclipse formatters.

## Testing

We use a combination of Cucumber to test the specification of the number transformation and JUnit to test specific error cases that should be handled by the library.

# Using as a library in other projects

This library isn't published to a central artifact repo (like Maven Central) and there are no plans to do so. It's a sample project.

However, you can configure publishers in the Gradle build and publish to your local Maven repo to give it a try in other projects.

# Features available

* In `master` branch and considered ready an English transformer. It supports all numbers covered by the `int` data type.
* In development, an Spanish transformer considered beta. Currently in branch `feature/1/spanish_language`.

