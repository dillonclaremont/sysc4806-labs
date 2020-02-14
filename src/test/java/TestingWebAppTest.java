import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import AddressBook.WebLauncher;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes= {WebLauncher.class})
@AutoConfigureMockMvc
public class TestingWebAppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAddressBook() throws Exception {
        this.mockMvc.perform(post("/restNewAddressBook")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(post("/restAddBuddy").param("id", "1").param("name", "ThomasTheBrykenator").param("phonenumber", "42069")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/restGetAddressBook").param("id", "1")).andDo(print()).andExpect(status().isOk());
    }
}