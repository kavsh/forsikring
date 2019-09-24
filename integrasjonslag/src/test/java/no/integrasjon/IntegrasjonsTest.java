package no.integrasjon;

import no.forsikring.fagsystem.service.FagsystemService;
import no.forsikring.integrasjonslag.controller.AvtaleController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AvtaleController.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class IntegrasjonsTest extends AbstractTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @MockBean
    private FagsystemService service;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void createProduct() throws Exception {
        String uri = "/fagsystem/api/v1/avtale/ny";

        String tmp = "{\"avtale\": {" +
                "    \"kategori\": \"BOLIG\"," +
                "    \"kunderNummer\": \"123\" " +
                "  }," +
                "   \"dato\": \"2020-01-01\"," +
                "  \"kunde\": {" +
                "  \"fodelsedato\":\"123456789\"," +
                "  \"fornavn\":\"fornavn\"," +
                "  \"etternavn\":\"etternavn\"," +
                "  \"telNummer\":\"123456789\"," +
                "  \"email\":\"test@ftind.no\"," +
                "  \"avtaler\":" +
                "  [{" +
                "  \"kategori\": \"BOLIG\"," +
                "    \"kunderNummer\": \"123\"" +
                "  }]" +
                "  " +
                "  }" +
                "}";

        this.mockMvc.perform(post("/fagsystem/api/v1/avtale/ny")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(tmp))
                .andExpect(status().isOk());
    }
}