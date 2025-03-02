import java.text.SimpleDateFormat;
import java.util.Date;

public class MilitaryPerson {
    // Свойства
    private String lastName;       // Фамилия
    private String company;        // Рота
    private String rank;           // Звание
    private Date dateOfBirth;      // Дата рождения
    private Date enlistmentDate;   // Дата поступления на службу
    private String unit;           // Часть

    // Конструктор
    public MilitaryPerson(String lastName, String company, String rank,
                          Date dateOfBirth, Date enlistmentDate, String unit) {
        this.lastName = lastName;
        this.company = company;
        this.rank = rank;
        this.dateOfBirth = dateOfBirth;
        this.enlistmentDate = enlistmentDate;
        this.unit = unit;
    }

    // Геттеры
    public String getLastName() {
        return lastName;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return String.format(
                "Военный состав:\n" +
                        "  Фамилия: %s\n" +
                        "  Рота: %s\n" +
                        "  Звание: %s\n" +
                        "  Дата рождения: %s\n" +
                        "  Дата поступления на службу: %s\n" +
                        "  Часть: %s\n",
                lastName, company, rank,
                dateFormat.format(dateOfBirth),
                dateFormat.format(enlistmentDate),
                unit
        );
    }
}

