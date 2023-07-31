package com.quangtt.commoncode.common.config;

import com.quangtt.commoncode.domain.model.KeyValueService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppStartupRunner implements ApplicationRunner {

    KeyValueService keyValueService;

    @Override
    public void run(ApplicationArguments args) {
        this.keyValueService.refreshCodeCategory();
    }
}
