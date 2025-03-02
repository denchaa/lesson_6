import java.util.Date;

public class MilitaryManagement extends MilitaryPerson {
    private String district;       // Название округа
    private String position;       // Должность
    private int yearsOfService;    // Выслуга лет
    private double bonus;          // Сумма надбавки

    // Конструктор
    public MilitaryManagement(String lastName, String company, String rank,
                              Date dateOfBirth, Date enlistmentDate, String unit,
                              String district, String position, int yearsOfService, double bonus) {
        super(lastName, company, rank, dateOfBirth, enlistmentDate, unit);
        this.district = district;
        this.position = position;
        this.yearsOfService = yearsOfService;
        this.bonus = bonus;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return super.toString() + String.format(
                "  Название округа: %s\n" +
                        "  Должность: %s\n" +
                        "  Выслуга лет: %d\n" +
                        "  Сумма надбавки: %.2f\n",
                district, position, yearsOfService, bonus
        );
    }
}
