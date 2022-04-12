package com.example.picture.service.Collection;

import java.util.List;

public interface CollectionServices<T> {
    List<Integer> getCollectionList(T o);

    void collectPicture(T o);

    void uncollectPicture(T o);
}
