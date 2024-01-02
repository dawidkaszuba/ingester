package pl.medrekkaszuba.ingester.service;

import org.springframework.stereotype.Service;
import pl.medrekkaszuba.ingester.model.ImageDto;

@Service
public interface ProcessedImageService {
    void saveProcessedImageData(ImageDto imageDto);
}
