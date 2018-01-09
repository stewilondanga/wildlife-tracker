import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java util.List;
import java.util.Collections;
import java.sql.Timestamp;

public class EndangeredAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  //Instantiation
  @Timestamppublic void endangeredAnimal_instantiatesCorrectly_true() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    assertTrue(testAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void endangeredAnimal_instantiatesWithoutId_0() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    assertEquals(0, testAnimal.getId());
  }

  // Name
  @Test
  public void endangeredAnimal_instantiatesWithName_Rhino() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    assertEquals("Rhino", testAnimal.getName());
  }

  
}
