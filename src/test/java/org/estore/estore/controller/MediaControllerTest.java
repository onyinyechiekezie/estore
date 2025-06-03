package org.estore.estore.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
public class MediaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetMedia() throws Exception {
        String blobId = "";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/media/")
                .queryParam("blobId", blobId))

                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}
