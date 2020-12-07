public class Main {
    public static void main(String[] args) {
        Book book = new Book("Александр", "Пушкин", "2020", "Евгений Онегин");
        WorkWithFile.serialization(book);
        Book book2 = WorkWithFile.deserialization();
        System.out.println(book2);
    }
}
