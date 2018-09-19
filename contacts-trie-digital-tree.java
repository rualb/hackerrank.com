import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


//url:https://www.hackerrank.com/challenges/contacts/problem
public class Solution {



    static class DigitalTreeNode{

        public char code;
        public int count;
        public HashMap<Character, DigitalTreeNode> nodes=new HashMap<>();
 


            public static void add(DigitalTreeNode root,String str){
                    DigitalTreeNode tmp = root;
                    for(char ch:str.toCharArray()){
                    DigitalTreeNode x = tmp.nodes.get(ch);
                    if(x == null){
                        tmp.nodes.put(ch,x =new DigitalTreeNode());
                        x.count=0;
                        x.code=ch;
                    }
                    x.count+=1;
                    tmp = x;
                    }
            }

            public static int countByPrefix(DigitalTreeNode root,String prefix){
            
                    DigitalTreeNode tmp = root;
                    for(char ch:prefix.toCharArray()){
                            DigitalTreeNode x = tmp.nodes.get(ch);
                            if(x == null){
                                return 0;
                            }
                    tmp = x;
                    }

            return tmp.count;
                }

    }

    
    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */

         DigitalTreeNode root= new DigitalTreeNode();
         ArrayList<Integer> list= new ArrayList();

          HashMap<String,Integer> map = new HashMap<>();

         for(int i=0;i<queries.length;++i){

                String[] cmd=queries[i];

                if(cmd[0].equals("find")){
                    list.add(DigitalTreeNode.countByPrefix(root,cmd[1]));
                }else
                {
                    DigitalTreeNode.add(root,cmd[1]);
                }
        }
 
 
         int[] res = new int[list.size()];

         for(int i=0;i<res.length;++i)
            res[i] = list.get(i);

        return res;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

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
