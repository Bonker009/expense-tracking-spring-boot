package org.example.miniprojectspring.service;

import org.example.miniprojectspring.model.entity.OptsDTO;

import java.util.Optional;

public interface OptService {
    public Optional<OptsDTO> findById(Integer id);

    void save(OptsDTO optsDTO);
    String findByCode(String code);
}
