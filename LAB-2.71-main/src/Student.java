import java.io.BufferedReader; // импортируем класс BufferedReader из пакета java.io для чтения символов из потока ввода
import java.io.IOException; // импортируем класс IOException из пакета java.io для обработки исключительных ситуаций ввода-вывода
import java.util.Formatter; // импортируем класс Formatter из пакета java.util для форматирования текстового вывода

public class Student {
    private String name; // имя студента
    private String surname; // фамилия студента
    private String faculty; // факультет студента
    private int birth; // год рождения студента
    private int entering; // год поступления студента
    private int ID; // идентификатор студента

    public Student() { // конструктор по умолчанию
        name = "None"; // устанавливаем имя "None"
        surname = "None"; // устанавливаем фамилию "None"
        faculty = "None"; // устанавливаем факультет "None"
        birth = 0; // устанавливаем год рождения равным 0
        entering = 0; // устанавливаем год поступления равным 0
        ID = 0; // устанавливаем идентификатор равным 0
    }

    public Student(Student other) { // конструктор копирования
        name = other.name; // копируем имя из другого объекта
        surname = other.surname; // копируем фамилию из другого объекта
        faculty = other.faculty; // копируем факультет из другого объекта
        birth = other.birth; // копируем год рождения из другого объекта
        entering = other.entering; // копируем год поступления из другого объекта
        ID = other.ID; // копируем идентификатор из другого объекта
    }

    public Student clone() { // метод для создания копии объекта
        return new Student(this); // возвращаем новый объект типа Student, который создается на основе текущего объекта
    }

    public boolean equal(Student other) { // метод для проверки равенства объектов
        return (name.equals(other.name) && // сравниваем имя текущего объекта с именем другого объекта
                surname.equals(other.surname) && // сравниваем фамилию текущего объекта с фамилией другого объекта
                faculty.equals(other.faculty) && // сравниваем факультет текущего объекта с факультетом другого объекта
                birth == other.birth && // сравниваем год рождения текущего объекта с годом рождения другого объекта
                entering == other.entering && // сравниваем год поступления текущего объекта с годом поступления другого объекта
                ID == other.ID); // сравниваем идентификатор текущего объекта с идентифик

    }

    public void readingFile(BufferedReader reader) throws IOException {
        // читаем строку из файла
        String line = reader.readLine();
        // разбиваем строку на поля, используя запятую в качестве разделителя
        String[] fields = line.split(",");

        name = fields[0]; // Присваиваем первое поле из файла имени
        surname = fields[1]; // Присваиваем второе поле из файла фамилии
        faculty = fields[2]; // Присваиваем третье поле из файла факультета
        birth = Integer.parseInt(fields[3]); // Преобразуем четвертое поле из файла в целое число и присваиваем его дате рождения
        entering = Integer.parseInt(fields[4]); // Преобразуем пятое поле из файла в целое число и присваиваем его году поступления
        ID = Integer.parseInt(fields[5]); // Преобразуем шестое поле из файла в целое число и присваиваем его идентификатору студента
    }

    public void writeElement() { // Описываем метод вывода элемента на консоль
        System.out.println(name + ", " + // Выводим наименование поля "имя"
                surname + ", " + // Выводим наименование поля "фамилия"
                faculty + ", " + // Выводим наименование поля "факультет"
                birth + ", " + // Выводим наименование поля "дата рождения"
                entering + ", " + // Выводим наименование поля "год поступления"
                ID); // Выводим наименование поля "идентификатор студента"
    }

    public void writeTable(Formatter formatter) {
        // форматируем и выводим поля объекта, используя переданный объект Formatter для вывода
        formatter.format("%-15s %-15s %-15s %-10d %-10d %-4d\n", name, surname, faculty, birth, entering, ID);
    }

}
