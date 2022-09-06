package me.dcal.Lermar.control.permanences;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Permanence {
    List<Path> paths;
    String name;
    List<String> values;

    public Permanence(String name, List<String> values) throws IOException {
        this.name = name;
        this.values = values;
    }

    public List<String> getValue(){
        return this.values;
    }

    public String getName(){
        return this.name;
    }

    public List<Path> getPermanencesPath(){
        return this.paths;
    }
}