package com.example.etag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import com.example.version.ResourceVersion;

@Configuration
public class EtagFilterConfiguration {

    @Autowired
    private ResourceVersion resourceVersion;

    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter() {
        FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean
            = new FilterRegistrationBean<>(new ShallowEtagHeaderFilter());
        filterRegistrationBean.addUrlPatterns("/etag", "/resources/" + resourceVersion.getVersion() + "/js/index.js");
        return filterRegistrationBean;
    }
}
