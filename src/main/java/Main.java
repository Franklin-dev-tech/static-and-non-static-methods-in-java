/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    // Constructor
    public Main() {
        System.out.println("Main class constructor called.");
    }

    // Static method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Non-static method to sum even Fibonacci numbers
    public int sumEvenFibonacci(int limit) {
        int sum = 0, a = 1, b = 2;
        while (b <= limit) {
            if (b % 2 == 0) sum += b;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return sum;
    }

    // Static method to check if a number is palindrome
    public static boolean isPalindrome(int num) {
        int original = num, reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return original == reverse;
    }

    // Main method
    public static void main(String[] args) {
        Main main = new Main();  // Call to the constructor

        // (a) Display prime numbers between 1 to 500
        System.out.println("Prime numbers between 1 and 500:");
        for (int i = 1; i <= 500; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // (b) Sum of even Fibonacci numbers not exceeding four million
        int sumEvenFibs = main.sumEvenFibonacci(4000000);
        System.out.println("Sum of even Fibonacci numbers not exceeding four million: " + sumEvenFibs);

        // (c) GUI to check if a number is a palindrome
        // We will use a simple Swing interface for this purpose
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    // GUI method to check for palindrome
    private static void createAndShowGUI() {
        javax.swing.JFrame frame = new javax.swing.JFrame("Palindrome Checker");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JTextField textField = new javax.swing.JTextField(10);
        javax.swing.JButton button = new javax.swing.JButton("Check");
        javax.swing.JLabel resultLabel = new javax.swing.JLabel();

        button.addActionListener(e -> {
            try {
                int num = Integer.parseInt(textField.getText());
                if (isPalindrome(num)) {
                    resultLabel.setText(num + " is a palindrome.");
                } else {
                    resultLabel.setText(num + " is not a palindrome.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid integer.");
            }
        });

        panel.add(new javax.swing.JLabel("Enter a number:"));
        panel.add(textField);
        panel.add(button);
        panel.add(resultLabel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
