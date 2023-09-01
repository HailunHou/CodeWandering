/**
 * @author BOOM
 * @create 2023-08-28 10:32
 */
package com.hhl.test.classLoaderTest;

/**
 @author boom
 @create 2023-08-28 10:32
 */
public class MyClass {
    public static void main(String[] args) {
        String path = "G:\\ideaWorkSpace\\CodeWandering\\out\\production\\CodeWandering";
        MyLoader myLoader = new MyLoader(path);
        try {
            // 尝试加载Java核心类库中的类
            Class<?> systemClass = myLoader.loadClass("java.lang.Boolean");
            System.out.println("系统核心类库中的类加载成功：" + systemClass.getName());
        } catch (ClassNotFoundException e) {
            System.err.println("系统核心类库中的类加载失败：" + e.getMessage());
        }

//        try {
//            // 尝试加载自定义类
//            Class<?> customClass = myLoader.loadClass("com.hhl.test.classLoaderTest.MyClass");
//            System.out.println("自定义类加载成功：" + customClass.getName());
//        } catch (ClassNotFoundException e) {
//            System.err.println("自定义类加载失败：" + e.getMessage());
//        }
    }
}
