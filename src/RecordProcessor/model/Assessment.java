package RecordProcessor.model;

/**
 * Simple data structure for Assessment name and weight e.g. {"Quiz", 20}
 */
public class Assessment {

  // =========================================================================
  // Variables
  // =========================================================================

  private String name;
  private int weight;

  // =========================================================================
  // Constructors
  // =========================================================================

  public Assessment(String name, int weight)
  {
    this.name = name;
    this.weight = weight;
  }

int a;

  // =========================================================================
  // Getters & setters
  // =========================================================================

  public String getName()
  {
    return this.name;
  }


  public int getWeight()
  {
    return this.weight;
  }


}
