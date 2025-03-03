package pl.justitia.ingester.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.justitia.ingester.model.Item;
import pl.justitia.ingester.service.FileService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    private final String directoryPath;

    private final ObjectMapper objectMapper;

    public FileServiceImpl(@Value("${ingester.directoryPath}") String directoryPath,
                           ObjectMapper objectMapper) {
        this.directoryPath = directoryPath;
        this.objectMapper = objectMapper;
    }

    @Override
    public void saveItem(Item item) {
        String fileName = "judgment_" + item.getId() + ".json";
        File file = new File(directoryPath + "/" + fileName);

        try {
            try (FileWriter fileWriter = new FileWriter(file)) {
                objectMapper.writeValue(fileWriter, item);
                log.info("Saving file: {}", fileName);
            }
        } catch (IOException e) {
            log.error("Could not save item to file: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
