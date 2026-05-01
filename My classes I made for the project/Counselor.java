/**
 * Represents a school counselor.
 * This class stores basic information about a counselor,
 * currently only their name.
 */
public class Counselor
{
    // The name of the counselor
    private String name;

    /**
     * Constructor to create a Counselor object.
     *
     * @param name The name of the counselor
     */
    public Counselor(String name)
    {
        this.name = name;
    }

    /**
     * Returns the counselor's name.
     *
     * @return name of the counselor
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns a string representation of the counselor.
     * This is useful when printing the object directly.
     *
     * @return counselor's name
     */
    @Override
    public String toString()
    {
        return name;
    }
}
