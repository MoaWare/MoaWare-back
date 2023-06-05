package com.greedy.moaware.boardPost.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greedy.moaware.boardPost.entity.Board;
import com.greedy.moaware.boardPost.entity.BoardPost;

@Repository
public interface BoardRepository extends JpaRepository <Board, Long>{

	
	/* 게시 판 목록 조회 - 페이징, 조회 불가 게시물 제외(사용자) */
	/* 연관 관계가 지연 로딩으로 되어 있을 경우 엔티티를 하나 조회하고 다시 다른 엔티티에 대해서 여러번 조회를 별도로 하게 되는 
	 * N + 1 문제가 발생하게 된다. (성능 이슈) fetch 조인을 사용하게 되면 한 번에 조인해서 결과를 가져오게 된다.
	 * @EntityGraph는 Data JPA에서 fetch 조인은 어노테이션으로 사용할 수 있도록 만들어준 기능이다.*/
	
//	
//	@EntityGraph(attributePaths= {"boardPost"})
//	Page<Board> findByStatus(Pageable pageable, String status);
	
	
	/* JpaRepository에 이미 정의 되어 있는 findAll(Pageable pageable) 메소드 사용 가능하므로 별도 정의 필요 없음 */
	//@EntityGraph(attributePaths= {"boardPost"})
	
	/* 게시 판 목록 조회 (사용자용) */
	Page<Board> findByStatus(Pageable pageable, String string);
	
	/* 게시 판 목록 조회 (관리자용) */
	Page<Board> findAll(Pageable pageable);

	
}

	






