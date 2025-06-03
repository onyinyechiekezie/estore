package org.estore.estore.controller;

import lombok.AllArgsConstructor;
import org.estore.estore.integration.CloudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("api/v1/media")
@AllArgsConstructor
public class MediaController {

    private final CloudService cloudService;

    @GetMapping(produces = {MediaType.IMAGE_PNG_VALUE, "video/mp4"})
    public ResponseEntity<?> getMedia(@RequestParam String blobId) {
        cloudService.getFileBy(blobId);
        return ResponseEntity.status(HttpStatus.OK).body(cloudService.getFileBy(blobId));
    }
}
