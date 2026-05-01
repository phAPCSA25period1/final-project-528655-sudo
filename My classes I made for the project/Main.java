import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the School Counselor Scheduler application.
 * Guides the user through a step-by-step console prompt to collect
 * their information, pick an available appointment slot, and save the booking.
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("  School Counselor Scheduler  ");

        // Show all days and their currently open time slots before prompting
        AppointmentManager.showAvailability();
        System.out.println();

        // ───────────── NAME INPUT ─────────────
        System.out.print("Enter full name: ");
        String name = input.nextLine();

        // ───────────── GRADE INPUT (TRY-CATCH) ─────────────
        int grade = 0;
        boolean validGrade = false;

        // Keep prompting until the user enters a valid integer between 9 and 12
        while (!validGrade)
        {
            System.out.print("Enter grade level (9-12): ");

            try
            {
                grade = Integer.parseInt(input.nextLine());

                // Accept only high-school grade levels
                if (grade >= 9 && grade <= 12)
                {
                    validGrade = true;
                }
                else
                {
                    System.out.println("Grade must be between 9 and 12.");
                }
            }
            catch (NumberFormatException e)
            {
                // Catches non-numeric input like "ten" or "9a"
                System.out.println("Invalid input. Please enter a NUMBER (9-12).");
            }
        }

        // ───────────── DAY VALIDATION ─────────────
        String day = "";
        boolean validDay = false;

        // Keep prompting until the user enters a valid weekday
        while (!validDay)
        {
            System.out.print("Enter appointment day (Monday - Friday only): ");
            day = input.nextLine().trim();

            if (day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday"))
            {
                // Give a specific message for weekend attempts instead of a generic error
                System.out.println("No weekend appointments.");
            }
            else if (day.equalsIgnoreCase("Monday") ||
                     day.equalsIgnoreCase("Tuesday") ||
                     day.equalsIgnoreCase("Wednesday") ||
                     day.equalsIgnoreCase("Thursday") ||
                     day.equalsIgnoreCase("Friday"))
            {
                validDay = true;
            }
            else
            {
                System.out.println("Invalid day. Try again.");
            }
        }

        // ───────────── DATE INPUT ─────────────
        // Free-form date string (e.g., "May 5"); no format validation applied here
        System.out.print("Enter appointment date (ex: May 5): ");
        String date = input.nextLine();

        // ───────────── TIME SLOT PICKER ─────────────
        String time = "";
        boolean slotPicked = false;

        // Loop until a valid, available slot is selected
        while (!slotPicked)
        {
            List<String> available = AppointmentManager.getAvailableSlots(day);

            // If the chosen day is fully booked, prompt for a different day and restart the loop
            if (available.isEmpty())
            {
                System.out.println("No slots available for " + day);
                System.out.print("Enter a new day: ");
                day = input.nextLine();
                continue;
            }

            // Display each available slot with a 1-based index for user selection
            System.out.println("\nAvailable slots for " + day + ":");
            for (int i = 0; i < available.size(); i++)
            {
                System.out.println((i + 1) + ". " + available.get(i));
            }

            System.out.print("Pick a slot number: ");
            String choice = input.nextLine();

            try
            {
                // Convert 1-based user input to 0-based list index
                int index = Integer.parseInt(choice) - 1;

                if (index >= 0 && index < available.size())
                {
                    time = available.get(index);
                    slotPicked = true;
                    System.out.println("Slot confirmed: " + time);
                }
                else
                {
                    System.out.println("That number is not in the list.");
                }
            }
            catch (NumberFormatException e)
            {
                // Catches non-numeric input like "first" or "2a"
                System.out.println("Invalid input. Please enter a NUMBER.");
            }
        }

        // ───────────── REASON INPUT ─────────────
        System.out.print("Enter reason for appointment: ");
        String reason = input.nextLine();

        // ───────────── MEETING TYPE (TRY-CATCH LOOP) ─────────────
        String meetingType = "";
        boolean validMeeting = false;

        // Keep prompting until the user picks option 1 or 2
        while (!validMeeting)
        {
            System.out.println("Select meeting type:");
            System.out.println("1. In-Person");
            System.out.println("2. Virtual");
            System.out.print("Choice (1 or 2): ");

            String choice = input.nextLine();

            if (choice.equals("1"))
            {
                meetingType = "In-Person";
                validMeeting = true;
            }
            else if (choice.equals("2"))
            {
                meetingType = "Virtual";
                validMeeting = true;
            }
            else
            {
                System.out.println("Invalid choice. Enter 1 or 2.");
            }
        }

        // ───────────── NOTES INPUT ─────────────
        System.out.print("Any additional notes? (press Enter to skip): ");
        String notes = input.nextLine();

        // Default to "None" so the CSV never contains a blank notes field
        if (notes.isEmpty())
        {
            notes = "None";
        }

        // ───────────── CREATE OBJECTS ─────────────
        // Student constructor internally assigns the appropriate counselor based on grade
        Student s = new Student(name, grade);

        // Build the appointment using all collected inputs
        Appointment a = new Appointment(
            s,
            s.getCounselor(),
            day,
            date,
            time,
            reason,
            meetingType,
            notes
        );

        // Register the appointment in memory and persist it to the CSV file
        AppointmentManager.add(a, s);

        // Print a formatted confirmation summary to the console
        System.out.println(a);

        input.close();
    }
}
