import java.util.Date;

public class AwardedMilitary extends MilitaryPerson {
    private String awardName;     // Название награды
    private double prize;          // Премия
    private double bonus;         // Сумма надбавки

    // Конструктор
    public AwardedMilitary(String lastName, String company, String rank,
                           Date dateOfBirth, Date enlistmentDate, String unit,
                           String awardName, double prize, double bonus) {
        super(lastName, company, rank, dateOfBirth, enlistmentDate, unit);
        this.awardName = awardName;
        this.prize = prize;
        this.bonus = bonus;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return super.toString() + String.format(
                "  Название награды: %s\n" +
                        "  Премия: %.2f\n" +
                        "  Сумма надбавки: %.2f\n",
                awardName, prize, bonus
        );
    }
}
