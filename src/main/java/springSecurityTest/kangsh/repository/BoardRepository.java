package springSecurityTest.kangsh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springSecurityTest.kangsh.domain.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
