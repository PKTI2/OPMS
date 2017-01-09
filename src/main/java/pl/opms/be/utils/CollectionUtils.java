package pl.opms.be.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Piotr Borczyk on 09.01.2017.
 */
public class CollectionUtils {
    private CollectionUtils() {

    }

    public static  <T> Collection<T> toCollection(Iterable<T> source) {
        List<T> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }
}
