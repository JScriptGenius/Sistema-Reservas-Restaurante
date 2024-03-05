package com.jarellano.mesa.persistence;

import com.jarellano.mesa.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
