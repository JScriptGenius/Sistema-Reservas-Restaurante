package com.jarellano.mesa.persistence;

import com.jarellano.mesa.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMesaRepository extends JpaRepository<Mesa, Long> {

    @Modifying
    @Query("UPDATE Mesa m SET m.estado = :estado WHERE m.idMesa = :idmesa")
    void actualizarEstadoMesa(@Param("estado") String estado, @Param("idmesa") Long idMesa);
}
