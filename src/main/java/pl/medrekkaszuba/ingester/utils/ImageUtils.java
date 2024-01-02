package pl.medrekkaszuba.ingester.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@UtilityClass
public class ImageUtils {

    public static boolean isValidURL(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException e) {
            log.warn("[NewsDao] Provided URL: \"{}\" is not valid", urlString);
            return false;
        }
    }
}
