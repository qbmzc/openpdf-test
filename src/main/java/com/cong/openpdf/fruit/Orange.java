package com.cong.openpdf.fruit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author cong
 * @since 2023/11/17 15:42
 */
@Service
@Slf4j
public class Orange implements Fruit{
    @Override
    public void name() {
        log.info("Orange");
        System.out.println("Orange");
    }
}
