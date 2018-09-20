
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//url:https://www.hackerrank.com/challenges/two-characters/problem
//input:
/*
10
beabeefeab
*/
//output:
/*
babab
*/
public class Solution {

    // Complete the alternate function below.
    static int alternate(String s) {

 
        char[] charArr = s.toCharArray();

        int[] arrCount=new int[((byte)'z')+1];

        for(char ch:s.toCharArray()){ 
            arrCount[(byte)ch]+=1;
        }
 
        int maxLen=0;
        for(int i1=0;i1<charArr.length;++i1)
        {
            char ch1= charArr[i1];
            for(int i2=i1+1;i2<charArr.length;++i2)
            {
                char ch2 = charArr[i2];
                if(ch1 == ch2)
                    break;

                //validate possible result
                boolean ok=true;
                {
                    char prev = ' ';
                    for(char x:charArr){
                        if(x == ch1 || x == ch2){
                            if(prev == x){
                                ok=false;
                                break;
                            }
                            prev = x;
                        }
                    }

                }
                if(ok)
                    maxLen = Math.max(maxLen,arrCount[(byte)ch1]+arrCount[(byte)ch2]);
            }
        }

        return maxLen;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
