package com.fmss.service;

import com.fmss.model.Publisher;
import com.fmss.repository.PublisherRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PublisherService {

    private PublisherRepository publisherRepository = new PublisherRepository();

    public void savePublisher(String name, LocalDate createDate) {

        Publisher publisher = new Publisher(name, createDate);
        publisherRepository.save(publisher);

    }

    public List<Publisher> getAllPublishers() { return publisherRepository.getAll(); }

    public Optional<Publisher> getByName(String publisherName) {
        return getAllPublishers()
                .stream()
                .filter(publisher -> publisher.getName().equals(publisherName))
                .findFirst();
    }
}
