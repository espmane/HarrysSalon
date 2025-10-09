package HarrysSalon;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointments {
    private String customerName;
    private LocalDate date;
    private LocalTime start;  // hvornår klipningen starter

    public Appointments(String customerName, LocalDate date, LocalTime start) {
        this.customerName = customerName;
        this.date = date;
        this.start = start;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        // Sluttid = starttid + 30 minutter
        return start.plusMinutes(30);
    }

    public LocalDate getDate() {
        return date;
    }
}
