package dk.elektrostorage.endpointTest;

import dk.elektrostorage.model.Bestilling;
import dk.elektrostorage.repository.BestillingRepository;
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
public class BestillingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_Get_Bestillinger() throws Exception {

        mockMvc.perform(get("/bestilling.html"))
                .andExpect(status().is(200));
    }

    @Test
    public void test_Post_Bestilling() throws Exception {

        String json = """
            {
                "bestillingsId": 1
            }
            """;

        mockMvc.perform(post("/bestilling.html")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().is(200));
    }
    @Test
    public void test_Post_KomponentAntal() throws Exception {

        String bestillingJson = """
        {
            "bestillingsId": 1
        }
        """;

        mockMvc.perform(post("/bestilling.html")
                        .contentType("application/json")
                        .content(bestillingJson))
                .andExpect(status().isOk());


        String komponentJson = """
        {
            "komponentId": 1,
            "eksterntVarenummer": "ABC123",
            "udgaaet": false
        }
        """;

        mockMvc.perform(post("/komponenter.html")
                        .contentType("application/json")
                        .content(komponentJson))
                .andExpect(status().isOk());


        String json = """
        {
            "antal": 5,
            "bestilling": {
                "bestillingsId": 1,
                "sendt": false
            },
            "komponent": {
                "komponentId": 1,
                "eksterntVarenummer": "ABC123",
                "udgaaet": false
            }
        }
        """;

        mockMvc.perform(post("/bestilling.html/komponenter.html")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());
    }


    @Autowired
    private BestillingRepository bestillingRepository;


    @Test
    public void test_Put_Bestilling_Sendt() throws Exception {

        Bestilling bestilling = new Bestilling();
        bestilling.setBestillingsId(1);
        bestilling.setSendt(false);

        bestilling = bestillingRepository.save(bestilling);

        mockMvc.perform(put("/bestilling.html/" + bestilling.getId() + "/sendt"))
                .andExpect(status().isOk());
    }


}
