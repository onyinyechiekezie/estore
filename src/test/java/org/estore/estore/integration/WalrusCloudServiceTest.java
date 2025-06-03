package org.estore.estore.integration;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
public class WalrusCloudServiceTest {
    @Autowired
    private CloudService cloudService;

    @Test
    void testCanUploadFile() {
        String fileLocation = "C:\\Users\\DELL\\Desktop\\byte_builder_store\\estore\\src\\test\\resources\\assets\\iphone16.jpg";
        Path path = Paths.get(fileLocation);
        try(var inputStream = Files.newInputStream(path)) {
            MultipartFile file = new MockMultipartFile("image", inputStream);
            String blobId = cloudService.upload(file);
            log.info("blobId: {}", blobId);
            assertThat(blobId).isNotNull();
            assertThat(blobId).isNotEmpty();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testCanGetFile() {
        String blobId = "";
        byte[] fileContent = cloudService.getFileBy(blobId);
        log.info("data--> {}", fileContent);
        assertThat(fileContent).isNotNull();
        assertThat(fileContent).isNotEmpty();
    }
}
