package RecordProcessor.model;

import java.util.HashMap;

/**
 * Singleton manager of collection fof subjects.
 */
public class StudentManager {

  // =========================================================================
  // Variables
  // =========================================================================

  private static StudentManager instance = null;

  private HashMap<String, Student> allStudents;

  // =========================================================================
  // Constructors
  // =========================================================================

  public StudentManager()
  {
    this.allStudents = new HashMap<String, Student>();
  }

  // =========================================================================
  // Methods
  // =========================================================================

  public void addStudent(Student student)
  {
    this.allStudents.put( student.getId(), student );
  }

  public Student findStudent( String studentId )
  {
    return this.getAllStudents().get(studentId);
  }

  // =========================================================================
  // Getters & setters
  // =========================================================================

  public static StudentManager getInstance() {
    if (StudentManager.instance == null) {
      StudentManager.instance = new StudentManager();
    }
    return StudentManager.instance;
  }



  public HashMap<String, Student> getAllStudents()
  {
    return this.allStudents;
  }

}
