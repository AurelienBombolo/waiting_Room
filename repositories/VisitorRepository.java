package hassan.essadik.waitingroom.repositories;

import hassan.essadik.waitingroom.entities.Visitor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
	public Page<Visitor> findByFnameContainsAndLnameContains(String fname,String lname, Pageable pageable);
}
