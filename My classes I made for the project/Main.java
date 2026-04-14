public class Main
{
    public static void main(String[] args)
    {
        Student s = new Student("Eva", 11);
        Counselor c = new Counselor("Ms.Rivera");
        Appointment a = new Appointment(s, c, "Monday", "9:00AM");

        System.out.println(s);
        System.out.println(c);
        System.out.println(a);

    }
}
