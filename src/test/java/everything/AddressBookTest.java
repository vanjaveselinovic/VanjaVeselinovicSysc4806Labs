package everything;

import everything.AddressBook;
import everything.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();
    BuddyInfo buddy1 = new BuddyInfo("A", 1);
    BuddyInfo buddy2 = new BuddyInfo("B", 2);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void addBuddy() throws Exception {
        assertEquals(0, addressBook.getBuddies().size());
        addressBook.addBuddy(buddy1);
        assertEquals(1, addressBook.getBuddies().size());
        addressBook.addBuddy(buddy2);
        assertEquals(2, addressBook.getBuddies().size());
    }

    @Test
    public void removeBuddy() throws Exception {
        addressBook.addBuddy(buddy1);
        assertEquals(1, addressBook.getBuddies().size());
        addressBook.removeBuddy(buddy1);
        assertEquals(0, addressBook.getBuddies().size());
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        assertEquals(2, addressBook.getBuddies().size());
        addressBook.removeBuddy(buddy1);
        assertEquals(1, addressBook.getBuddies().size());
        addressBook.removeBuddy(buddy2);
        assertEquals(0, addressBook.getBuddies().size());
    }

    /*

    @Test
    public void printBuddyByObject() throws Exception {
        addressBook.addBuddy(buddy1);
        addressBook.printBuddy(buddy1);
        assertEquals("Name: A\r\nNumber: 1\r\n", outContent.toString());
    }

    @Test
    public void printBuddyByIndex() throws Exception {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.printBuddy(1);
        assertEquals("Name: B\r\nNumber: 2\r\n", outContent.toString());
    }

    @Test
    public void printBuddies() throws Exception {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.printBuddies();
        assertEquals(
                "Buddy 0\r\n"+
                        "Name: A\r\n"+
                        "Number: 1\r\n"+
                        "----------\r\n"+
                        "Buddy 1\r\n"+
                        "Name: B\r\n"+
                        "Number: 2\r\n"+
                        "----------\r\n",
                outContent.toString()
        );
    }

    */
}