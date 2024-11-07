package br.mattsousa.loader;

import br.mattsousa.loader.strategies.JsonLoaderStrategy;
import br.mattsousa.loader.strategies.XmlLoaderStrategy;

public class FileLoaderFactory {
    public static final <T> FileLoader<T> create(String type) {
        if (type.equalsIgnoreCase("json")) {
            return new FileLoader<T>(new JsonLoaderStrategy<T>());
        }else if (type.equalsIgnoreCase("xml")) {
            return new FileLoader<T>(new XmlLoaderStrategy<T>());
        }
        return null;
    }
}