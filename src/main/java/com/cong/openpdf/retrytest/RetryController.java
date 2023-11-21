package com.cong.openpdf.test.retrytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cong
 * @since 2023/11/17 10:08
 */
@RestController
@RequestMapping("retry")
public class RetryController {

    @Autowired
    private RetryService retryService;

    @GetMapping
    public String test() {

        retryService.doRetry();
        return "1";
    }
}
