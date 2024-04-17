package org.example.miniprojectspring.service;

import org.example.miniprojectspring.model.entity.OptsDTO;

import java.util.Optional;

public interface OptService {
    Optional<OptsDTO> findById(Integer id);

    void save(OptsDTO optsDTO);
    Optional<OptsDTO> findByCode(String code);
    void uploadOpt(String optCode);
}
