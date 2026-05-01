/**
 * Represents a scheduled appointment between a student and a counselor.
 * Stores all relevant details such as date, time, reason, and meeting type.
 */
public class Appointment
{
    // The student who booked the appointment
    private Student student;

    // The counselor assigned to the appointment
    private Counselor counselor;

    // Basic appointment details
    private String day;          // Day of the week (e.g., Monday)
    private String date;         // Specific date (e.g., May 4)
    private String time;         // Time slot (e.g., 10:00 AM)
    private String reason;       // Reason for the meeting
    private String meetingType;  // Type (e.g., In-person or Virtual)
    private String notes;        // Additional notes

    /**
     * Constructor to create a new Appointment object.
     *
     * @param student      The student booking the appointment
     * @param counselor    The counselor assigned
     * @param day          Day of the appointment
     * @param date         Date of the appointment
     * @param time         Time of the appointment
     * @param reason       Reason for the meeting
     * @param meetingType  Type of meeting (in-person/virtual)
     * @param notes        Additional notes
     */
    public Appointment(Student student, Counselor counselor,
                       String day, String date, String time,
                       String reason, String meetingType, String notes)
    {
        this.student = student;
        this.counselor = counselor;
        this.day = day;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.meetingType = meetingType;
        this.notes = notes;
    }

    // Getter methods used by AppointmentManager

    /** @return the day of the appointment */
    public String getDay() { return day; }

    /** @return the date of the appointment */
    public String getDate() { return date; }

    /** @return the time of the appointment */
    public String getTime() { return time; }

    /** @return the reason for the appointment */
    public String getReason() { return reason; }

    /** @return the meeting type (in-person or virtual) */
    public String getMeetingType() { return meetingType; }

    /** @return any additional notes */
    public String getNotes() { return notes; }

    /**
     * Returns a formatted string showing appointment details.
     * This is used when displaying a confirmation to the user.
     */
    @Override
    public String toString()
    {
        return "\n=== APPOINTMENT CONFIRMATION ===" +
               "\nStudent: " + student.getName() +
               "\nGrade: " + student.getGradeLevel() +
               "\nCounselor: " + counselor.getName() +
               "\nDay: " + day +
               "\nDate: " + date +
               "\nTime: " + time +
               "\nType: " + meetingType +
               "\nReason: " + reason +
               "\nNotes: " + notes;
    }
}
