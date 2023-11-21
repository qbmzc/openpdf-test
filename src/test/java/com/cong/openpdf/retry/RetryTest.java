package com.cong.openpdf.test.retry;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

/**
 * @author cong
 * @since 2023/11/17 10:01
 */
@Slf4j
@EnableRetry
@SpringBootTest
public class RetryTest {


    @Test
    void test() {
        doRetry();
    }

    @Retryable(value = Exception.class)
    public void doRetry() {

        for (int i = 0; i < 3; i++) {
            if (i < 2) {
                System.out.println("执行失败即将重试" + i);
                throw new RuntimeException();
            }
        }
        System.out.println("执行成功");
    }
}
