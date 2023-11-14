package com.cong.openpdf.test.sse;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author cong
 * @since 2023/11/14 14:44
 */
@Slf4j
public class MyEvent extends ApplicationEvent {

    @Setter
    @Getter
    private String userId;

    public MyEvent(String eventType) {
        super(eventType);
        log.info(eventType);
    }
}
