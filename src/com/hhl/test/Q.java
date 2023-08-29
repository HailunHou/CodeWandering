/**
 * @author BOOM
 * @create 2023-08-06 19:14
 */
package com.hhl.test;

import java.util.LinkedList;
import java.util.List;

/**
 @author boom
 @create 2023-08-06 19:14
 */
public class Q {
    public static void main(String[] args) {
        System.out.println(crop(new int[][]{
                {2,3,1,4},
                {1,2,0,3},
                {4,2,1,7},
                {3,1,4,2}
        }));
    }
    public static int crop(int[][] inp){
        int rowMax = Integer.MIN_VALUE;
        int colMax = Integer.MIN_VALUE;
        int rowid = 0;
//        int colid = 0;
        int all = 0;
        for(int i=0; i<inp.length; i++){
            int sum = 0;
            for(int j=0; j<inp[0].length; j++){
                sum += inp[i][j];
                all += inp[i][j];
            }
            if(rowMax < sum){
                rowMax = sum;
                rowid = i;
            }
        }
//        System.out.println("rowMax = " + rowMax);
//        System.out.println("rowid = " + rowid);
        for(int i=0; i<inp[0].length; i++){
            int sum = 0;
            for(int j=0; j<inp.length; j++){
                if(j == rowid){
                    continue;
                }
                sum += inp[j][i];
            }
            if(colMax < sum){
                colMax = sum;
//                colid = i;
            }
        }
//        System.out.println("colMax = " + colMax);
//        System.out.println("colid = " + colid);
//        int res = all+colMax+rowMax;
        return all+colMax+rowMax;
//        return rowMax*2+colMax*2;
    }


}
