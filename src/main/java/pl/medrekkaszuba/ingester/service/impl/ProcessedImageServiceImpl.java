package pl.medrekkaszuba.ingester.service.impl;

import org.springframework.stereotype.Service;
import pl.medrekkaszuba.ingester.dao.ImageDao;
import pl.medrekkaszuba.ingester.model.ImageDto;
import pl.medrekkaszuba.ingester.service.ProcessedImageService;

@Service
public class ProcessedImageServiceImpl implements ProcessedImageService {


    private final ImageDao imageDao;

    public ProcessedImageServiceImpl(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public void saveProcessedImageData(ImageDto imageDto) {
        imageDao.saveImage(imageDto);
    }
}
