package com.fibonacci.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoApplicationTests {

    @Autowired
    private FibonacciService fibonacciService;

    @TestConfiguration
    static class FibonacciServiceTestContextConfiguration{
        @Bean
        public FibonacciService fibonacciService(){

            return new FibonacciService();

        }
    }

    @Test
    void testFibonacci(){

       int testValue= fibonacciService.fibonacciRecursion(10);

       int expected = 55;

        Assertions.assertEquals(expected,testValue);


    }


}
