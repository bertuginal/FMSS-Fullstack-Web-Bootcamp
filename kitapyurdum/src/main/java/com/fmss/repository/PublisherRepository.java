package com.fmss.repository;

import com.fmss.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepository {
    private List<Publisher> publishers = new ArrayList<>();

    public void save(Publisher publisher) {
        publishers.add(publisher);
    }

    public List<Publisher> getAll() {
        return publishers;
    }
}
