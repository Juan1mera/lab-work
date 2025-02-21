package ru.bsuedu.cad.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.bsuedu.cad.lab.parser.CSVParser;
import ru.bsuedu.cad.lab.provider.ConcreteProductProvider;
import ru.bsuedu.cad.lab.reader.ResourceFileReader;
import ru.bsuedu.cad.lab.renderer.ConsoleTableRenderer;

@Configuration
@ComponentScan("ru.bsuedu.cad.lab")
public class AppConfig {

    @Bean
    public ResourceFileReader resourceFileReader() {
        return new ResourceFileReader("products.csv");
    }

    @Bean
    public CSVParser csvParser() {
        return new CSVParser();
    }

    @Bean
    public ConcreteProductProvider productProvider() {
        return new ConcreteProductProvider(resourceFileReader(), csvParser());
    }

    @Bean
    public ConsoleTableRenderer consoleTableRenderer() {
        return new ConsoleTableRenderer();
    }
}
