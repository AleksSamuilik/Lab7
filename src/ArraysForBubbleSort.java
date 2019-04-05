import java.util.Scanner;


public class ArraysForBubbleSort {

    private static String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String arrayNumber = scanner.nextLine();
            arrayNumber = arrayNumber.trim();
            if (hasOnlyAllowedChars(arrayNumber)&&hasOnlyNumber(arrayNumber)) {
                return arrayNumber;
            }
            System.out.println("Sorry. Try again");
        }
    }

    private static boolean hasOnlyAllowedChars(String input) {
        for (String checkString : input.split("\\s+")) {
                checkString=checkString.replaceFirst("[.]","");
                checkString=checkString.replaceFirst("[-]","");
            for (int i = 0; i < checkString.length(); i++) {
                char digit = checkString.charAt(i);
                if (!Character.isDigit(digit)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean hasOnlyNumber(String input) {
        double checkNumber;
        for (String checkString : input.split("\\s+")) {
            try {
                checkNumber = Double.parseDouble(checkString);
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

    public static int countArrayLength(String numberArray) {
        numberArray = numberArray.trim().replaceAll("\\s+", " ");
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

    public static double[] addArray(int count, String arrayNumber) {
        double[] arr = new double[count];
        double digitDouble;
        int j = 0;
        for (String retval : arrayNumber.split("\\s+")) {
            digitDouble = Double.parseDouble(retval);
            arr[j] = digitDouble;
            j++;
        }
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

    public static void main(String[] args) {
        System.out.println("This program prints an array of dimension N, filled with numbers.");
        System.out.println("Enter your array : ");
        String arrayNumber = readUserInput();
        int count = countArrayLength(arrayNumber);
        double[] arr = addArray(count, arrayNumber);
        bubbleSort(arr);
        printArray(arr);
    }
}
