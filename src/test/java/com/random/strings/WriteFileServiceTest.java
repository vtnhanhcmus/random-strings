package com.random.strings;


import com.random.strings.services.WriteFilesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
public class WriteFileServiceTest {

    @Autowired
    private WriteFilesService writeFilesService;


    /*
     * case successful
     */
    @Test
    public void writeFile1() {
        String data = "I9ZO5nrlinCYziZAJRAwhhx4TEJRAHBctzut9BPhnlGlaSJN2lwjMiylKhFal8fIRuXwlIytGlYlZsr5BGR1e61hqAx1QDqmJpAr";
        boolean success = writeFilesService.write(data);
        assertTrue("Write file successful ",  success);

    }

}
