package com.cong.openpdf.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cong
 * @since 2023/11/17 15:43
 */
@RestController
@RequestMapping("fruit")
public class FruitTest {

    @Autowired
    private List<Fruit> fruits;

    @GetMapping("test")
    public String test() {
        fruits.forEach(Fruit::name);
        return "1";
    }
}
