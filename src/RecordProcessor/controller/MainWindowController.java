package RecordProcessor.controller;

import java.util.ArrayList;

import RecordProcessor.model.Record;
import RecordProcessor.model.RecordManager;
import RecordProcessor.model.Student;
import RecordProcessor.model.Subject;
import RecordProcessor.model.SubjectManager;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

/**
 * Controller for main window of grade checker.
 */
public class MainWindowController
{
  // =========================================================================
  // Variables
  // =========================================================================

  private RecordApplication gradeApplication;
  private Stage primaryStage;

  private final String DEFAULT_SUBJECT_CODE = "ITC313";
  private String subjectCode;

  private int currentMark = 0;

  @FXML private TextField textFieldForStudentId;
  @FXML private Label errorLabelForStudentId;
  @FXML private TextField textFieldForQuiz;
  @FXML private Label errorLabelForQuiz;
  @FXML private TextField textFieldForAssignment1;
  @FXML private Label errorLabelForAssignment1;
  @FXML private TextField textFieldForAssignment2;
  @FXML private Label errorLabelForAssignment2;
  @FXML private TextField textFieldForFinalExam;
  @FXML private Label errorLabelForFinalExam;

  @FXML private Label title;

  @FXML private TextArea resultsTextArea;
  @FXML private Button studentMarkButton;
  @FXML private Button averageMarkButton;

  // =========================================================================
  // Constructors
  // =========================================================================

  public MainWindowController()
  {
  }

  // =========================================================================
  // Methods
  // =========================================================================

  public void initialize()
  {
    if (this.subjectCode == null) {
      this.subjectCode = DEFAULT_SUBJECT_CODE;
    }

    String subjectName =
      SubjectManager.getInstance().findSubject(subjectCode).getName();
    title.setText("Grade checker for " + subjectName);

    studentMarkButton.setOnAction( ( event ) -> {
      currentMark = 0;
      clearErrorMessages();
      clearResults();

      try {
        throwIfStudentIdIsInvalid();
        throwIfMarksAreInvalid( textFieldForQuiz,
                                errorLabelForQuiz );
        throwIfMarksAreInvalid( textFieldForAssignment1,
                                errorLabelForAssignment1 );
        throwIfMarksAreInvalid( textFieldForAssignment2,
                                errorLabelForAssignment2 );
        throwIfMarksAreInvalid( textFieldForFinalExam,
                                errorLabelForFinalExam );

        createAndAddNewRecordForSubject( subjectCode );

        displayGradeInResultsTextArea();
        clearDetails();
      } catch ( Exception exception ) {
        System.out.println( "Student record is invalid." );
      }

    } );

    averageMarkButton.setOnAction( ( event ) -> {
      clearErrorMessages();
      clearDetails();
      displayAverageGradeInResultsTextArea();
    } );

  }



  public void clearErrorMessages() {
    errorLabelForStudentId.setVisible(false);
    errorLabelForQuiz.setVisible(false);
    errorLabelForAssignment1.setVisible(false);
    errorLabelForAssignment1.setVisible(false);
    errorLabelForFinalExam.setVisible(false);
  }



  private void throwIfStudentIdIsInvalid() throws Exception {
    if (!Student.isValidId(textFieldForStudentId.getText())) {
      errorLabelForStudentId.setVisible(true);
      throw new Exception("Student ID is not an 8 digit (or less) integer");
    }
  }



  private void throwIfMarksAreInvalid(TextField textField, Label label)
    throws Exception
  {
    int mark;
    try {
      mark = Integer.parseInt(textField.getText());
    }
    catch (Exception exception) {
      label.setVisible( true );
      throw new Exception("You must enter an integer between 0 and 100.");
    }
    if (Subject.isInvalidMark(mark)) {
      label.setVisible(true);
      throw new Exception("You must enter a valid mark between 0 and 100");
    }

  }



  private void  createAndAddNewRecordForSubject(String subjectCode)
  {
    String studentId = textFieldForStudentId.getText();
    int quizMark = Integer.parseInt(textFieldForQuiz.getText());
    int assignment1Mark = Integer.parseInt(textFieldForAssignment1.getText());
    int assignment2Mark = Integer.parseInt(textFieldForAssignment2.getText());
    int finalExamMark = Integer.parseInt(textFieldForFinalExam.getText());
    int[] marks = {quizMark, assignment1Mark, assignment2Mark, finalExamMark};

    int finalMark = calculateTotalMarkForSubject(subjectCode, marks);

    // create new record for student & subject
    Record record = new Record(studentId, subjectCode, marks, finalMark);

    // add new record to collection
    RecordManager.getInstance().addRecord(record);

    // note the finalMark, to be displayed next
    currentMark = finalMark;
  }



  public int calculateTotalMarkForSubject(String subjectCode, int[] marks)
  {
    Subject currentSubject =
      SubjectManager.getInstance().findSubject( subjectCode );

    return currentSubject.calculateFinalMark(marks);
  }



  private void displayGradeInResultsTextArea()
  {
    String studentId = textFieldForStudentId.getText();
    resultsTextArea.setText("Final mark for " + studentId + ": " + currentMark);
  }



  public void displayAverageGradeInResultsTextArea()
  {
    ArrayList<Record> allStudentRecords =
      RecordManager.getInstance().getAllRecords();
    int numberOfStudentRecords = allStudentRecords.size();
    String studentOrStudents;
    if (numberOfStudentRecords > 1) {
      studentOrStudents = "students";
    }
    else studentOrStudents = "student";

    int totalOfAllMarks = calculateSumOfAllMarks( allStudentRecords);
    int averageMark = (totalOfAllMarks / numberOfStudentRecords);
    String subjectName =
      SubjectManager.getInstance().findSubject(subjectCode).getName();

    String message = "Average mark for " + numberOfStudentRecords +
                     " " + studentOrStudents + " in " + subjectName + " is: " +
                     averageMark;

    resultsTextArea.setText(message);
  }



  public int calculateSumOfAllMarks(ArrayList<Record> allStudentRecords)
  {
    int totalOfAllMarks = 0;
    for (Record record : allStudentRecords) {
      totalOfAllMarks += record.getFinalMark();
    }
    return totalOfAllMarks;
  }


  private void clearResults()
  {
    resultsTextArea.clear();
  }

int b;

  private void clearDetails()
  {
    textFieldForStudentId.clear();
    textFieldForQuiz.clear();
    textFieldForAssignment1.clear();
    textFieldForAssignment2.clear();
    textFieldForFinalExam.clear();
  }



  public void setMain(RecordApplication gradeApplication, Stage primaryStage)
  {
    this.gradeApplication = gradeApplication;
    this.primaryStage = primaryStage;
  }

}


