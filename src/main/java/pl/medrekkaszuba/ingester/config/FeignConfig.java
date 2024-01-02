package pl.medrekkaszuba.ingester.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig implements RequestInterceptor {

    @Value("${news.api.token}")
    private String token;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", token);
    }

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }

}