package RecordProcessor.controller;

import javafx.application.Application;

import java.io.IOException;

import RecordProcessor.model.Assessment;
import RecordProcessor.model.Subject;
import RecordProcessor.model.SubjectManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main class for Grade checker.
 */
public class RecordApplication extends Application
{
  // =========================================================================
  // Variables
  // =========================================================================

  private Stage primaryStage;

  // =========================================================================
  // Main and start methods
  // =========================================================================

  @Override
  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;

    initializeMainWindow();
  }



  public static void main(String[] args)
  {
    Application.launch();
  }



  // =========================================================================
  // Methods
  // =========================================================================

  public void initializeMainWindow()
  {
    try {

      loadSubjectData();

      FXMLLoader loader =
        new FXMLLoader(RecordApplication.class.getResource(
                        "/RecordProcessor/view/MainWindowView.fxml"));
      AnchorPane pane = loader.load();

      MainWindowController mainWindowController = loader.getController();
      mainWindowController.setMain(this, primaryStage);

      Scene scene = new Scene(pane);
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.show();
    }

    catch (IOException exception) {
      exception.printStackTrace();
    }

  }



  public void loadSubjectData()
  {
    // In real world this would be loaded from persistence... but for the purpose
    // of this assignment, simply creating the single subject

    Assessment quiz = new Assessment("Quiz", 5);
    Assessment assignment1 = new Assessment("Assignment 1", 20);
    Assessment assignment2 = new Assessment("Assignment 2", 25);
    Assessment finalExam = new Assessment("Final Exam", 50);

    Assessment[] allAssessments =
    new Assessment[]{quiz, assignment1, assignment2, finalExam};

    Subject subject =
    new Subject("ITC313", "Programming in Java 2", allAssessments);

    SubjectManager.getInstance().addSubject(subject);
  }

}
