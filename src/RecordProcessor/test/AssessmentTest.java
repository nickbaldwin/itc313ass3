package RecordProcessor.test;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Ignore;

import RecordProcessor.model.Assessment;

/**
 *
 */
public class AssessmentTest
{

  Assessment a1 = null;
  @Test
  public void canCreateAValidAssessment() throws Exception {

    a1 = new Assessment("Quiz", 20);
    assertEquals(a1 instanceof Assessment, true);
  }


  @Test
  public void testGetName() throws Exception {

    assertEquals(a1.getName(), "Quiz");
  }


  @Test
  public void testGetWeight() throws Exception {
    assertEquals(a1.getWeight(), 20);
  }

}