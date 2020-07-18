package com.random.strings;


import com.random.strings.dtos.RandomDto;
import com.random.strings.services.ProcessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class ProcessServiceTest {

    @Autowired
    private ProcessService processService;


    /*
     * case successful
     */
    @Test
    public void process1() {
        RandomDto randomDto = new RandomDto(100);
        boolean success = processService.process(randomDto);
        assertTrue("success", success);

    }

    /**
     * case fail
     * condition is null
     */
    @Test
    public void process2(){
        boolean success = processService.process(null);
        assertFalse("fail", success);
    }


}
