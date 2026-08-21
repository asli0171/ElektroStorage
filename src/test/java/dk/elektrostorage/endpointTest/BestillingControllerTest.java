package dk.elektrostorage.endpointTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BestillingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_Get_Bestillinger() throws Exception {

        mockMvc.perform(get("/bestillinger"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_Get_Bestilling() throws Exception {

        mockMvc.perform(get("/bestillinger/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_Post_Bestilling() throws Exception {

        String json = """
                {
                    "leverandoer": {
                        "id": 1
                    }
                }
                """;

        mockMvc.perform(post("/bestillinger")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void test_Post_KomponentAntal() throws Exception {

        String json = """
                {
                    "bestillingId": 3,
                    "komponentId": 102,
                    "antal": 5
                }
                """;

        mockMvc.perform(post("/bestillinger/komponenter")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void test_Put_Bestilling_Sendt() throws Exception {

        mockMvc.perform(put("/bestillinger/1/sendt"))
                .andExpect(status().isOk());
    }
}
