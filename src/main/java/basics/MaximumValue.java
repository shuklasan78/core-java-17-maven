package basics;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class MaximumValue {

    public <K, V extends Comparable<V>> V maxUsingStreamAndLambda(Map<K, V> map) {
        Optional<Map.Entry<K, V>> maxEntry = map.entrySet()
                .stream()
                .max((Map.Entry<K, V> e1, Map.Entry<K, V> e2) -> e1.getValue()
                        .compareTo(e2.getValue())
                );

        return (V) maxEntry.get().getKey();
    }

    public <K, V extends Comparable<V>> V maxUsingCollectionsMaxAndLambda(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = Collections.max(map.entrySet(), (Map.Entry<K, V> e1, Map.Entry<K, V> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        return (V) maxEntry.getKey();
    }

    public <K, V extends Comparable<V>> V maxUsingStreamAndMethodReference(Map<K, V> map) {
        Optional<Map.Entry<K, V>> maxEntry = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return (V) maxEntry.get()
                .getKey();
    }

}
