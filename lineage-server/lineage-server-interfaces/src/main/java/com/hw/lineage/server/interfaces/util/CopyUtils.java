package com.hw.lineage.server.interfaces.util;

import java.io.*;

/**
 * @description: CopyUtils
 * @author: HamaWhite
 */
public class CopyUtils {

    private CopyUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static<T> T deepClone(T source) throws IOException, ClassNotFoundException {
        Object obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(source);
        objectOutputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        obj = objectInputStream.readObject();
        objectInputStream.close();
        return (T) obj;
    }
}
