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

  @Test(expected = IllegalArgumentException.class)
  public void endangeredAnimal_cannotInstantiateEmptyName_IllegalArgumentException(){
    EndangeredAnimal testAnimal = new EndangeredAnimal("", 1.5, "Good");
  }

  @Test
  public void setName_setsANewName_Panda() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.setName("Panda");
    assertEquals("Panda", testAnimal.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setName_cannotSetEmptyName_IllegalArgumentException() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.setName("");
  }

  @Test
  public void save_savesNameToDB_Rhino() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals("Rhino", savedAnimal.getName());
  }

  @Test
  public void update_preservesOriginalName_Rhino() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    testAnimal.update();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals("Rhino", savedAnimal.getName());
  }

  @Test
  public void update_savesNewNameToDB_Panda() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    testAnimal.setName("Panda");
    testAnimal.update();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals("Panda", savedAnimal.getName());
  }

  // Age
  @Test
  public void endangeredAnimal_instantiatesWIthAge_1_5() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    assertEquals(1.5, testAnimal.getAge(), 0);
  }

  
}
