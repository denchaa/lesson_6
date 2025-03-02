import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static Scanner read;
    private static List<MilitaryPerson> militaryList;

    public static void main(String[] args) {
        read = new Scanner(System.in);
        militaryList = new ArrayList<>();

        while (true) {
            printMenu();
            int choice = read.nextInt();
            read.nextLine(); // Очистка буфера после nextInt()

            switch (choice) {
                case 1:
                    addMilitaryPerson();
                    break;
                case 2:
                    printSortedMilitaryList();
                    break;
                case 3:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // Метод для вывода меню
    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить военного");
        System.out.println("2. Вывести отсортированный список военных");
        System.out.println("3. Выйти");
        System.out.print("Выберите действие: ");
    }

    // Метод для добавления военного
    private static void addMilitaryPerson() {
        System.out.println("Выберите тип военного:");
        System.out.println("1. Обычный военный");
        System.out.println("2. Органы военного управления");
        System.out.println("3. Военная служба по контракту");
        System.out.println("4. Награждённый военный");
        int type = read.nextInt();
        read.nextLine(); // Очистка буфера после nextInt()

        System.out.print("Введите фамилию: ");
        String lastName = read.nextLine();
        System.out.print("Введите роту: ");
        String company = read.nextLine();
        System.out.print("Введите звание: ");
        String rank = read.nextLine();
        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        Date dateOfBirth = parseDate(read.nextLine());
        System.out.print("Введите дату поступления на службу (дд.мм.гггг): ");
        Date enlistmentDate = parseDate(read.nextLine());
        System.out.print("Введите часть: ");
        String unit = read.nextLine();

        switch (type) {
            case 1:
                militaryList.add(new MilitaryPerson(lastName, company, rank, dateOfBirth, enlistmentDate, unit));
                break;
            case 2:
                System.out.print("Введите название округа: ");
                String district = read.nextLine();
                System.out.print("Введите должность: ");
                String position = read.nextLine();
                System.out.print("Введите выслугу лет: ");
                int yearsOfService = read.nextInt();
                System.out.print("Введите сумму надбавки: ");
                double bonus = read.nextDouble();
                militaryList.add(new MilitaryManagement(lastName, company, rank, dateOfBirth, enlistmentDate, unit, district, position, yearsOfService, bonus));
                break;
            case 3:
                System.out.print("Введите период договора: ");
                String contractPeriod = read.nextLine();
                System.out.print("Введите дату договора (дд.мм.гггг): ");
                Date contractDate = parseDate(read.nextLine());
                System.out.print("Введите номер протокола: ");
                String protocolNumber = read.nextLine();
                System.out.print("Введите сумму зарплаты: ");
                double salary = read.nextDouble();
                militaryList.add(new ContractService(lastName, company, rank, dateOfBirth, enlistmentDate, unit, contractPeriod, contractDate, protocolNumber, salary));
                break;
            case 4:
                System.out.print("Введите название награды: ");
                String awardName = read.nextLine();
                System.out.print("Введите премию: ");
                double prize = read.nextDouble();
                System.out.print("Введите сумму надбавки: ");
                double bonusAward = read.nextDouble();
                militaryList.add(new AwardedMilitary(lastName, company, rank, dateOfBirth, enlistmentDate, unit, awardName, prize, bonusAward));
                break;
            default:
                System.out.println("Неверный тип военного.");
        }
    }

    // Метод для вывода отсортированного списка
    private static void printSortedMilitaryList() {
        if (militaryList.isEmpty()) {
            System.out.println("Список военных пуст.");
            return;
        }

        // Сортировка по фамилии
        militaryList.sort(Comparator.comparing(MilitaryPerson::getLastName));

        System.out.println("Отсортированный список военных:");
        for (MilitaryPerson person : militaryList) {
            System.out.println(person);
            System.out.println("-----------------------------");
        }
    }

    // Метод для парсинга даты
    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (Exception e) {
            System.out.println("Ошибка при вводе даты. Используйте формат дд.мм.гггг.");
            return new Date(); // Возвращаем текущую дату в случае ошибки
        }
    }
}