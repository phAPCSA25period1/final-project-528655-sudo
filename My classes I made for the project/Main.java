import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Ask for user info
        System.out.print("Enter full name: ");
        String name = input.nextLine();

        System.out.print("Enter grade level: ");
        int grade = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Enter appointment day: ");
        String day = input.nextLine();

        System.out.print("Enter appointment time: ");
        String time = input.nextLine();

        // Create student (counselor is assigned automatically)
        Student s = new Student(name, grade);

        // Use student's counselor
        Appointment a = new Appointment(s, s.getCounselor(), day, time);

        // Print everything
        System.out.println("\n--- Appointment Info ---");
        System.out.println(s);
        System.out.println(s.getCounselor());
        System.out.println(a);

        input.close();
    }
}
