public class AppointmentManager {

}
import java.util.ArrayList;

public class AppointmentManager
{
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void add(Appointment a)
    {
        appointments.add(a);
    }

    public static boolean isSlotTaken(String day, String time)
    {
        for (Appointment a : appointments)
        {
            if (a.getDay().equalsIgnoreCase(day) && a.getTime().equalsIgnoreCase(time))
                return true;
        }
        return false;
    }

    public static void showAvailability()
    {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] slots = {"8:45 AM", "9:30 AM", "10:15 AM", "11:00 AM",
                          "11:45 AM", "12:30 PM", "1:15 PM", "2:00 PM",
                          "2:45 PM", "3:33 PM"};


        System.out.println("     AVAILABILITY CALENDAR    ");


        for (String day : days)
        {
            System.out.println("\n" + day + ":");
            for (String slot : slots)
            {
                if (isSlotTaken(day, slot))
                    System.out.println("   " + slot + " - BOOKED");
                else
                    System.out.println("   " + slot + " - Available");
            }
        }

    }

    public static boolean isEmpty()
    {
        return appointments.isEmpty();
    }
}
