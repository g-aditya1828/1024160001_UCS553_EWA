
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String name = sc.nextLine();

        System.out.print("Enter event date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter start time (HH:mm): ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue (or press Enter to skip): ");
        String venueInput = sc.nextLine();

        Optional<String> venue = venueInput.isEmpty()
                ? Optional.empty()
                : Optional.of(venueInput);

        LocalTime endTime = startTime.plusHours(2);
        LocalDate today = LocalDate.now();

        System.out.println("\n--- Event Details ---");
        System.out.println("Event Name: " + name);
        System.out.println("Event Date: " + date);
        System.out.println("Start Time: " + startTime.format(
                DateTimeFormatter.ofPattern("hh:mm a")));
        System.out.println("End Time: " + endTime.format(
                DateTimeFormatter.ofPattern("hh:mm a")));
        System.out.println("Venue: " + venue.orElse("Venue not specified"));

        if (date.isAfter(today)) {
            System.out.println("Event Status: Future");
        } else if (date.isEqual(today)) {
            System.out.println("Event Status: Today");
        } else {
            System.out.println("Event Status: Past");
        }

        long days = ChronoUnit.DAYS.between(today, date);
        System.out.println("Days remaining: " + days);

        sc.close();
    }
}