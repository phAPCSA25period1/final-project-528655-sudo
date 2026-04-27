import java.util.ArrayList;
import java.util.List;

public class AppointmentManager
{
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static final String[] SLOTS = {
        "8:45 AM", "9:30 AM", "10:15 AM", "11:00 AM",
        "11:45 AM", "12:30 PM", "1:15 PM", "2:00 PM",
        "2:45 PM", "3:33 PM"
    };

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

    // Returns a list of slots still open for a given day
    public static List<String> getAvailableSlots(String day)
    {
        List<String> available = new ArrayList<>();
        for (String slot : SLOTS)
        {
            if (!isSlotTaken(day, slot))
                available.add(slot);
        }
        return available;
    }

    public static void showAvailability()
    {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        System.out.println("     AVAILABILITY CALENDAR    ");

        for (String day : days)
        {
            System.out.println("\n" + day + ":");
            for (String slot : SLOTS)
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
