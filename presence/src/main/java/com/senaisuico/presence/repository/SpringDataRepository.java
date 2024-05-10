package com.senaisuico.presence.repository;

import org.springframework.data.repository.CrudRepository;
import com.senaisuico.presence.model.Presence;

public interface SpringDataRepository extends CrudRepository<Presence, Integer> {

}