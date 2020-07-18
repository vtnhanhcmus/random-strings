package com.random.strings.services;

import com.random.strings.dtos.RandomDto;
import com.random.strings.exceptions.LengthLineException;
import com.random.strings.exceptions.LineOutBoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

@Service
public class ProcessServiceImpl implements ProcessService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Integer MAX_CHARACTER = 100;

    @Value("${random-string.path}")
    private String path;

    @Override
    public boolean process(RandomDto randomDto){

        if (Objects.isNull(randomDto)){
            return false;
        }

        if (randomDto.getRowSize() < 1 || randomDto.getRowSize() > 230){
            throw new LineOutBoundException("number line must from 1 to 230 rows");
        }

        StringBuilder data = new StringBuilder();
        for (int i=0; i< randomDto.getRowSize(); i++){
            data.append(generatedString())
                    .append(System.getProperty("line.separator"));
        }
        return write(data.toString());
    }

    @Override
    public boolean write(String data) {

        try(FileOutputStream outputStream = new FileOutputStream(String.format(path,System.currentTimeMillis()))){
            byte[] strToBytes = data.getBytes();
            outputStream.write(strToBytes);
        }catch (IOException ex){
            logger.error(ex.getLocalizedMessage());
            return false;
        }

        return true;

    }

    @Override
    public StringBuilder generatedString() {

        Random random = new Random();
        int leftLimit = 48;
        int rightLimit = 122;

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(MAX_CHARACTER)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
    }
}
