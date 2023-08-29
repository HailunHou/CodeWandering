/**
 * @author BOOM
 * @create 2023-08-28 10:22
 */
package com.hhl.test.classLoaderTest;

import java.io.*;

/**
 @author boom
 @create 2023-08-28 10:22
 */
public class MyLoader extends ClassLoader{
    private String path;

    public MyLoader(String path) {
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // 为什么这里执行了三次
        System.out.println("自定类加载器...in");
        System.out.println(name);
        Class<?> loaderClass = findLoadedClass(name);
        if(loaderClass != null){
            return loaderClass;
        }
        if(!name.startsWith("java.")){
            if(name.endsWith("MyClass")){
                System.out.println("自定类加载器...");
                try {
                    byte[] classData = getClassData(name);
                    if(classData != null){
                        return defineClass(name, classData, 0, classData.length);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return super.loadClass(name, resolve);
    }

    private byte[] getClassData(String name) throws IOException {
        String classPath = path + File.separator + name.replace('.', File.separatorChar) + ".class";
        try(InputStream is = new FileInputStream(classPath);
            ByteArrayOutputStream os = new ByteArrayOutputStream()){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = is.read(buffer)) != -1){
                os.write(buffer, 0, bytesRead);
            }
            return os.toByteArray();
        }
    }
}
