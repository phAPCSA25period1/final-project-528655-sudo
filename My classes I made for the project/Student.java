public class Student
{
    private String name;
    private int gradeLevel;
    private Counselor counselor;

    public Student(String name, int gradeLevel)
    {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.counselor = assignCounselor(name);
    }

    public String getName() { return name; }
    public int getGradeLevel() { return gradeLevel; }
    public Counselor getCounselor() { return counselor; }

    private Counselor assignCounselor(String fullName)
    {
        String[] parts = fullName.split(" ");
        String lastName = parts[parts.length - 1].toUpperCase();

        // Check ranges
        if (lastName.compareTo("CAR") <= 0)
            return new Counselor("Ms. Vaccarino");

        else if (lastName.compareTo("GIZ") <= 0)
            return new Counselor("Mrs. Lucio");

        else if (lastName.compareTo("LEM") <= 0)
            return new Counselor("Mrs. Glazer");

        else if (lastName.compareTo("NHAM") <= 0)
            return new Counselor("Mrs. Labe");

        else if (lastName.compareTo("SE") <= 0)
            return new Counselor("Mr. Barrientos");

        else
            return new Counselor("Mr. Navickas");
    }

    public String toString()
    {
        return "Student: " + name +
               " (Grade " + gradeLevel + ")" +
               " - " + counselor;
    }
}
