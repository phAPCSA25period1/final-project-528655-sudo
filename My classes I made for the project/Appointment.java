public class Appointment
{
    private Student student;
    private Counselor counselor;
    private String day;
    private String date;
    private String time;
    private String reason;
    private String meetingType;
    private String notes;

    public Appointment(Student student, Counselor counselor, String day, String date, String time, String reason, String meetingType, String notes)
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

    // ── Getters needed by AppointmentManager ──
    public String getDay()
    {
        return day;
    }

    public String getTime()
    {
        return time;
    }

    public String toString()
    {
        return
               "\n    APPOINTMENT CONFIRMATION  " +
               "\n Student:      " + student.getName() +
               "\n Grade:        " + student.getGradeLevel() +
               "\n Counselor:    " + counselor.getName() +
               "\n Day:          " + day +
               "\n Date:         " + date +
               "\n Time:         " + time +
               "\n Meeting Type: " + meetingType +
               "\n Reason:       " + reason +
               "\n Notes:        " + notes;
    }
}
