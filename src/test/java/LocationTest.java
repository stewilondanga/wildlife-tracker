import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.sql.Timestamp;
import org.junit.*;
import static org.junit.Asert.*;
import org.sql2o.*;

public class LocationTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // Instantiation
  @Test
  public void ranger_instantiatesCorrectly_true() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    assertTrue(testLocation instanceof Location);
  }

  @Test
  public void ranger_instantiatesWithoutId_0() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    assertEquals(0, testLocation.getId());
  }

  //Name
  @Test
  public void ranger_instantiatesWithName_User() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    assertEquals("Near bridge", testLocation.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void ranger_cannotInstantiateEmptyUserName_IllegalArgumentException() {
    Location testLocation = new Location("", 1.525, -2.311);
  }

  @Test
  public void setUserName_setsANewName_NewName() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    testLocation.setName("NewName");
    assertEquals("NewName", testLocation.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setUserName_cannotSetEmptyName_IllegalArgumentException() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    testLocation.setName("");
  }

  @Test
  public void save_savesNameToDB_Nearbridge() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    testLocation.save();
    Location savedLocation = Location.find(testLocation.getId());
    assertEquals("Near bridge", savedLocation.getName());
  }

  @Test
  public void update_preservesOriginalName_Nearbridge() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    testLocation.save();
    testLocation.update();
    Location savedLocation = Location.find(testLocation.getId());
    assertEquals("Near bridge", savedLocation.getName());
  }

  @Test
  public void update_savesNewNameToDB_NewLocation() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    testLocation.save();
    testLocation.setName("New Location");
    testLocation.update();
    Location savedLocation = LOcation.find(testLocation.getId());
    assertEquals("New Location", savedLocation.getName());
  }

  // xCoord
  @Test
  public void ranger_instantiatesWithXCoord_1_525() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    assertEquals(1.525, testLocation.getXCoord(), 0);
  }

  @Test
  public void setXCoord_setsANewXCoord_3_885() {
    Location testLocation = new Location("Near bridge", 1.525, -2.311);
    testLocation.setXCoord(3.885);
    assertEquals(3.885, testLocation.getXCoord(), 0);
  }

  
}
