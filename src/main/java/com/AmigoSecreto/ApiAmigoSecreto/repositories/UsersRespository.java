package com.AmigoSecreto.ApiAmigoSecreto.repositories;


import com.AmigoSecreto.ApiAmigoSecreto.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsersRespository extends JpaRepository<Users, UUID> {

    @Query(value = """
    SELECT u.id
    from tb_users u
    where u.id not in(SELECT m.user_id FROM tb_matches m )
    order by random()
    limit 2
""", nativeQuery = true)
    List<UUID> findTwoRandomIds();

}
