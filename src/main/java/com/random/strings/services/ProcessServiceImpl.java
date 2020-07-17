package com.random.strings.services;

import com.random.strings.controllers.dto.RandomDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@Service
public class ProcessServiceImpl implements ProcessService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(RandomDto randomDto){

        StringBuilder data = new StringBuilder();
        for (int i=0; i< randomDto.getRowSize(); i++){
            data.append(generatedString(randomDto.getLengStr()))
                    .append(System.getProperty("line.separator"));
        }
        write(data.toString());
    }

    @Override
    public void write(String data) {

        try(FileOutputStream outputStream = new FileOutputStream( "uploads/" +System.currentTimeMillis()+".txt")){
            byte[] strToBytes = data.getBytes();
            outputStream.write(strToBytes);
        }catch (IOException ex){
            logger.error(ex.getLocalizedMessage());
        }

    }

    @Override
    public StringBuilder generatedString(int length) {
        Random random = new Random();
        int leftLimit = 48;
        int rightLimit = 122;

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
    }
}
