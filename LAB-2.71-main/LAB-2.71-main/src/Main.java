import java.io.BufferedReader; // импортируем класс BufferedReader для чтения файла
import java.io.FileReader; // импортируем класс FileReader для чтения данных из файла
import java.io.IOException; // импортируем класс IOException для обработки ошибок ввода-вывода
import java.util.Formatter; // импортируем класс Formatter для форматирования вывода

public class Main { // определяем публичный класс Main

    public static void main(String[] args) { // определяем метод main с аргументом типа массив строк
        Student[] students = new Student[50]; // создаем массив объектов типа Student

        try { // начало блока кода, в котором может возникнуть исключение
            FileReader fileReader = new FileReader("C:\\Users\\Admin\\Desktop\\lab1\\src\\list.txt"); // создаем объект типа FileReader, чтобы прочитать данные из файла с указанным путем
            BufferedReader bufferedReader = new BufferedReader(fileReader); // создаем объект типа BufferedReader, который обеспечивает буферизованное чтение данных из файла

            for(int i = 0; i < students.length; i++) { // начинаем цикл for, который будет выполняться 50 раз, по количеству элементов в массиве students
                students[i] = new Student(); // создаем новый объект типа Student
                students[i].readingFile(bufferedReader); // вызываем метод readingFile для каждого объекта Student, чтобы прочитать данные из файла
            }

            Formatter form = new Formatter(System.out); // создаем новый объект типа Formatter, который будет использоваться для форматирования вывода
            for(int i = 0; i < students.length; i++) { // начинаем цикл for, который будет выполняться 50 раз, по количеству элементов в массиве students
                students[i].writeTable(form); // вызываем метод writeTable для каждого объекта Student, чтобы записать данные в форматированную таблицу
            }

            bufferedReader.close(); // закрываем BufferedReader, чтобы освободить ресурсы
        } catch (IOException e) { // перехватываем исключение IOException
            System.out.println("Error " + e.getMessage()); // выводим сообщение об ошибке в консоль
        }
    }
}
