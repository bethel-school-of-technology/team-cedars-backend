package com.cedarsbackend.video;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
	Video findById(Long id); 
}
