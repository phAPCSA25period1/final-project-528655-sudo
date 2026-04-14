public class Appointment
{
    private Student student;
    private Counselor counselor;
    private String date;
    private String time;

    public Appointment(Student student, Counselor counselor, String date, String time)
    {
        this.student = student;
        this.counselor = counselor;
        this.date = date;
        this.time = time;

    }
    public String toString()
    {
        return student.getName() + "with" + counselor.getName() + "on" + date + "at" + time;

    }

}
