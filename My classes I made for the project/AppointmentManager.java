import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Manages all appointments and available time slots
public class AppointmentManager
{
    // Stores all appointments
    private static List<Appointment> appointments = new ArrayList<>();

    // Default schedule for each day
    private static Map<String, List<String>> schedule = new HashMap<>();

    static
    {
        // Initialize schedule
        List<String> times = Arrays.asList(
            "9:00 AM", "10:00 AM", "11:00 AM",
            "1:00 PM", "2:00 PM", "3:00 PM"
        );

        schedule.put("Monday", new ArrayList<>(times));
        schedule.put("Tuesday", new ArrayList<>(times));
        schedule.put("Wednesday", new ArrayList<>(times));
        schedule.put("Thursday", new ArrayList<>(times));
        schedule.put("Friday", new ArrayList<>(times));
    }

    // Returns available slots for a given day
    public static List<String> getAvailableSlots(String day)
    {
        List<String> available = new ArrayList<>(schedule.get(day));

        for (Appointment a : appointments)
        {
            if (a.getDay().equalsIgnoreCase(day))
            {
                available.remove(a.getTime()); // remove booked slot
            }
        }

        return available;
    }

    // Adds appointment to list
    public static void add(Appointment a)
    {
        appointments.add(a);
    }

    // Displays all availability
    public static void showAvailability()
    {
        System.out.println("=== Weekly Availability ===");

        for (String day : schedule.keySet())
        {
            System.out.println(day + ": " + schedule.get(day));
        }
    }
}
