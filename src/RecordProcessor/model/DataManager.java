package RecordProcessor.model;

import java.io.File;
import java.io.IOException;

/**
 * Responsible for loading data from database, holding the transformed set
 * of data used by the application and saving data back to the database.
 */
public class DataManager
{
  //===========================================================================
  // Variables
  //===========================================================================

  private static DataManager instance_ = null;

  private int recordsReadSuccessfully = 0;
  private int recordsReadUnsuccessfully = 0;

  private String database;
  //
  //

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates and initializes a new DataManager instance following the singleton
   * pattern. Creation of new instances is restricted through private access
   * modifier.
   */
  private DataManager()
  {
    initialize();
  }

  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * Returns the sole DataManager instance (following the singleton pattern).
   * @return DataManager instance responsible for managing data from file.
   */
  public static DataManager getInstance()
  {
    if (instance_ == null) {
      instance_ = new DataManager();
    }
    return instance_;
  }

  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * Initializes singleton instance DataManager and loads data from file (if
   * it exists, or creates file if necessary.
   */
  public void initialize()
  {
    try {
      loadPointOfInterestTypes();
      loadPointsOfInterestFromDatabase( database );
      printDataReportToConsole();
    }
    catch (Exception exception) {
      logAndThrowException("Data Manager : initialize: Exception");
    }

  }



  /**
   * Logs exceptions thrown with message.
   * @param callingMethodAndExceptionMessage String exception message.
   */
  private void logAndThrowException(String callingMethodAndExceptionMessage)
  {
    String errorMessage = "DataManager : " + callingMethodAndExceptionMessage;
    System.err.printf("%s", errorMessage + "\n");
    throw new RuntimeException(errorMessage);
  }



  /**
   * Loads data from file.
   *
   */
  public void loadPointsOfInterestFromDatabase( String database )
  {

    // try { }

    // catch (IOException exception) { }

    // finally { }

  }

  public void loadPointOfInterest(String something)
  {

    // try { }

    // catch (IOException exception) { }

    // finally { }

  }


  public void loadPointOfInterestTypes()
  {

  }






  public void printDataReportToConsole()
  {
    System.out.println("Read " + this.recordsReadSuccessfully + " point of " +
                       "interest successfully.");
    System.out.println("Read " + this.recordsReadUnsuccessfully + " point of " +
                         "interest unsuccessfully.");
  }

}
