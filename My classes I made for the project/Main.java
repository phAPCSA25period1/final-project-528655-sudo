import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("  School Counselor Scheduler  ");

        // Show the full calendar before anything else
        AppointmentManager.showAvailability();
        System.out.println();

        // Name
        System.out.print("Enter full name: ");
        String name = input.nextLine();

        // Grade
        System.out.print("Enter grade level (9-12): ");
        int grade = input.nextInt();
        input.nextLine();

        // Day validation
        String day = "";
        boolean validDay = false;
        while (!validDay)
        {
            System.out.print("Enter appointment day (Monday - Friday only): ");
            day = input.nextLine().trim();

            if (day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday"))
                System.out.println("Sorry, appointments are not available on weekends.");
            else if (day.equalsIgnoreCase("Monday")    || day.equalsIgnoreCase("Tuesday") ||
                     day.equalsIgnoreCase("Wednesday") || day.equalsIgnoreCase("Thursday") ||
                     day.equalsIgnoreCase("Friday"))
                validDay = true;
            else
                System.out.println("Invalid day. Please enter a valid weekday (Monday - Friday).");
        }

        System.out.print("Enter appointment date (ex: May 5): ");
        String date = input.nextLine();

        // Time slot picker
        String time = "";
        boolean slotPicked = false;

        while (!slotPicked)
        {
            List<String> available = AppointmentManager.getAvailableSlots(day);

            if (available.isEmpty())
            {
                System.out.println("Sorry, all slots on " + day + " are fully booked!");
                System.out.print("Enter a different day: ");
                day = input.nextLine().trim();
                continue;
            }

            System.out.println("\nAvailable slots for " + day + ":");
            for (int i = 0; i < available.size(); i++)
                System.out.printf("  %2d. %s%n", i + 1, available.get(i));

            System.out.print("Pick a slot number: ");
            String choice = input.nextLine().trim();

            int index;
            try
            {
                index = Integer.parseInt(choice) - 1;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a number from the list.");
                continue;
            }

            if (index < 0 || index >= available.size())
            {
                System.out.println("That number isn't on the list. Try again.");
                continue;
            }

            time = available.get(index);
            slotPicked = true;
            System.out.println("Slot confirmed: " + time);
        }

        // Reason
        System.out.print("Enter reason for appointment: ");
        String reason = input.nextLine();

        // Meeting type
        System.out.println("Select meeting type:");
        System.out.println("  1. In-Person");
        System.out.println("  2. Virtual");
        System.out.print("Choice (1 or 2): ");
        String meetingChoice = input.nextLine();
        String meetingType = meetingChoice.equals("1") ? "In-Person" : "Virtual";

        // Notes
        System.out.print("Any additional notes? (press Enter to skip): ");
        String notes = input.nextLine();
        if (notes.isEmpty())
            notes = "None";

        // Create student + appointment, then register it
        Student s = new Student(name, grade);
        Appointment a = new Appointment(s, s.getCounselor(), day, date, time, reason, meetingType, notes);

        AppointmentManager.add(a);  // <-- this is what marks the slot as taken

        System.out.println(a);

        input.close();
    }
}
