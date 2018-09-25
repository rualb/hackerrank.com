import java.io.BufferedWriter;
import java.io.Console;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.*;


public class Main {

public static void longest_increasing_subsequence_via_stack(){

        Integer[] arr = {3, 4, -1, 0, 6, 2, 3};


        Stack<Integer> stack = new Stack<>();

        int max = -1;
        for (int i = 0; i < arr.length; ++i) {

            if (stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            if (arr[i] > arr[stack.peek()]) {
                stack.add(i);
            }

            if (i == arr.length - 1) {
                if(stack.isEmpty())
                    break;

                max = Math.max(max, stack.size());
//
                for(Integer x:stack)
                    System.out.print(arr[x]+" ");

                System.out.println();
//
                int prev = stack.pop();
                i = prev;


            }
 
        }

    }

}
