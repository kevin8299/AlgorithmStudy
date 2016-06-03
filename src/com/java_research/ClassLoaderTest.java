package com.java_research;

import java.io.*;

/**
 * Created by Administrator on 2016/5/7.
 */
public class ClassLoaderTest extends ClassLoader {
    private String classPath;
    String classname = "aa";

    public ClassLoaderTest(String classPath) {
        this.classPath = classPath;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(classname, classData, 0, classData.length);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + className;
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer, 0, num);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try{
            String path = "D:\\shanghai\\new20160321\\AlgorithmStudy\\out\\production\\AlgorithmStudy\\com\\java_research\\";
            ClassLoaderTest loader1 = new ClassLoaderTest(path);
            Class c1 = loader1.findClass("ClassTest.class");
            System.out.println(c1.newInstance());
            ClassLoaderTest loader2 = new ClassLoaderTest(path);
            Class c2 = loader2.findClass("ClassTest.class");
            System.out.println(c2.newInstance());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
