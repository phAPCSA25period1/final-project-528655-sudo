import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        
        System.out.println("  School Counselor Scheduler  ");


        // Ask for user info
        System.out.print("Enter full name: ");
        String name = input.nextLine();

        System.out.print("Enter grade level (9-12): ");
        int grade = input.nextInt();
        input.nextLine(); // clear buffer

        // Day validation - no weekends
        String day = "";
        boolean validDay = false;
        while (!validDay)
        {
            System.out.print("Enter appointment day (Monday - Friday only): ");
            day = input.nextLine().trim();

            if (day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday"))
                System.out.println("Sorry, appointments are not available on weekends. Please choose a weekday.");
            else if (day.equalsIgnoreCase("Monday") || day.equalsIgnoreCase("Tuesday") ||
                     day.equalsIgnoreCase("Wednesday") || day.equalsIgnoreCase("Thursday") ||
                     day.equalsIgnoreCase("Friday"))
                validDay = true;
            else
                System.out.println("Invalid day. Please enter a valid weekday (Monday - Friday).");
        }

        System.out.print("Enter appointment date (ex: May 5): ");
        String date = input.nextLine();

        // Time validation - must be within 8:45 AM - 3:33 PM
        String time = "";
        boolean validTime = false;
        while (!validTime)
        {
            System.out.print("Enter appointment time (8:45 AM - 3:33 PM): ");
            time = input.nextLine().trim();

            int minutes = convertToMinutes(time);

            if (minutes == -1)
                System.out.println("Invalid format. Please use format like 10:00 AM or 2:30 PM.");
            else if (minutes < convertToMinutes("8:45 AM"))
                System.out.println("Too early! School hours start at 8:45 AM.");
            else if (minutes > convertToMinutes("3:33 PM"))
                System.out.println("Too late! School hours end at 3:33 PM.");
            else
                validTime = true;
        }

        System.out.print("Enter reason for appointment: ");
        String reason = input.nextLine();

        System.out.println("Select meeting type:");
        System.out.println("  1. In-Person");
        System.out.println("  2. Virtual");
        System.out.print("Choice (1 or 2): ");
        String meetingChoice = input.nextLine();
        String meetingType = meetingChoice.equals("1") ? "In-Person" : "Virtual";

        System.out.print("Any additional notes? (press Enter to skip): ");
        String notes = input.nextLine();
        if (notes.isEmpty())
            notes = "None";

        // Create student (counselor assigned automatically by last name)
        Student s = new Student(name, grade);

        // Create appointment
        Appointment a = new Appointment(s, s.getCounselor(), day, date, time, reason, meetingType, notes);

        // Print confirmation
        System.out.println(a);

        input.close();
    }

    // Converts "10:30 AM" or "2:45 PM" into total minutes since midnight
    public static int convertToMinutes(String time)
    {
        try
        {
            String[] parts = time.split(" ");
            String[] hourMin = parts[0].split(":");
            int hours = Integer.parseInt(hourMin[0]);
            int minutes = Integer.parseInt(hourMin[1]);
            String period = parts[1].toUpperCase();

            if (period.equals("PM") && hours != 12)
                hours += 12;
            if (period.equals("AM") && hours == 12)
                hours = 0;

            return hours * 60 + minutes;
        }
        catch (Exception e)
        {
            return -1; // invalid format
        }
    }
}
