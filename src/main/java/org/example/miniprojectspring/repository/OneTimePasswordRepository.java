package org.example.miniprojectspring.repository;

import org.apache.ibatis.annotations.Select;
import org.example.miniprojectspring.model.entity.OptsDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OneTimePasswordRepository {

    Optional<OptsDTO> findById(Integer id);

    void saveOpt(OptsDTO optsDTO);

    @Select("""
                    SELECT * FROM opts WHERE opt_code = #{code}
            """)
    String findByCode(String code);
}
