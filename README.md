# Exercise 2: Using Maven


The goal of the second exercise is to extend a project that uses maven.

## Step 1: Install Maven
Since this is dependent on your environment, I'll not give detailed instructions. But the [homepage of Maven](https://maven.apache.org) contains an "Install" section.

If you happen to use Eclipse as a Java IDE: There is an excellent integration of maven into Eclipse, see [here](https://www.eclipse.org/m2e/). Chances are high that you have that installed, if your Eclipse version is relatively new.

And see a [similar thing for Netbeans](http://wiki.netbeans.org/Maven).

## Step 2
Please `clone` the repository `https://github.com/idh-cologne-machine-learning-mit-java/exercise-02`.

On the command line: `git clone https://github.com/idh-cologne-machine-learning-mit-java/exercise-01.git`

Create a new branch, using your UzK username.

## Step 3
The repository contains a maven project with some dependencies. Get your environment to download those and compile the project.

## Step 4
Enter the file `pom.xml` and fix at least the URL, such that it points to the GitHub repository we're using.

## Step 5
The class `de.ukoeln.idh.teaching.jml.ATM` contains an implementation of the decision logic in an ATM. When launched, users can enter (integer) numbers, and if they can be represented in Euro bills, a list of bills to return is printed. Play around with this program, in particular the "edge cases": negative values, values that cannot be handed out in Euro bills, very large or small numbers, invalid input etc. 

## Step 6
The main output of the ATM is handled by the method `join(int[])`. It takes an int-array as input and returns a string representation, in which the integers are concatenated by a comma. This is such a commonly needed case, that there must be predefined functions for this.

And in fact, the library Apache Commons Lang contains such functions in the class `StringUtils`. Add this library to the `pom.xml` file, such that maven can include it in the classpath. Then replace the call to `join(int[])` by a call to the proper method in `StringUtils`.

Finally, remove the old method `join(int[])`.

## Step 7
Commit your changes and push them to the server.