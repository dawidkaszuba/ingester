package pl.medrekkaszuba.service.impl;

import org.springframework.stereotype.Service;
import pl.medrekkaszuba.dao.ImageDao;
import pl.medrekkaszuba.model.ImageDto;
import pl.medrekkaszuba.service.ProcessedImageService;

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
