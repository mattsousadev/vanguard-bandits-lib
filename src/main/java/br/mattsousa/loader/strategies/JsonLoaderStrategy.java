package br.mattsousa.loader.strategies;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonLoaderStrategy<T> implements LoaderStrategy<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<T> load(String filePath, Class<T> clazz) throws IOException {
        
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}