package pl.medrekkaszuba.ingester.dao;

import org.springframework.stereotype.Component;
import pl.medrekkaszuba.ingester.model.Image;
import pl.medrekkaszuba.ingester.model.ImageDto;
import pl.medrekkaszuba.ingester.model.ImageStatus;
import pl.medrekkaszuba.ingester.repository.ImageRepository;

import java.util.List;

@Component
public class ImageDao {


    private final ImageRepository imageRepository;

    public ImageDao(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void saveImage(ImageDto imageDto) {
        List<Image> imageList = imageRepository.findByNewsItemId(imageDto.getNewsItemId());
        imageList.forEach(image -> {
            image.setUrl(imageDto.getUrl());
            image.setStatus(ImageStatus.READY);
            imageRepository.save(image);
        });
    }
}
