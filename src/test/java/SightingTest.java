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

  
}
