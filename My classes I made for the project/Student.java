public class Student
{
    private String name;
    private int gradeLevel;

    public Student(String name, int gradeLevel)
    {
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public String getName() { return name; }
    public int getGradeLevel() { return gradeLevel;}

    public String toString()
    {
        return "Stuent:" + name + " (Grade " + gradeLevel + ")";
    }
}
