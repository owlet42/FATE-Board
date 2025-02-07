/*
 * Copyright 2019 The FATE Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webank.ai.fate.board.bootstrap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SessionAutoConfiguration.class})
@ServletComponentScan(basePackages = {"com.webank.ai.fate.board.conf"})
@ComponentScan(basePackages = {"com.webank.ai.fate.*"})
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
@Configuration
@EnableScheduling
@EnableFeignClients(basePackages = "com.webank.ai.fate.*")

public class Bootstrap {
    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext context = SpringApplication.run(Bootstrap.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
