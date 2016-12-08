package pl.opms.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.net.URISyntaxException;

/**
 * Created by Piotr Borczyk on 07.12.2016.
 */

@Configuration
public class RdbmsPropertyPlaceholderConfig {
    @Bean
    public PropertyPlaceholderConfigurer properties() throws URISyntaxException {
        PropertyPlaceholderConfigurer property = new PropertyPlaceholderConfigurer();
        property.setLocations(new Resource[]{
                new ClassPathResource("jdbc.properties")});
        return property;

    }
}
