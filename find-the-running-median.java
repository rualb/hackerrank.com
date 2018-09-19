import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


//url:https://www.hackerrank.com/challenges/find-the-running-median/problem
//input
/*
*/
//desc
/*
get median from stream
*/
public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */

        //a[] should be a stream

        if(a.length == 0)
            return new double[]{a[0]};

         if(a.length == 2)
            return new double[]{a[0],((double)a[0]+(double)a[1])/2.0};

        double[] res = new double[a.length];
 
        //sorted queue (reverse)
        PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right=new PriorityQueue<>();
 

        if(a[0]<a[1])
        {
            left.add(  a[0]);
            right.add(  a[1]);
        }else
        {
            left.add(  a[1]);
            right.add( a[0]);
        }

        res[0] =a[0];
        res[1] =(a[0]+a[1])/2.0;

        for(int i=2;i<a.length;++i){

        int x =a[i];

        if(x<left.peek()){
            left.add(x);
        }else
        {
            right.add(x);
        }

//balance
        if(left.size()-right.size()>1){
right.add(left.poll());
        }else
        if(right.size()-left.size()>1){
left.add(right.poll());
        }

//calc
        if(left.size() == right.size())
            res[i] = (left.peek()+right.peek())/2.0;
        if(left.size() > right.size())
            res[i] =  left.peek() ;
            else
        if(right.size() > left.size())
            res[i] = right.peek() ;

        }
 
         return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
