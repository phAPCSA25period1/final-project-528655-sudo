import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("  School Counselor Scheduler  ");

        // Show all available appointments first
        AppointmentManager.showAvailability();
        System.out.println();

        // ───────────── NAME INPUT ─────────────
        System.out.print("Enter full name: ");
        String name = input.nextLine();

        // ───────────── GRADE INPUT (TRY-CATCH) ─────────────
        int grade = 0;
        boolean validGrade = false;

        while (!validGrade)
        {
            System.out.print("Enter grade level (9-12): ");

            try
            {
                grade = Integer.parseInt(input.nextLine());

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
                System.out.println("Invalid input. Please enter a NUMBER (9-12).");
            }
        }

        // ───────────── DAY VALIDATION ─────────────
        String day = "";
        boolean validDay = false;

        while (!validDay)
        {
            System.out.print("Enter appointment day (Monday - Friday only): ");
            day = input.nextLine().trim();

            if (day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday"))
            {
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
        System.out.print("Enter appointment date (ex: May 5): ");
        String date = input.nextLine();

        // ───────────── TIME SLOT PICKER ─────────────
        String time = "";
        boolean slotPicked = false;

        while (!slotPicked)
        {
            List<String> available = AppointmentManager.getAvailableSlots(day);

            // If no slots available, force user to choose a new day
            if (available.isEmpty())
            {
                System.out.println("No slots available for " + day);
                System.out.print("Enter a new day: ");
                day = input.nextLine();
                continue;
            }

            // Display slots
            System.out.println("\nAvailable slots for " + day + ":");
            for (int i = 0; i < available.size(); i++)
            {
                System.out.println((i + 1) + ". " + available.get(i));
            }

            System.out.print("Pick a slot number: ");
            String choice = input.nextLine();

            try
            {
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
                System.out.println("Invalid input. Please enter a NUMBER.");
            }
        }

        // ───────────── REASON INPUT ─────────────
        System.out.print("Enter reason for appointment: ");
        String reason = input.nextLine();

        // ───────────── MEETING TYPE (TRY-CATCH LOOP) ─────────────
        String meetingType = "";
        boolean validMeeting = false;

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

        if (notes.isEmpty())
        {
            notes = "None";
        }

        // ───────────── CREATE OBJECTS ─────────────
        Student s = new Student(name, grade);

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

        // Add appointment to system (pass student so it can be saved)
        AppointmentManager.add(a, s);

        // Print confirmation
        System.out.println(a);

        input.close();
    }
}
