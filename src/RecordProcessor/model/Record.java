package RecordProcessor.model;

/**
 * Record captures a Student's Record (marks in assignments etc) in a Subject
 */
public class Record
{
  // =========================================================================
  // Variables
  // =========================================================================

  private String studentId;
  private String subjectCode;
  private int quizResult;
  private int assignment1Result;
  private int assignment2Result;
  private int finalExamResult;

  private int finalMark;

  // =========================================================================
  // Constructors
  // =========================================================================

  public Record(String studentId, String subjectCode, int[] results, int finalMark)
  {
    this.studentId = studentId;
    this.subjectCode = subjectCode;
    this.quizResult = results[0];
    this.assignment1Result = results[1];
    this.assignment2Result = results[2];
    this.finalExamResult = results[3];
    this.finalMark = finalMark;
  }

  // =========================================================================
  // Getters & setters
  // =========================================================================

  public String getStudentId()
  { return studentId; }

  public String getSubjectCode()
  { return subjectCode; }

  public int getFinalMark()
  { return this.finalMark; }

  public void setStudentId(String studentId)
  { this.studentId = studentId; }

  public void setSubjectCode(String subjectCode)
  { this.subjectCode = subjectCode; }

}
