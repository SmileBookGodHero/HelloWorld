package com.shrbank.test;

import java.io.*;

/**
 * Created by lilei on 2017/11/6 下午4:42.
 */
public class ExternalizableTest implements Externalizable{
    private transient String content = "不管有没有被 transient 修饰，都将被序列化";

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException,ClassNotFoundException {
        content = (String) objectInput.readObject();
    }

    public static void main(String[] args) throws Exception {
        ExternalizableTest externalizableTest = new ExternalizableTest();
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(new File("test")));
        objectOutput.writeObject(externalizableTest);
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream(new File("test")));
        externalizableTest = (ExternalizableTest) objectInput.readObject();
        System.out.println(externalizableTest.content);
        objectOutput.close();
        objectInput.close();
    }
}