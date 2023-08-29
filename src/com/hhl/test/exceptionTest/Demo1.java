/**
 * @author BOOM
 * @create 2023-08-29 16:56
 */
package com.hhl.test.exceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 @author boom
 @create 2023-08-29 16:56
 */
public class Demo1 {
    public static void main(String[] args) {
        File file = new File("output.txt");
        try {
            FileInputStream is = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int idx = 0;
            while((idx=is.read(bytes)) != -1){

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
