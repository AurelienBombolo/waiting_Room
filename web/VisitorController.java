package hassan.essadik.waitingroom.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import hassan.essadik.waitingroom.entities.Visitor;
import hassan.essadik.waitingroom.services.VisitorService;

//MVC
//Model: les données affichés par la vue

@Controller
@RequestMapping(path = "/visitors")
public class VisitorController {
	@Autowired
	VisitorService visitorService;

	@GetMapping("/")
	public String getAll(Model model,
						@RequestParam(name = "page", defaultValue = "0") int page,
						@RequestParam(name = "size", defaultValue = "5") int size,
						@RequestParam(name = "fname", defaultValue = "") String fname,
						@RequestParam(name = "lname", defaultValue = "") String lname){
		
		Page<Visitor> visitorsPage = visitorService.getPageByFnameAndLname(fname, lname, page, size);
		model.addAttribute("visitors", visitorsPage);
		model.addAttribute("lname", lname);
		model.addAttribute("fname", fname);
		model.addAttribute("pages", new int[visitorsPage.getTotalPages()]);
		return "visitors";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public String visitors(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
//			@RequestParam(name = "size", defaultValue = "3") int size,
//			@RequestParam(name = "fname", defaultValue = "") String fname,
//			@RequestParam(name = "lname", defaultValue = "") String lname) {
//		Page<Visitor> pageVisitors = visitorService.getPageByFnameAndLname(fname, lname, page, size);
//		model.addAttribute("visitors", pageVisitors.getContent());
//		model.addAttribute("pages", new int[pageVisitors.getTotalPages()]);
//		model.addAttribute("lname", lname);
//		model.addAttribute("fname", fname);
//		return "visitors";
//	}
	
	@GetMapping("/delete")
	public String delete(long id) {
		visitorService.delete(id);
		return "redirect:/visitors/";
	}
	
	@GetMapping("/new/")
	public String newVisitor(Model model) {
		model.addAttribute("visitor", new Visitor());
		return "new-visitor";
	}
	
	@GetMapping("/edit/")
	public String editVisitor(long id,  Model model) {
		Visitor visitor = visitorService.getById(id);

		model.addAttribute("visitor", visitor);
		return "new-visitor";
	}
	
	@PostMapping("/save")
	public String saveVisitor(@Valid Visitor visitor, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "new-visitor"; 
		}
		
		Visitor savedVisitor = visitorService.save(visitor);
		model.addAttribute("visitor", savedVisitor);
		return "confirm-save-visitor";
	}
}
