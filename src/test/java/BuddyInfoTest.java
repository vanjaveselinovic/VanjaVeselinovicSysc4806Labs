import everything.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo buddyInfo = new BuddyInfo("A", 1);

    @Test
    public void getName() throws Exception {
        assertEquals("A", buddyInfo.getName());
    }

    @Test
    public void getNumber() throws Exception {
        assertEquals(1, buddyInfo.getNumber());
    }

    @Test
    public void setName() throws Exception {
        assertEquals("A", buddyInfo.getName());
        buddyInfo.setName("B");
        assertEquals("B", buddyInfo.getName());
    }

    @Test
    public void setNumber() throws Exception {
        assertEquals(1, buddyInfo.getNumber());
        buddyInfo.setNumber(2);
        assertEquals(2, buddyInfo.getNumber());
    }
}