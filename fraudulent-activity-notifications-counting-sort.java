import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//url:https://www.hackerrank.com/challenges/fraudulent-activity-notifications/forum
public class Solution {

 // Complete the activityNotifications function below.
 static int activityNotifications(int[] expenditure, int d) {
  int count = 0;

  // ArrayList<Integer> listForMedian = new ArrayList<Integer>(d + 1);

  int[] arrForMedian = new int[200 + 1];

  Queue < Integer > prevPayments = new ArrayDeque < > (d + 1);

  for (int i = 0; i < d; ++i) {
   prevPayments.add(expenditure[i]);
   // listForMedian.add(expenditure[i]);
   ++arrForMedian[expenditure[i]];
  }

  // Collections.sort(listForMedian);
  for (int i = d; i < expenditure.length; ++i) {
   int currPayment = expenditure[i];
   // int limit = getLimit(listForMedian);
   int limit = getLimit(arrForMedian, d);

   if (currPayment >= limit)
    ++count;
   prevPayments.add(currPayment);
   ++arrForMedian[currPayment];
   --arrForMedian[prevPayments.poll()];
   //    correctCheckList(listForMedian, currPayment, prevPayments.poll());

  }


  return count;


 }

 static int getLimit(int[] median, int len) {
  boolean even = (len % 2 == 0);
  int midle = len / 2;
  int count = -1;
  int prev = 0;
  for (int i = 0; i < median.length; ++i) {
   int curr = median[i];
   if (curr > 0) {
    count += curr;
    if (count >= midle) {

     if (!even)
      return 2 * i;

     int prevCount = count - curr;

     if (midle > prevCount + 1)
      return i + i;

     return prev + i;

    }
    prev = i;
   }
  }
  return 0;
 }
 private static final Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) throws IOException {
  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

  String[] nd = scanner.nextLine().split(" ");

  int n = Integer.parseInt(nd[0]);

  int d = Integer.parseInt(nd[1]);

  int[] expenditure = new int[n];

  String[] expenditureItems = scanner.nextLine().split(" ");
  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

  for (int i = 0; i < n; i++) {
   int expenditureItem = Integer.parseInt(expenditureItems[i]);
   expenditure[i] = expenditureItem;
  }

  int result = activityNotifications(expenditure, d);

  bufferedWriter.write(String.valueOf(result));
  bufferedWriter.newLine();

  bufferedWriter.close();

  scanner.close();
 }
}
