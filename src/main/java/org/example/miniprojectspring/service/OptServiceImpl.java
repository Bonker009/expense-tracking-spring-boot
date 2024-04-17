package org.example.miniprojectspring.service;

import lombok.Data;
import org.example.miniprojectspring.model.entity.OptsDTO;
import org.example.miniprojectspring.repository.OneTimePasswordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data

public class OptServiceImpl implements OptService {
    private String verificationResult;
    private final OneTimePasswordRepository oneTimePasswordRepository;

    public OptServiceImpl(OneTimePasswordRepository oneTimePasswordRepository) {
        this.oneTimePasswordRepository = oneTimePasswordRepository;
    }

    @Override
    public Optional<OptsDTO> findById(Integer id) {
        return oneTimePasswordRepository.findById(id);
    }

    @Override
    public void save(OptsDTO optsDTO) {
        oneTimePasswordRepository.createNewOpt(optsDTO);
    }

    @Override
    public Optional<OptsDTO> findByCode(String code) {
        return Optional.ofNullable(oneTimePasswordRepository.findByCode(code));
    }

    @Override
    public void uploadOpt(String optCode) {
        oneTimePasswordRepository.save(optCode);
    }

}
