import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//url::https://www.hackerrank.com/challenges/richie-rich/problem
public class Solution {

 // Complete the highestValuePalindrome function below.
 static String highestValuePalindrome(String str, int n, int k) {

  StringBuilder sb = new StringBuilder(str);

  ArrayList < Integer > changes = new ArrayList < > ();

  int count = 0;
  for (int i = 0; i < sb.length() / 2; ++i) {

   int indxLeft = i;
   int indxRight = sb.length() - 1 - indxLeft;

   char left = sb.charAt(indxLeft);
   char right = sb.charAt(indxRight);

   if (left != right) {
    if (count >= k) {
     sb = null;
     break;
    }

    if (left > right) {
     sb.setCharAt(indxRight, left);
    } else {
     sb.setCharAt(indxLeft, right);
    }

    changes.add(indxLeft);

    ++count;

   }


  }


  if (count < k - 1) //have
  {
   for (int i = 0; i < sb.length() / 2 && count < k - 1; ++i) {

    int indxLeft = i;
    int indxRight = sb.length() - 1 - indxLeft;

    char left = sb.charAt(indxLeft);
    //char right=sb.charAt(indxRight);

    if (left != '9') {
     sb.setCharAt(indxLeft, '9');
     sb.setCharAt(indxRight, '9');
     count += 2;
     //
     if (changes.contains(i)) {
      --count;
      changes.remove((Object) i);
     }
    }

   }
  }

  //if changes has one index you may applay it to index
  if (count < k && changes.size() > 0) //have
  {

   for (int i = 0; i < changes.size(); ++i) {

    if (count == k)
     break;

    int indxLeft = changes.get(i);
    int indxRight = sb.length() - 1 - indxLeft;

    char left = sb.charAt(indxLeft);
    //char right=sb.charAt(indxRight);

    if (left != '9') {
     //--count;
     sb.setCharAt(indxLeft, '9');
     //++count;
     sb.setCharAt(indxRight, '9');
     ++count;
    }

   }


  }

  if (count < k) //have
  {
   //middle of string
   if (sb.length() % 2 == 1) {
    sb.setCharAt(sb.length() / 2, '9');
    ++count;
   }
  }

  return sb == null ? "-1" : sb.toString();

 }

 private static final Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) throws IOException {
  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

  String[] nk = scanner.nextLine().split(" ");

  int n = Integer.parseInt(nk[0]);

  int k = Integer.parseInt(nk[1]);

  String s = scanner.nextLine();

  String result = highestValuePalindrome(s, n, k);

  bufferedWriter.write(result);
  bufferedWriter.newLine();

  bufferedWriter.close();

  scanner.close();
 }
}
