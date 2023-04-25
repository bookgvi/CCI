package TMP;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeCollections {
    public <T> Collection<T> mergeTwoCollections(Collection<T> firstCollection, Collection<T> secondCollection) {
        if (firstCollection == secondCollection || secondCollection == null) {
            return firstCollection != null ? firstCollection : Collections.emptySet();
        } else if (firstCollection == null) {
            return secondCollection;
        }
        return Stream.concat(firstCollection.stream(), secondCollection.stream()).collect(Collectors.toSet());
    }

    @SafeVarargs
    public static <T> Collection<T> mergeCollections(Collection<T>... collections) {
        return Arrays.stream(collections)
                .filter(Objects::nonNull)
                .map(Collection::stream)
                .reduce(Stream.of(), Stream::concat)
                .collect(Collectors.toSet());
    }

    private static <T> Stream<T> mergeTwoStream(Stream<T> tStream, Stream<T> tStream1) {
        if (tStream == tStream1 || tStream1 == null) {
            return tStream != null ? tStream : Stream.of();
        } else if (tStream == null) {
            return tStream1;
        }
        return Stream.concat(tStream, tStream1);
    }
}
