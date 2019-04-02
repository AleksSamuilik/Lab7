import java.util.Scanner;

public class ArraysForBubbleSort {

    public static String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String arrayNumber = "";
        while (scanner.hasNextLine()) {
            boolean valid = true;
            arrayNumber = scanner.nextLine();
            String checkString = arrayNumber.replaceAll("[\\s-.]", "");
            for (int i = 0; i < checkString.length(); i++) {
                char digit = checkString.charAt(i);
                if (Character.isDigit(digit)) {
                    continue;
                } else {
                    System.out.println("Sorry. Try again");
                    valid = false;
                    break;
                }
            }
            if (valid) {
                break;
            }
        }
        return arrayNumber;
    }

    public static int countArrayLength(String numberArray) {
        numberArray = numberArray.trim();
        numberArray = numberArray.replaceAll("[-.]", "");
        int count = 1;
        for (int i = 0; i < numberArray.length(); i++) {
            char digit = numberArray.charAt(i);
            if (Character.isSpaceChar(digit)) {
                count++;
            }
        }
        return count;
    }

    public static double[] addArray(int count, String arrayNumber) throws Exception{
        StringBuilder builder = new StringBuilder();
        double[] arr = new double[count];
        String stringBuilder;
        double digitDouble;
        int j = 0;
        for (int i = 0; i < arrayNumber.length(); i++) {
            char digitChar = arrayNumber.charAt(i);
            if (Character.isSpaceChar(digitChar)) {
                stringBuilder = builder.toString();

                digitDouble = Double.parseDouble(stringBuilder);
                arr[j] = digitDouble;
                builder.setLength(0);
                j++;
            }
            builder.append(digitChar);
        }
        stringBuilder = builder.toString();
        digitDouble = Double.parseDouble(stringBuilder);
        arr[j] = digitDouble;
        return arr;
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

    public static void main(String[] args){
        System.out.println("This program prints an array of dimension N, filled with numbers.");
        System.out.println("Enter your array : ");
        String arrayNumber = readUserInput();
        int count = countArrayLength(arrayNumber);
        try {
          double []  arr = addArray(count, arrayNumber);
            bubbleSort(arr);
            printArray(arr);
        } catch (Exception e){
            System.out.println("Sorry. Try again.");
        }

    }
}
