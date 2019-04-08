import java.util.Scanner;


public class ArraysForBubbleSort {
    private static String[] readUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String stringNumber = scanner.nextLine();
            stringNumber = stringNumber.trim();
            String[] checkString = stringNumber.split("\\s+");
            if (hasOnlyNumbers(checkString)) {
                return checkString;
            }
            System.out.println("Sorry. Try again");
        }
    }

    private static boolean hasOnlyNumbers(String[] checkString) {
        for (String string : checkString) {
            try {
                Double.parseDouble(string);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static double[] doubleArray(String[] stringArray) {
        double[] doubleArray = new double[stringArray.length];
        int j = 0;
        for (String retval : stringArray) {
            doubleArray[j] = Double.parseDouble(retval);
            j++;
        }
        return doubleArray;
    }

    public static void printArray(double[] arr) {
        int i = 0;
        for (double xxx : arr) {
            i++;
            System.out.println(i + ": " + xxx);
        }
    }

    public static void bubbleSort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean valid = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    valid = false;
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (valid) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("This program prints an array of dimension N, filled with numbers.");
        System.out.println("Enter your array : ");
        String[] stringArray = readUserInput();
       double [] arr= doubleArray(stringArray);
        bubbleSort(arr);
        printArray(arr);
    }
}
