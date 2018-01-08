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

  //animalId
  @Test
  public void sighting_instantiatesWithAnimalId_AnimalId(){
    Sighting testSighting = new Sighting(testAnimal.getId(), testLocation.getId(), testRanger.getId(), new Timestamp(1L));
    assertEquals(testAnimal.getId(), testSighting.getAnimalId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void sighting_cannotInstantiateInvalidAnimalId_IllegalArgumentException(){
    Sighting testSighting = new Sighting(-1, testLocation.getId(), testRanger.getId(), new Timestamp(1L));
  }

  @Test
  public void setAnimalId_setsANewAnimalId_NewAnimalId() {
    Sighting testSighting = new Sighting(testAnimal.getId(), testLocation.getId(), testRanger.getId(), new Timestamp(1L));
    RegularAnimal newAnimal = new RegularAnimal("Cat");
    newAnimal.save();
    testSighting.setAnimalId(newAnimal.getId());
    assertEquals(newAnimal.getId(), testSighting.getAnimalId());
  }
  
}
