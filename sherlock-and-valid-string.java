import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//url:https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class Solution {

 // Complete the isValid function below.
 static String isValid(String s) {

  int[] arr = new int[26];

  for (char x: s.toCharArray()) {
   ++arr[(byte) x - (byte)'a'];
  }

  int min = Integer.MAX_VALUE;
  int max = Integer.MIN_VALUE;

  for (int x: arr) {
   if (x > 0 && x < min)
    min = x;

   if (x > 0 && x > max)
    max = x;
  }

  if (min == max)
   return "YES";

  int minCount = 0;
  int maxCount = 0;

  for (int x: arr) {

   if (min < x && x < max)
    return "NO";

   if (x > 0 && x == min)
    ++minCount;
   if (x > 0 && x == max)
    ++maxCount;
  }
  if (minCount == 1 && maxCount == 1) {
   if (Math.abs(min - max) == 1)
    return "YES";
  }
  if (minCount == 1 && maxCount == 1) {
   if (Math.abs(min - max) == 1)
    return "YES";
   else
    return "NO";
  }
  if (minCount == 1 && maxCount > 1) {
   if (min == 1)
    return "YES";
   else
    return "NO";
  }

  if (minCount > 1 && maxCount == 1) {
   if (max - min == 1)
    return "YES";
   else
    return "NO";
  }

  return "NO";

 }

 private static final Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) throws IOException {
  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

  String s = scanner.nextLine();

  String result = isValid(s);

  bufferedWriter.write(result);
  bufferedWriter.newLine();

  bufferedWriter.close();

  scanner.close();
 }
}
