package com.fmss.repository;

import com.fmss.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepository {

    private static PublisherRepository instance;

    public static PublisherRepository getInstance() {
        if (instance == null) {
            instance = new PublisherRepository();
        }
        return instance;
    }

    private List<Publisher> publishers = new ArrayList<>();

    public void save(Publisher publisher) {
        publishers.add(publisher);
    }

    public List<Publisher> getAll() {
        return publishers;
    }
}
