package org.example.miniprojectspring.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.miniprojectspring.model.entity.OptsDTO;
import org.example.miniprojectspring.repository.OneTimePasswordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data

public class OptServiceImpl implements OptService {
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
        oneTimePasswordRepository.saveOpt(optsDTO);
    }

    @Override
    public String findByCode(String code) {
        return oneTimePasswordRepository.findByCode(code);
    }
}
