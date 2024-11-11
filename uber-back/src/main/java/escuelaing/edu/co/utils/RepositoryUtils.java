package escuelaing.edu.co.utils;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class RepositoryUtils {

    public static String generateUniqueExternalId() {
        return UUID.randomUUID().toString();
    }

    public static <T> Long generateNewId(List<T> list, Function<T, Long> idExtractor) {
        return list.stream()
                .mapToLong(idExtractor::apply)
                .max()
                .orElse(0L) + 1;
    }
}
