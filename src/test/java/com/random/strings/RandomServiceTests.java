package com.random.strings;


import com.random.strings.services.RandomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

@SpringBootTest
public class RandomServiceTests {

    @Autowired
    RandomService randomService;

    /*
     * random successful
     */
    @Test
    public void random1(){
        StringBuilder data = randomService.generatedString();
        AssertionErrors.assertNotNull("Genarate successful",  data.toString());
    }


}
