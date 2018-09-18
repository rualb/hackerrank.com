using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace solved
{
        
          //url:https://www.hackerrank.com/challenges/game-of-two-stacks/problem
        public class hackerrank_com_game_of_two_stacks
        {
 
            //implemented as communicating vessels
            public static int twoStacks(int x, int[] a, int[] b)
            {
 
                int countMax = 0;
                int sum = 0;
                int i1 = 0;
                int i2 = 0;

                int len1 = a.Length;
                int len2 = b.Length;

                //fill by a
                for (; i1 < len1; ++i1)
                {
                    if (sum + a[i1] > x)
                    {
                        break;
                    }
                    sum += a[i1];
                }

                --i1;//may be a[] is empty 
                countMax = Math.Max(countMax, i1 + 1);
                //fill by b,remove from a

                for (; i2 < len2; ++i2)
                {
                    sum += b[i2];
                    //0
                    if (sum > x)
                    {
                        while (i1 >= 0)
                        {
                            sum -= a[i1];
                            --i1;

                            if (sum <= x)
                                break;
                        }
                    }
                    //1
                    if (sum > x && i1 < 0)
                        break;
                    //2
                    if (sum <= x)
                    {
                        countMax = Math.Max(countMax, (i1 + 1) + (i2 + 1));
                    }
                }
                return countMax;
            }
        }

}
