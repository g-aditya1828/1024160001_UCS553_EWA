package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.LibraryService;
import library.util.InputValidator;

public class Main {

    public static void main(String[] args) {

        // Resource IDs
        int id1 = 101;
        int id2 = 102;
        int id3 = 103;
        int id4 = 104;
        int id5 = 105;

        // Validate Resource IDs
        if (!InputValidator.isValidResourceId(id1) ||
            !InputValidator.isValidResourceId(id2) ||
            !InputValidator.isValidResourceId(id3) ||
            !InputValidator.isValidResourceId(id4) ||
            !InputValidator.isValidResourceId(id5)) {

            System.out.println("Invalid Resource ID!");
            return;
        }

        // Create at least five objects
        Book book1 = new Book(
                id1,
                "Data Structures",
                "Mark Allen"
        );

        Book book2 = new Book(
                id2,
                "Operating Systems",
                "William Stallings"
        );

        Book book3 = new Book(
                id3,
                "Database Management",
                "Raghu Ramakrishnan"
        );

        DigitalResource digital1 = new DigitalResource(
                id4,
                "Java Programming Course",
                "James Gosling"
        );

        DigitalResource digital2 = new DigitalResource(
                id5,
                "Artificial Intelligence",
                "Stuart Russell"
        );

        // Store objects in an array
        LibraryResource[] resources = {
            book1,
            book2,
            book3,
            digital1,
            digital2
        };

        // Overdue days for each resource
        int[] overdueDays = {
            3,
            5,
            0,
            4,
            2
        };

        // Validate fine days
        for (int days : overdueDays) {
            if (!InputValidator.isValidFineDays(days)) {
                System.out.println("Invalid overdue days!");
                return;
            }
        }

        // Display complete details
        System.out.println("======================================");
        System.out.println("       SMART LIBRARY SYSTEM");
        System.out.println("======================================");

        for (int i = 0; i < resources.length; i++) {

            Printable.print(resources[i]);

            System.out.println("Overdue Days : " + overdueDays[i]);

            double fine = resources[i].calculateFine(overdueDays[i]);

            System.out.println("Fine         : Rs. " + fine);
            System.out.println();
        }

        // Calculate total fine
        double totalFine =
                LibraryService.calculateTotalFine(resources, overdueDays);

        System.out.println("======================================");
        System.out.println("Total Fine = Rs. " + totalFine);
        System.out.println("======================================");

        // Display total resources created
        LibraryResource.displayTotalResources();
    }
}