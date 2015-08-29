package RecordProcessor.model;

import java.util.HashMap;

/**
 * Singleton manager of collection fof subjects.
 */
public class SubjectManager {

  // =========================================================================
  // Variables
  // =========================================================================

  private static SubjectManager instance = null;

  private HashMap<String, Subject> allSubjects;

  // =========================================================================
  // Constructors
  // =========================================================================

  public SubjectManager()
  {
    this.allSubjects = new HashMap<String, Subject>();
  }

  // =========================================================================
  // Methods
  // =========================================================================

  public void addSubject(Subject subject)
  {
    this.allSubjects.put(subject.getCode(), subject);
  }

  public Subject findSubject(String subjectCode)
  {
    return this.getAllSubjects().get(subjectCode);
  }

  // =========================================================================
  // Getters & setters
  // =========================================================================

  public static SubjectManager getInstance() {
    if (SubjectManager.instance == null) {
      SubjectManager.instance = new SubjectManager();
    }
    return SubjectManager.instance;
  }



  public HashMap<String, Subject> getAllSubjects()
  {
    return this.allSubjects;
  }

}
