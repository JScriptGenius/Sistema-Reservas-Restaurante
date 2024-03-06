package com.jarellano.mesa.persistence;

import com.jarellano.mesa.entity.Mesa;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IMesaRepository extends JpaRepository<Mesa, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Mesa m SET m.estado = :estado WHERE m.idMesa = :idmesa")
    void actualizarEstadoMesa(@Param("estado") String estado, @Param("idmesa") Long idMesa);
}
