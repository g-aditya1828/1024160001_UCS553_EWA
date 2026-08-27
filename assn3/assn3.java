//ques 1
public class ExceptionHierarchyDemo {

    public static void main(String[] args) {

        // ArithmeticException
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        // NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = {10, 20, 30};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // NumberFormatException
        try {
            String s = "abc";
            int num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
    }
}

//ques 2
public class NestedTryCatchDemo {

    static void generateException() {
        int a = 10 / 0;   // ArithmeticException
    }

    public static void main(String[] args) {

        try {
            System.out.println("Outer try block started");

            try {
                int[] arr = {10, 20, 30};
                System.out.println(arr[5]);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch:");
                System.out.println("Array index is out of bounds.");
            }

            System.out.println("Calling method from outer try...");

            generateException();

            System.out.println("This statement will not execute.");

        } catch (ArithmeticException e) {
            System.out.println("Outer catch:");
            System.out.println("Arithmetic exception caught.");
        }

        System.out.println("Program continues after exception handling.");
    }
}

//ques 3
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter operator (+, -, *, /): ");
            String operator = sc.nextLine();

            double result;

            switch (operator) {

                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    result = num1 / num2;
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Invalid operator: " + operator
                    );
            }

            System.out.println("Result = " + result);

        } catch (NumberFormatException e) {

            System.out.println("Error: Please enter valid numbers.");

        } catch (ArithmeticException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            sc.close();
            System.out.println("Calculator execution completed.");
        }
    }
}

//ques 4
import java.util.Scanner;

// Custom Exception
class InvalidMarksException extends Exception {

    public InvalidMarksException(String message) {
        super(message);
    }
}

public class StudentResult {

    static void validateMarks(int marks) throws InvalidMarksException {

        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException(
                "Marks must be between 0 and 100."
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();

            int total = 0;

            for (int i = 1; i <= n; i++) {

                System.out.print("Enter marks for subject " + i + ": ");
                int marks = sc.nextInt();

                validateMarks(marks);

                total += marks;
            }

            double percentage = (double) total / n;

            char grade;

            if (percentage >= 90)
                grade = 'A';
            else if (percentage >= 80)
                grade = 'B';
            else if (percentage >= 70)
                grade = 'C';
            else if (percentage >= 60)
                grade = 'D';
            else if (percentage >= 50)
                grade = 'E';
            else
                grade = 'F';

            System.out.println("\n----- RESULT -----");
            System.out.println("Total Marks = " + total);
            System.out.println("Percentage = " + percentage + "%");
            System.out.println("Grade = " + grade);

        } catch (InvalidMarksException e) {

            System.out.println("Error: " + e.getMessage());
            System.out.println("Result cannot be calculated.");

        } catch (Exception e) {

            System.out.println("Invalid input.");

        } finally {

            sc.close();
        }
    }
}

//ques 5
import java.util.Scanner;

// Custom exception 1
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception 2
class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}

// Custom exception 3
class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {

    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        System.out.println(
            "Deposited: Rs. " + amount
        );
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance."
            );
        }

        balance -= amount;

        System.out.println(
            "Withdrawn: Rs. " + amount
        );
    }
}

public class BankingApplication {

    static BankAccount findAccount(
            BankAccount account,
            int accountNumber)
            throws AccountNotFoundException {

        if (account.getAccountNumber() != accountNumber) {
            throw new AccountNotFoundException(
                "Account number " + accountNumber +
                " does not exist."
            );
        }

        return account;
    }

    // Exceptions propagate from this method
    static void performTransactions(
            BankAccount account,
            int accountNumber)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException {

        BankAccount foundAccount =
                findAccount(account, accountNumber);

        foundAccount.deposit(5000);
        foundAccount.withdraw(2000);

        System.out.println(
            "Current Balance: Rs. " +
            foundAccount.getBalance()
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account =
                new BankAccount(101, 10000);

        try {

            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();

            performTransactions(
                account,
                accountNumber
            );

        } catch (AccountNotFoundException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );

        } finally {

            System.out.println(
                "Final Account Balance: Rs. " +
                account.getBalance()
            );

            sc.close();
        }
    }
}

//ques 6
import java.util.Scanner;

// Custom Exception 1
class InvalidUsernameException extends Exception {

    public InvalidUsernameException(String message) {
        super(message);
    }
}

// Custom Exception 2
class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String message) {
        super(message);
    }
}

// Custom Exception 3
class AccountLockedException extends Exception {

    public AccountLockedException(String message) {
        super(message);
    }
}

class LoginSystem {

    private String username = "admin";
    private String password = "12345";

    private int failedAttempts = 0;
    private final int MAX_ATTEMPTS = 3;

    private boolean locked = false;

    public void login(String enteredUsername,
                      String enteredPassword)
            throws InvalidUsernameException,
                   InvalidPasswordException,
                   AccountLockedException {

        // Check account lock
        if (locked) {
            throw new AccountLockedException(
                "Account is locked due to too many failed attempts."
            );
        }

        // Check username
        if (!username.equals(enteredUsername)) {

            failedAttempts++;

            if (failedAttempts >= MAX_ATTEMPTS) {
                locked = true;
            }

            throw new InvalidUsernameException(
                "Invalid username."
            );
        }

        // Check password
        if (!password.equals(enteredPassword)) {

            failedAttempts++;

            if (failedAttempts >= MAX_ATTEMPTS) {
                locked = true;
            }

            throw new InvalidPasswordException(
                "Invalid password."
            );
        }

        // Successful login
        failedAttempts = 0;

        System.out.println(
            "Login successful! Welcome " + username
        );
    }
}

public class LoginApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoginSystem system = new LoginSystem();

        final int MAX_ATTEMPTS = 3;

        try {

            for (int attempt = 1;
                 attempt <= MAX_ATTEMPTS;
                 attempt++) {

                try {

                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    system.login(username, password);

                    // Stop after successful login
                    break;

                } catch (InvalidUsernameException e) {

                    System.out.println(
                        "Login Error: " + e.getMessage()
                    );

                } catch (InvalidPasswordException e) {

                    System.out.println(
                        "Login Error: " + e.getMessage()
                    );

                } catch (AccountLockedException e) {

                    System.out.println(
                        "Security Error: " + e.getMessage()
                    );

                    break;
                }

                if (attempt < MAX_ATTEMPTS) {
                    System.out.println(
                        "Attempts remaining: " +
                        (MAX_ATTEMPTS - attempt)
                    );
                }
            }

        } finally {

            System.out.println(
                "Login process completed."
            );

            sc.close();
        }
    }
}