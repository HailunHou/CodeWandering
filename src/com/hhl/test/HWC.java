/**
 * @author BOOM
 * @create 2023-08-19 16:32
 */
package com.hhl.test;

import java.util.*;

/**
 @author boom
 @create 2023-08-19 16:32
 */
public class HWC {
    static Map<Character, ArrayList<Character>> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.nextLine();
        }
        in.close();
        List<Character> characters = Arrays.asList('b', 'd', 'p', 'q');
        map.put(new Character('b'), (ArrayList<Character>) characters);
        map.put(new Character('d'), (ArrayList<Character>) characters);
        map.put(new Character('p'), (ArrayList<Character>) characters);
        map.put(new Character('q'), (ArrayList<Character>) characters);
        System.out.println(map.containsKey(new Character('b')));


    }

    public boolean solution(String strs[]){
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            if(isPal(chars)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
        return true;
    }

    public boolean isPal(char[] chars) {
        int left=0;
        int right=chars.length-1;
        while(left < right){
//            if(){
//
//            }
        }
        return true;
    }
}
