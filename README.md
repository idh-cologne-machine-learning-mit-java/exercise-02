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
We will make one more improvement to the ATM in the next step. If a user has entered an illegal value (e.g., 42), the ATM gives an error message, which is fine. But this happens after the ATM tried to generate an int array, although it could be known in advance that we will never find a combination of banknotes that sums up to 42 (because 42 is not divisible by 5, which is our smallest value). So it's a waste of resources to call the function `withdraw(int)` in the first place.

To fix this situation, we will make use of something new that has been introduced with Java 8 (you will therefore need to fix the Java version in your `pom.xml`): Lambda expressions.

Please add a function inheriting from [`java.util.function.IntPredicate`](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntPredicate.html) to the `ATM` class, and include a call to it as a first action in the `withdraw(int)` method, so that we immediately throw an exception if the amount is not withdrawable.

If you need to read up on lambda functions in Java, [this](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) is a good start.

### Snippets

Since this is only the reason to force you to edit the `pom.xml` file, I'm giving you a few uncommented snippets to help you get started:

```java
IntPredicate check = i -> i % 5 == 0;
```

```java
if (!check(amount)) {
  // TODO
}
```

## Step 8
Commit your changes and push them to the server.