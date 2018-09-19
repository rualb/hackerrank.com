import java.io.*;
import java.util.*;


//url:https://www.hackerrank.com/challenges/no-prefix-set/problem
//input:
/*
4
aab
aac
aacghgh
aabghgh
*/
public class Solution {

 static String[] test(String[] queries) {
  DigitalTreeNode root = new DigitalTreeNode();

  for (String str: queries) {

   if (DigitalTreeNode.addAndTest(root, str))
    return new String[] {
     "BAD SET",
     str
    };

  }


  return new String[] {
   "GOOD SET"
  };

 }

 static class DigitalTreeNode {

  public char code;
  public int count;
  public HashMap < Character, DigitalTreeNode > nodes = new HashMap < > ();



  public static boolean addAndTest(DigitalTreeNode root, String str) {

   //[abc] [abcd] = > bad, create node for wiohout child nodes 
   //[abcd] [abc] = > bad, no node created used existing

   boolean fork = false;
   boolean allNodeNew = true;

   DigitalTreeNode tmp = root;
   for (char ch: str.toCharArray()) {
    DigitalTreeNode x = tmp.nodes.get(ch);
    if (x == null) {

     if (tmp.nodes.size() >= 1)
      fork = true;

     tmp.nodes.put(ch, x = new DigitalTreeNode());
     x.count = 0;
     x.code = ch;

    } else
     allNodeNew = false;



    x.count += 1;
    tmp = x;


   }

   if (fork || allNodeNew)
    return false;

   return true;
  }







 }
 private static final Scanner scanner = new Scanner(System.in);
 public static void main(String[] args) throws IOException {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

  int queriesRows = Integer.parseInt(scanner.nextLine().trim());

  String[] queries = new String[queriesRows];

  for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
   queries[queriesRowItr] = scanner.nextLine();
  }

  String[] result = test(queries);

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
