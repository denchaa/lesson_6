import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractService extends MilitaryPerson {
    private String contractPeriod; // Период договора
    private Date contractDate;    // Дата договора
    private String protocolNumber; // Номер протокола
    private double salary;         // Сумма зарплаты

    // Конструктор
    public ContractService(String lastName, String company, String rank,
                           Date dateOfBirth, Date enlistmentDate, String unit,
                           String contractPeriod, Date contractDate, String protocolNumber, double salary) {
        super(lastName, company, rank, dateOfBirth, enlistmentDate, unit);
        this.contractPeriod = contractPeriod;
        this.contractDate = contractDate;
        this.protocolNumber = protocolNumber;
        this.salary = salary;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return super.toString() + String.format(
                "  Период договора: %s\n" +
                        "  Дата договора: %s\n" +
                        "  Номер протокола: %s\n" +
                        "  Сумма зарплаты: %.2f\n",
                contractPeriod, dateFormat.format(contractDate), protocolNumber, salary
        );
    }
}
