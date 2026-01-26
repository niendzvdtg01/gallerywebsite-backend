package com.gallery.backend.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.gallery.backend.Properties.CloudnaryProperties;

@Configuration
@ConfigurationProperties(prefix = "cloudinary")
public class CloudnaryConfig {
    private final CloudnaryProperties props;

    public CloudnaryConfig(CloudnaryProperties props) {
        this.props = props;
    }

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", props.getCloudName());
        config.put("api_key", props.getApiKey());
        config.put("api_secret", props.getApiSecret());
        return new Cloudinary(config);
    }
}
