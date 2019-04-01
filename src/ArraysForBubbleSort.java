import java.util.Scanner;

public class ArraysForBubbleSort {

    public static int toPrint() {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        try {

            int xxx = Integer.parseInt(string);
            if (xxx > 0 && xxx < 1000000) {
                return xxx;
            } else
                System.out.println("Sorry. Restart the program and try again!");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Sorry. Restart the program and try again!");
            System.exit(0);
        }
        return 0;
    }

    public static double toArrayNumber(int i) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Assign number to index " + i);
        boolean count = true;
        while (count) {
            String strin = scan.nextLine();
            try {
                double xxx = Double.parseDouble(strin);
                if (xxx < Integer.MAX_VALUE) {
                    count = false;
                    return xxx;
                } else
                    System.out.println("Sorry. Try again!");
            } catch (NumberFormatException e) {
                System.out.println("Sorry.Try again!");

            }
        }
        scan.close();
        return 0;
    }

    public static void printArray(double[] arr) {
        int i = 0;
        for (double xxx : arr) {
            i++;
            System.out.println(i + ": " + xxx);
        }
    }


    private static void bubbleSort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("This program prints an array of dimension N, filled with numbers.");
        System.out.println("write number from 1 before 1000000: ");
        int n = toPrint();
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            double xxx = toArrayNumber(i);
            arr[i] = xxx;
        }
        bubbleSort(arr);
        printArray(arr);
    }

}
