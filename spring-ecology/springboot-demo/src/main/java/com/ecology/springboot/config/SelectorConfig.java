package com.ecology.springboot.config;

import com.ecology.springboot.selector.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Mr.Gao
 * @date 2023/2/27 10:49
 * @apiNote:
 */
@Configuration
@Import(MyImportSelector.class)
public class SelectorConfig {
}
