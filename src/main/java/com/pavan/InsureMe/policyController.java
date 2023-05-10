package com.pavan.InsureMe;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class policyController {
	
	@Autowired
	policyRepository policyRepo;
	
	@PostMapping("/policies")
	public ResponseEntity<policy> createPolicy(@RequestBody policy poli) {
		return new ResponseEntity<>(policyRepo.save(poli),HttpStatus.CREATED);
	}
	
	@GetMapping("/policies")
	public ResponseEntity<List<policy>> getpolicies(){
		return new ResponseEntity<>(policyRepo.findAll(),HttpStatus.OK);
		}
	
	@GetMapping("/policies/{id}")
	public ResponseEntity<policy> viewpolicy(@PathVariable long id){
		Optional<policy> polic = policyRepo.findById(id);
		if(polic.isPresent()) {
			return new ResponseEntity<>(polic.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/policies/{id}")
	public ResponseEntity<policy> updatepolicy(@PathVariable long id, @RequestBody policy pol){
		Optional<policy> polic = policyRepo.findById(id);
		if(polic.isPresent()) {
			polic.get().setPolicyName(pol.getPolicyName());
			polic.get().setPolicyNumber(pol.getPolicyNumber());
			polic.get().setPremiumAmount(pol.getPremiumAmount());
			polic.get().setCompanyName(pol.getCompanyName());
			polic.get().setSumAssured(pol.getSumAssured());
			polic.get().setTenure(pol.getTenure());
			polic.get().setId(pol.getId());
			return new ResponseEntity<>(policyRepo.save(polic.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/policies/{id}")
	public ResponseEntity<Void> deletepolicy(@PathVariable long id){
		Optional<policy> polic = policyRepo.findById(id);
		if(polic.isPresent()) {
			policyRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
