package RecordProcessor.model;

import RecordProcessor.model.Assessment;

/**
 * Subject captures assessment information and provides methods to calculate
 * a total mark for each subject, as well as validating marks.
 */
public class Subject
{
  // =========================================================================
  // Variables
  // =========================================================================

  private static final int MINIMUM_MARK = 0;
  private static final int MAXIMUM_MARK = 100;

  private String code;
  private String name;
  private Assessment[] allAssessmentWeights;

  // =========================================================================
  // Constructors
  // =========================================================================

  public Subject(String code, String name, Assessment[] allAssessmentWeights)
  {
    this.code = code;
    this.name = name;
    this.allAssessmentWeights = allAssessmentWeights;;
  }

  // =========================================================================
  // Methods
  // =========================================================================

  public static boolean isInvalidMark(int mark) {
    boolean isLessThanValidMinimum = mark < MINIMUM_MARK;
    boolean isMoreThanValidMaximum = mark > MAXIMUM_MARK;

    return isLessThanValidMinimum || isMoreThanValidMaximum;
  }


  public int calculateFinalMark(int[] results)
  {
    int totalMark = 0;
    int weightedMark;
    for (int i = 0; i < results.length; i++) {
      weightedMark = (results[i] *
                      this.allAssessmentWeights[i].getWeight()) / 100;
      totalMark += weightedMark;
    }
    return totalMark;
  }

  // =========================================================================
  // Getters & setters
  // =========================================================================


  public String getCode()
  { return this.code; }

  public String getName()
  { return this.name; }

  public Assessment[] getAssessmentWeights()
  { return this.allAssessmentWeights; }

}
