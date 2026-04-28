// Represents a student and assigns a counselor based on last name
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

    // Assigns counselor based on last name ranges
    private Counselor assignCounselor(String fullName)
    {
        String[] parts = fullName.split(" ");
        String last = parts[parts.length - 1].toUpperCase();

        if (last.compareTo("CAR") <= 0)
            return new Counselor("Ms. Vaccarino");
        else if (last.compareTo("GIZ") <= 0)
            return new Counselor("Mrs. Lucio");
        else if (last.compareTo("LEM") <= 0)
            return new Counselor("Mrs. Glazer");
        else if (last.compareTo("NHAM") <= 0)
            return new Counselor("Mrs. Labe");
        else if (last.compareTo("SE") <= 0)
            return new Counselor("Mr. Barrientos");
        else
            return new Counselor("Mr. Navickas");
    }

    public String toString()
    {
        return name + " (Grade " + gradeLevel + ") - " + counselor;
    }
}
