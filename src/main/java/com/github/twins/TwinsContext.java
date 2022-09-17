package com.github.twins;

import lombok.Data;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
@Data
public class TwinsContext {

    private TwinsConfiguration configuration;

    public TwinsContext() {
        this.configuration = new TwinsConfiguration();
    }
}
