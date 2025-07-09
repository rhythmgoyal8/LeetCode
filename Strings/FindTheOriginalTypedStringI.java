//package Strings;

import java.util.*;

public class FindTheOriginalTypedStringI {
    public static int possibleStringCount(String word) {
        char[] arr = word.toCharArray(); 
        int count = 1;  // Always include the original word

        for (int i = 0; i < arr.length;) {
            int j = i;
            while (j < arr.length && arr[j] == arr[i]) {
                j++;
            }
            int freq = j - i;
            if (freq > 1) {
                count += (freq - 1);  // Add (freq - 1) for repeated chars
            }
            i = j;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        int result = possibleStringCount(input);
        System.out.println("Possible string count: " + result);
        scanner.close();
    }
}
