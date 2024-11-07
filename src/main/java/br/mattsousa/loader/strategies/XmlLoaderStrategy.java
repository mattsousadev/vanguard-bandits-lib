package br.mattsousa.loader.strategies;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlLoaderStrategy<T> implements LoaderStrategy<T> {
    private XmlMapper xmlMapper = new XmlMapper();

    @Override
    public List<T> load(String filePath, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(new File(filePath),
                xmlMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}