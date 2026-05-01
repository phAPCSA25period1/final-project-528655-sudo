import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages appointment scheduling for students and counselors.
 * Handles loading, saving, and querying appointment slots
 * using a CSV file for persistence.
 */
public class AppointmentManager
{
    // Path to the CSV file used for storing appointments
    private static final String FILE = "appointments.csv";

    // In-memory list of all booked appointment rows loaded from or saved to CSV
    private static List<String[]> bookedSlots = new ArrayList<>();

    // Maps each weekday to its list of available time slots
    private static Map<String, List<String>> schedule = new HashMap<>();

    // Static initializer: sets up the default weekly schedule and loads existing bookings
    static
    {
        // Define the standard time slots offered each day
        List<String> times = Arrays.asList(
            "9:00 AM", "10:00 AM", "11:00 AM",
            "1:00 PM", "2:00 PM", "3:00 PM"
        );

        // Assign the same default slots to each weekday
        schedule.put("Monday",    new ArrayList<>(times));
        schedule.put("Tuesday",   new ArrayList<>(times));
        schedule.put("Wednesday", new ArrayList<>(times));
        schedule.put("Thursday",  new ArrayList<>(times));
        schedule.put("Friday",    new ArrayList<>(times));

        // Populate bookedSlots from the CSV file if it exists
        loadFromFile();
    }

    /**
     * Normalizes a day string to title case (e.g., "monday" -> "Monday").
     */
    private static String normalizeDay(String day)
    {
        if (day == null || day.isEmpty()) return "";
        day = day.trim().toLowerCase();
        return day.substring(0,1).toUpperCase() + day.substring(1);
    }

    /**
     * Reads appointments.csv and populates bookedSlots.
     */
    private static void loadFromFile()
    {
        File f = new File(FILE);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",", -1);
                if (parts.length >= 9)
                    bookedSlots.add(parts);
            }
        }
        catch (IOException e)
        {
            System.out.println("Warning: could not read appointments file.");
        }
    }

    /**
     * Saves a new appointment row to the CSV file.
     */
    private static void saveToFile(Appointment a, Student s)
    {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE, true)))
        {
            pw.printf("%s,%d,%s,%s,%s,%s,%s,%s,%s%n",
                s.getName(),
                s.getGradeLevel(),
                s.getCounselor().getName(),
                a.getDay(),
                a.getDate(),
                a.getTime(),
                a.getMeetingType(),
                a.getReason(),
                a.getNotes()
            );
        }
        catch (IOException e)
        {
            System.out.println("Warning: could not save appointment.");
        }
    }

    /**
     * Returns available time slots for a given day.
     */
    public static List<String> getAvailableSlots(String day)
    {
        day = normalizeDay(day);

        if (!schedule.containsKey(day))
        {
            System.out.println("Invalid day entered. Please use Monday–Friday.");
            return new ArrayList<>();
        }

        List<String> available = new ArrayList<>(schedule.get(day));

        for (String[] row : bookedSlots)
        {
            if (row[3].equalsIgnoreCase(day))
                available.remove(row[5]);
        }

        return available;
    }

    /**
     * Adds an appointment and saves it.
     */
    public static void add(Appointment a, Student s)
    {
        String[] row = {
            s.getName(),
            String.valueOf(s.getGradeLevel()),
            s.getCounselor().getName(),
            a.getDay(),
            a.getDate(),
            a.getTime(),
            a.getMeetingType(),
            a.getReason(),
            a.getNotes()
        };

        bookedSlots.add(row);
        saveToFile(a, s);
    }

    /**
     * Displays all availability.
     */
    public static void showAvailability()
    {
        System.out.println("=== Weekly Availability ===");
        for (String day : schedule.keySet())
        {
            System.out.println(day + ": " + getAvailableSlots(day));
        }
    }
}
