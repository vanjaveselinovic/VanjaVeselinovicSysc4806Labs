package everything;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HttpRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void appShouldReturnDefaultEmptyMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(content().string(containsString("address books")));
    }

    @Test
    public void appShouldReturnAddressBookAfterPost() throws Exception {
        this.mockMvc.perform(post("/addressbooks").content("{}"));
        this.mockMvc.perform(get("/addressbooks")).andDo(print()).andExpect(content().string(containsString("addressbooks/1")));
    }

    @Test
    public void appShouldReturnBuddyAfterPost() throws Exception {
        this.mockMvc.perform(post("/buddies").content("{\"name\": \"a\", \"number\": \"1\"}"));
        this.mockMvc.perform(get("/buddies/1")).andDo(print()).andExpect(content().string(containsString("\"name\" : \"a\"")));
        this.mockMvc.perform(get("/buddies/1")).andDo(print()).andExpect(content().string(containsString("\"number\" : 1")));
    }

    @Test
    public void appShouldReturnBuddyAfterAddingItToAddressBook() throws Exception {
        this.mockMvc.perform(post("/addressbooks").content("{}"));
        this.mockMvc.perform(post("/buddies").content("{\"name\": \"a\", \"number\": \"1\"}"));
        this.mockMvc.perform(get("/addbuddy?addressBookId=1&buddyInfoId=1"));
        this.mockMvc.perform(get("/addressbooks/1/buddies/1")).andDo(print()).andExpect(content().string(containsString("\"name\" : \"a\"")));
        this.mockMvc.perform(get("/addressbooks/1/buddies/1")).andDo(print()).andExpect(content().string(containsString("\"number\" : 1")));
    }
}