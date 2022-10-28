package hassan.essadik.waitingroom.services;


import java.awt.print.Pageable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import hassan.essadik.waitingroom.entities.Visitor;
import hassan.essadik.waitingroom.repositories.VisitorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class VisitorService {
	VisitorRepository visitorRepository;
	
	public Visitor getById(long id) {
		return visitorRepository.findById(id).orElse(null);
	}
	
	public List<Visitor> getAll(){
		return visitorRepository.findAll();
	}
	
	public Page<Visitor> getPage(int page, int size){
		return visitorRepository.findAll(PageRequest.of(page, size));
	}
	
	public Page<Visitor> getPageByFnameAndLname(String fname,String lname, int page, int size){
		return visitorRepository.findByFnameContainsAndLnameContains(fname, lname, PageRequest.of(page, size));
	}
	
	public Visitor save(Visitor visitor) {
		return visitorRepository.save(visitor);
	}
	
	public void delete(Visitor visitor) {
		visitorRepository.deleteById(visitor.getId());
	}
	
	public void delete(long id) {
		visitorRepository.deleteById(id);
	}
	
	
}
