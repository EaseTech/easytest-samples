package org.easetech.easytest.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * Place holder configuror that injects XML based configurations
 *
 */
@Configuration
@ImportResource({"spring-config.xml"})
public class XmlBusinessConfig {

}
