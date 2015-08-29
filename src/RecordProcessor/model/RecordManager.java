package RecordProcessor.model;

import RecordProcessor.model.Record;
import java.util.ArrayList;

/**
 * Singleton manages collection of Records.
 */
public class RecordManager {

  // =========================================================================
  // Variables
  // =========================================================================

  private static RecordManager instance = null;

  private ArrayList<Record> allRecords;

  // =========================================================================
  // Constructors
  // =========================================================================

  public RecordManager()
  {
    this.allRecords = new ArrayList<Record>();
  }

  // =========================================================================
  // Methods
  // =========================================================================

  public void addRecord(Record record)
  {
    this.allRecords.add(record);
  }

  // =========================================================================
  // Getters & setters
  // =========================================================================

  public static RecordManager getInstance() {
    if (RecordManager.instance == null) {
      RecordManager.instance = new RecordManager();
    }
    return RecordManager.instance;
  }



  public ArrayList<Record> getAllRecords()
  {
    return this.allRecords;
  }

}
