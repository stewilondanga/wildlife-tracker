import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.sql.Timestamp;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class RangerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // Instantiation
  @Test
  public void ranger_instantiatesCorrectly_true() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    assertTrue(testRanger instanceof Rnager);
  }

  @Test
  public void ranger_instatiatesWithoutId_0() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    assertEquals(0, testRanger.getId());
  }

  // User Name
  @Testpublic void ranger_instantiatesWithName_User() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    assertEquals("User", testRanger.getUserName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void ranger_cannotInstantiateEmptyUserName_IllegalArgumentException() {
    Ranger testRanger = new Ranger("", "Mjanja", "Mwenyewe", 1, 5035550000L);
  }

  @Test
  public void setUserName_setsANewName_NewUser() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.setUserName("NewUser");
    assertEquals("NewUser", testRanger.getUserName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setUserName_cannotSetEmptyName_IllegalArgumentException() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.setUserName("");
  }

  @Test
  public void save_savesUserNameToDB_User() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("User", savedRanger.getUserName());
  }

  @Test
  public void update_preservesOriginalUserName_User() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    testRanger.update();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("User", savedRanger.getUserName());
  }

  @Test
  public void update_savesNewUserNameToDB_NewUser() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    testRanger.setUserName("NewUser");
    testRanger.update();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("NewUser", savedRanger.getUserName());
  }

  // First Name
  @Test
  public void ranger_instantiatesWithName_Mjanja() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    assertEquals("Mjanja", testRanger.getFirstName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void ranger_cannotInstantiateEmptyFirstName_IllegalArgumentException() {
    Ranger testRanger = new Ranger("User", "", "Mwenyewe", 1, 5035550000L);
  }

  @Test
  public void setFirstName_setsANewName_Tom() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.setFirstName("Tom");
    assertEquals("Tom", testRanger.getFirstName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setName_cannotSetEmptyName_IllegalArgumentException() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.setFirstName("");
  }

  @Test
  public void save_savesFirstNameToDB_Mjanja() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("Mjanja", savedRanger.getFIrstName());
  }

  @Test
  public void update_preservesOriginalFirstName_Mjanja() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    testRanger.update();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("Mjanja", savedRanger.getFirstName());
  }

  @Test
  public void update_savesNewFirstNameToDB_Tom() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    testRanger.setFirstName("Tom");
    testRanger.update();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("Mjanja", savedRanger.getFirstName());
  }

  // Last Name
  @Test
  public void ranger_intantiatesWithName_Smith() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    assertEquals("Mwenyewe", testRanger.getLastName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void ranger_cannotInstantiateEmptyLastName_IllegalArgumentException() {
    Ranger testRanger = new Ranger("User", "Mjanja", "", 1, 5035550000L);
  }

  @Test
  public void setFirstName_setsANewName_Johnson() {
    Ranger testRanger = new Ranger("User", "Majanja", "Mwenyewe", 1, 5035550000L);
    testRanger.setLastName("Johnson");
    assertEquals("Johnson", testRanger.getLastName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setLastName_cannotSetEmptyName_IllegalArgumentException() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.setLastName("");
  }

  @Testpublic void save_savesLastNameToDB_Smith() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    Ranger savedRanger = Ranger. find(testRanger.getId());
    assertEquals("Mwenyewe", savedRanger.getLastName());
  }

  @Test
  public void update_preservesOriginalLastName_Smith() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    testRanger.update();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("Mwenyewe", savedRanger.getLastName());
  }

  @Test
  public void update_savesNewLastNameToDB_Johnson() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    testRanger.save();
    testRanger.setLastName("Johnson");
    testRanger.update();
    Ranger savedRanger = Ranger.find(testRanger.getId());
    assertEquals("Johnson", savedRanger.getLastName());
  }

  // Badge
  @Test
  public void ranger_instantiatesWithBadge_1() {
    Ranger testRanger = new Ranger("User", "Mjanja", "Mwenyewe", 1, 5035550000L);
    assertEquals(1, testRanger.getBadge());
  }

  
}
