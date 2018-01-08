import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

publc class SightingTest {
  private RegularAnimal testAnimal;
  private Location testLocation;
  private Ranger testRanger;

  @Rule
  public void setUp() {
    testAnimal = new RegularAnimal("Rabbit");
    testAnimal.save();
    testLocation = new Location("Near bridge", 1.525, -2.311);
    testLocation.save();
    testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000l);
    testRanger.save();
  }

  //Instantiation
  @Test
  public void sighting_insatntiatesCorrectly_true() {
    Sighting testSighting = new Sighting(testAnimal.getId(), testLocation.getId(), testRanger.getId(), new Timestamp(1L));
    assertTrue(testSighting instanceof Sighting);
  }

  @Test
  public void sighting_instantiatesWithoutId_0() {
    Sighting testSighting = new Sighting(testAnimal.getId(), testLocation.getId(), testRanger.getId(), new Timestamp(1L));
    assertEquals(0, testSighting.getId());
  }

  
}
