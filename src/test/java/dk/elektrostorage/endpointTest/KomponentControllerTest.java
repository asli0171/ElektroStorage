package dk.elektrostorage.endpointTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class KomponentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_Get_Komponenter() throws Exception {

        mockMvc.perform(get("/komponenter"))
                .andExpect(status().is(200));
    }

    @Test
    public void test_Post_Komponent() throws Exception {

        String json = """
                {
                    "komponentId": 1,
                    "eksterntVarenummer": "ABC123",
                    "udgaaet": false
                }
                """;

        mockMvc.perform(post("/komponenter")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().is(200));
    }

    @Test
    public void test_Put_Komponent_Udgaaet() throws Exception {

        String json = """
                {
                    "komponentId": 1,
                    "eksterntVarenummer": "145",
                    "udgaaet": false
                }
                """;

        mockMvc.perform(post("/komponenter")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        mockMvc.perform(put("/komponenter/1/udgaaet"))
                .andExpect(status().isOk());
    }
}
