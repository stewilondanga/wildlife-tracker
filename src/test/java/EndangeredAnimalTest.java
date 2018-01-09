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

  @Test(expected = IllegalArgumentException.class)
  public void endangeredAnimal_cannotInstantiateNegativeAge_IllegalArgumentException() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", -1.5, "Good");
  }

  @Test
  public void setAge_setsANewAge_2_1() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.setAge(2.1);
    assertEquals(2.1, testAnimal.getAge(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setAge_cannotSetNegativeAge_IllegalArgumentException() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.setAge(-1.5);
  }

  @Test
  public void save_savesAgeToDB_1_5() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals(1.5, savedAnimal.getAge(), 0);
  }

  @Test
  public void update_preservesOriginalAge_1_5() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    testAnimal.update();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal,getId());
    assertEquals(1.5, savedAnimal.getAge(), 0);
  }

  @Test
  public void update_savesNewAgeToDB_2_1() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    testAnimal.setAge(2.1);
    testAnimal.update();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals(2.1, savedAnimal.getAge(), 0);
  }

  // Health
  @Test
  public void endangeredAnimal_instantiatesWithHealth_Good() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    assertEquals("Good", testAnimal.getHealth());
  }

  @Test
  public void setHealth_setsANewHealth_Poor() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.setHealth("Poor");
    assertEquals("Poor", testAnimal.getHealth());
  }

  @Test
  public void save_savesHealthToDB_Good() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals("Good", savedAnimal.getHealth());
  }

  @Testpublic void update_preservesOriginalHealth_Good() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    testAnimal.update();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals("Good", savedAnimal.getHealth());
  }

  @Test
  public void update_savesNewHealthToDB_Poor() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    testAnimal.setHealth("Poor");
    testAnimal.update();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertEquals("Poor", savedAnimal.getHealth());
  }

  //Database methods
  @Test
  public void save_setsTheId_int() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    assertTrue(testAnimal.getId() > 0);
  }

  @Test
  public void save_insertsObjectIntoDB_true() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    testAnimal.save();
    EndangeredAnimal savedAnimal = EndangeredAnimal.find(testAnimal.getId());
    assertTrue(testAnimal.equals(savedAnimal));
  }

  @Test(expected = IllegalArgumentException.class)
  public void save_cannotSaveIfNameAlreadyExists_IllegalArgumentException() {
    EndangeredAnimal firstAnimal = new EndangeresAnimal("Rhino", 1.5, "Good");
    firstAnimal.save();
    EndangeredAnimal secondAnimal = new EndangeredAnimal("Rhino", 1.5, "Good");
    secondAnimal.save();
  }

  
}
