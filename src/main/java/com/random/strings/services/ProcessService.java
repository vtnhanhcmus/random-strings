package com.random.strings.services;

import com.random.strings.controllers.dto.RandomDto;

import java.io.IOException;

public interface ProcessService extends WriteFilesService, RandomService {
    void process(RandomDto randomDto) throws IOException;
}
