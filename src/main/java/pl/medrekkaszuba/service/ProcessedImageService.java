package pl.medrekkaszuba.service;

import org.springframework.stereotype.Service;
import pl.medrekkaszuba.model.ImageDto;

@Service
public interface ProcessedImageService {
    void saveProcessedImageData(ImageDto imageDto);
}
