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
               "\n Notes:        " + notes +
EVA FIX THIS TAKE OUT THE OVERRIDE WHOLE PART IT IS BREAKING THE CODE KEEP EVERYTHING ABOVE THIS MESSAGE AND DELETE EVERYTHING BELOW

               @Override
public String toString()
{
    return "Name: " + name +
           "\nGrade: " + grade +
           "\nDay: " + day +
           "\nDate: " + date +
           "\nTime: " + time +
           "\nReason: " + reason +
           "\nMeeting Type: " + meetingType +
           "\nNotes: " + notes;
}

    }
}
