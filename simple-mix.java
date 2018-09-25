import java.io.BufferedWriter;
import java.io.Console;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.*;


public class Main {

        
        public static void longest_increasing_subsequence_via_dyn() {

        Integer[] arr = {3, 4, -1, 0, 6, 2, 3};
        Integer[] buf = new Integer[arr.length];

        //init
        for (int i1 = 0; i1 < arr.length; ++i1) {
            if (buf[i1] == null)
                buf[i1] = 1;
        }

        for (int i1 = 0; i1 < arr.length-1; ++i1) {

            for (int i2 = 0; i2 <= i1; ++i2) {

                if (arr[i1+1] > arr[i2] && buf[i2] + 1 > buf[i1+1])
                    buf[i1+1] = buf[i2] + 1;

            }

        }

        int max = -1;
        for (Integer x : buf)
            max = Math.max(max, x);

        System.out.println(max);

    }
        
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
