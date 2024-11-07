package br.mattsousa.loader.strategies;

import java.io.IOException;
import java.util.List;

public interface LoaderStrategy<T> {
    List<T> load(String filePath, Class<T> clazz) throws IOException;
}
