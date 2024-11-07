package br.mattsousa.loader;

import java.io.IOException;
import java.util.List;

import br.mattsousa.loader.strategies.LoaderStrategy;

public class FileLoader<T> {
    private LoaderStrategy<T> loaderStrategy;

    public FileLoader(LoaderStrategy<T> loaderStrategy) {
        this.loaderStrategy = loaderStrategy;
    }

    public List<T> loadFile(String filePath, Class<T> clazz) throws IOException {
        return loaderStrategy.load(filePath, clazz);
    }
}