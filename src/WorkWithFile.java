import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class WorkWithFile {
    private static Book serializabl1(Book book) {
        Class<?> testBook = book.getClass();
        Book tempBook = new Book();
        Field[] fileds = testBook.getFields();
        for (Field f : fileds) {
            if (f.isAnnotationPresent(Annotation.class)) {
                if (Modifier.isPrivate(f.getModifiers())) {
                    f.setAccessible(true);
                }
                try {
                    String method1 = "set" + f.getName();
                    Method[] methods = testBook.getDeclaredMethods();
                    for (int i = 0; i < methods.length; i++) {
                        if (methods[i].getName().equalsIgnoreCase(method1)) {
                            try {
                                methods[i].invoke(tempBook, f.get(book));
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return tempBook;
    }

    public static void serialization(Book book) {
        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("fil"))) {
            OOS.writeObject(serializabl1(book));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Book deserialization() {
        Book book = null;
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("fil"))) {
            book = (Book) OIS.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return book;
    }
}
