package com.sist.di4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.sist.di2","com.sist.di3","com.sist.di4"})
public class AppConfig {
   
}
