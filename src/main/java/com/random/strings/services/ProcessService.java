package com.random.strings.services;

import com.random.strings.dtos.RandomDto;

import java.io.IOException;

public interface ProcessService extends WriteFilesService, RandomService {
    boolean process(RandomDto randomDto);
}
