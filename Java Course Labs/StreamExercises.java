import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;


public class StreamExercises {
    public static int countLines(Path path, int thres) throws IOException {
        return (int)Files.lines(path).filter(aLine -> aLine.length() >= thres).count();

    }

    public static List<String> collectWords(Path path) throws IOException {
        return Files.lines(path).filter(aLine -> aLine.length() > 0).map(aLine -> aLine.toLowerCase()).flatMap(aLine -> Arrays.asList(aLine.split("[^a-z]+")).stream()).filter(aWord ->aWord.length() > 0).sorted().distinct().collect(Collectors.toList());
    }
}
