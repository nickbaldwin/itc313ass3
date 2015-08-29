package RecordProcessor.model;


/**
 * Student is a stub class currently. It would be expected to be implemented
 * fully in a real world setting. At this point it is simply used to check if
 * a Student ID entered into the app is a valid ID.
 */
public class Student
{
  // =========================================================================
  // Variables
  // =========================================================================

  // Student ID must be an 8 digit number
  private static final String ID_PATTERN = "\\d{1,8}";

  private String id;
  private String firstName;
  private String lastName;
  // etc

  // =========================================================================
  // Constructors
  // =========================================================================

  private Student()
  {
    //no arg constructor made private to stop instantiation.
  }

  // =========================================================================
  // Methods
  // =========================================================================

  /**
   * Returns if a Student ID entered into the app is a valid ID.
   * @param studentId Student ID entered into application.
   * @return Returns whether a Student ID entered into the app is valid.
   */
  public static boolean isValidId (String studentId)
  {
    if (studentId.matches(ID_PATTERN)) {
      return true;
    }
    else {
      return false;
    }
  }

  // =========================================================================
  // Getters & setters
  // =========================================================================

  public String getId()
  { return this.id; }

  public String getFirstName()
  { return this.firstName; }

  public String getLastName()
  { return this.lastName; }

}
