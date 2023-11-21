package com.cong.openpdf.retrytest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cong
 * @since 2023/11/17 10:10
 */
@Slf4j
@Service
public class RetryService {

    private volatile AtomicInteger i = new AtomicInteger(0);

    public void doRetry() {
        doRetry2();
    }

    @Retryable(value = Exception.class)
    public void doRetry2() {

        if (i.get() < 2) {
            i.getAndIncrement();
            System.out.println("执行失败即将重试" + i);
            throw new RuntimeException();
        }

        System.out.println("执行成功");
    }
}
