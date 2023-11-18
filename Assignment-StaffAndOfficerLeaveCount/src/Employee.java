import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private LocalDate joiningDate;

    public Employee(int id, String name, LocalDate dateOfBirth, String email, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.joiningDate = joiningDate;
    }

    public int calculateVacationLeave() {
        int totalLeaveDays = calculateTotalLeaveDays();
        int vacationDays = getVacationDays();
        return calculateLeave(vacationDays, totalLeaveDays);
    }

    public int calculateSickLeave() {
        int totalLeaveDays = calculateTotalLeaveDays();
        int sickDays = getSickDays();
        return calculateLeave(sickDays, totalLeaveDays);
    }

    private int calculateTotalLeaveDays() {
        LocalDate endOfYear = LocalDate.of(joiningDate.getYear(), 12, 31);
        int totalDaysInYear = joiningDate.isLeapYear() ? 366 : 365;

        if (Period.between(joiningDate, endOfYear).getYears() == 0) {
            return (int) ((endOfYear.getDayOfYear() - joiningDate.getDayOfYear() + 1) * totalDaysInYear / 365.0);
        } else {
            return (int) ((endOfYear.getDayOfYear() + 1) * totalDaysInYear / 365.0);
        }
    }

    private int getVacationDays() {
        return this instanceof Officer ? 15 : 10;
    }

    private int getSickDays() {
        return this instanceof Officer ? 10 : 7;
    }

    private int calculateLeave(int leaveDays, int totalLeaveDays) {
        double result = (leaveDays * totalLeaveDays) / (joiningDate.isLeapYear() ? 366.0 : 365.0);
        return result < 0.5 ? 0 : (int) Math.ceil(result);
    }

    // Getters and setters if required

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Date of Birth: " + dateOfBirth + "\n" +
                "Email: " + email + "\n" +
                "Joining Date: " + joiningDate + "\n" +
                "Vacation Leave: " + calculateVacationLeave() + "\n" +
                "Sick Leave: " + calculateSickLeave() + "\n";
    }


}

class Officer extends Employee {
    public Officer(int id, String name, LocalDate dateOfBirth, String email, LocalDate joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate);
    }
}

class Staff extends Employee {
    public Staff(int id, String name, LocalDate dateOfBirth, String email, LocalDate joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate);
    }
}
