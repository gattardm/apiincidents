package org.medhead.emergencysystem.apiincidents;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IncidentsAPITest {
    @Autowired
    public MockMvc mockMvc;

    @Test
    public void testConnexion() throws Exception {
        mockMvc.perform(get("/incidents")).andExpect(status().isOk());
    }

    @Test
    public void testGetIncident1Creation() throws Exception {
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[0].type", is("Accident 1")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[0].specialityNeeded", is("Anaesthetics")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[0].longitude", is("-20")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[0].latitude", is("20")));
    }

    @Test
    public void testGetIncident2Creation() throws Exception {
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[1].type", is("Accident 2")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[1].specialityNeeded", is("Intensive care medicine")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[1].longitude", is("20")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[1].latitude", is("20")));
    }
    @Test
    public void testGetIncident3Creation() throws Exception {
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[2].type", is("Accident 3")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[2].specialityNeeded", is("Additional dental specialities")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[2].longitude", is("20")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[2].latitude", is("-20")));
    }
    @Test
    public void testGetIncident4Creation() throws Exception {
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[3].type", is("Accident 4")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[3].specialityNeeded", is("Oral and maxillofacial surgery")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[3].longitude", is("-20")));
        mockMvc.perform(get("/incidents")).andExpect(jsonPath("$[3].latitude", is("-20")));
    }
}
