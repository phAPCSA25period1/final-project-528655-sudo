// Represents a scheduled appointment
public class Appointment
{
    private Student student;
    private Counselor counselor;
    private String day, date, time, reason, meetingType, notes;

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

    // Getters used by AppointmentManager
    public String getDay() { return day; }
    public String getTime() { return time; }

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
