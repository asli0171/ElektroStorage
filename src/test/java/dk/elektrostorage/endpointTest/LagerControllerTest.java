package dk.elektrostorage.endpointTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_Get_Komponenter() throws Exception {

        mockMvc.perform(get("/lager"))
                .andExpect(status().is(200));
    }

    @Test
    public void test_Post_registrerOptaelling() throws Exception {

        String json = """
                {
                    "komponent": {
                        "komponentId": 1
                    },
                    
                    "antal": 10,
                    "optaltAf": "Test"
                }
                """;

        mockMvc.perform(post("/lager")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().is(200));
    }
}
