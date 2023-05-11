package com.greedy.moaware.work.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.moaware.work.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Integer>{
	
	@EntityGraph(attributePaths= {"employee"})
	Page<Work> findAll(Pageable pageable);
	
}
