//2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.Random;
import java.io.FileWriter;

public class ex2 {
    public static void main(String[] args) {

        int[] array = createRandomArray(10, 0, 11);
        System.out.print("Созданный массив:       ");
        System.out.println(showArray(array));
        int[] sortArray = bubbleSort(array);
        System.out.print("Отсортированный массив: ");
        System.out.println(showArray(sortArray));
    }

    static int[] createRandomArray(int size, int downBound, int upperBond) { 
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(upperBond) + downBound;
        }
        return array;
    }

    static String showArray(int[] array) {                                  
        return Arrays.toString(array);
    }
    static int[] bubbleSort(int[] array) {                                                                    
        int[] sortArray = Arrays.copyOf(array, array.length);
        int temp = 0;
        for (int i = 0; i < sortArray.length; i++) {
            for (int j = 0; j < sortArray.length - i - 1; j++) {
                if (sortArray[j] > sortArray[j + 1]) {
                    temp = sortArray[j+1];
                    sortArray[j + 1] = sortArray[j];
                    sortArray[j] = temp;                  
                }
            }
            WriteToFile(sortArray);
        }
        return sortArray;
    }
    static void WriteToFile(int[] array) {                                           
        try (FileWriter f = new FileWriter("logTask02.txt", true)) {
            f.write(Arrays.toString(array));
            f.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}