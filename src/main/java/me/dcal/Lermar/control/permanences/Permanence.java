package me.dcal.Lermar.control.permanences;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Permanence {
    static String montantePath = "src/main/resources/permanences";
    List<Path> paths;
    public Permanence() throws IOException {

		Path path = Paths.get(montantePath);
        paths = listPermanencesFiles(path);
        paths.forEach(x -> System.out.println(x));
    }

    public List<Path> getPermanencesPath(){
        return this.paths;
    }
   


    public static List<Path> listPermanencesFiles(Path path) throws IOException {

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;

    }

}