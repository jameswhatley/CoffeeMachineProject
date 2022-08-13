import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Gets array size
        int arraySize = scanner.nextInt();

        int[] numbers = new int[arraySize];

        //Populates array
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = scanner.nextInt();
        }

        //Search for this int
        int chosenNum = scanner.nextInt();

        //Gets result
        boolean arrayContains = false;

        for (int i = 0; i < arraySize; i++) {
            if (numbers[i] == chosenNum) {
                arrayContains = true;
                break;
            }
        }
        System.out.println(arrayContains);
    }
}