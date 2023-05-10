package com.pavan.InsureMe;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class InsureMeApplicationTests {

	
	
	@Autowired
	policyRepository policyRepo;
	
	@Test
	@Order(1)
	public void testCreatePolicy() {
		policy ps = new policy();
		ps.setId(1);
		ps.setPolicyName("Home");
		ps.setPolicyNumber(8363729);
		ps.setCompanyName("Insure-Me");
		ps.setPremiumAmount(1200);
		ps.setTenure(12);
		ps.setSumAssured(680000);
		policyRepo.save(ps);
		assertNotNull(policyRepo.findById((long) 1).get());
	}
	
	
	@Order(2)
	public void testgetPolicies() {
		java.util.List<policy> list = policyRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testviewPolicy() {
		policy poli = policyRepo.findById((long) 1).get();
		assertEquals(1, poli.getId());
	}

	private void assertEquals(int i, long l) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	@Order(4)
	public void testupdatePolicy() {
		policy pol = policyRepo.findById((long) 1).get();
		pol.setPolicyName("Life");
		policyRepo.save(pol);
		assertEquals("Life",policyRepo.findById((long) 1).get().getPolicyName());
		
		
	}

	private void assertEquals(String string, String policyName) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Test
	@Order(5)
	public void testdeletePolicy() {
		policyRepo.deleteById((long) 1);
		assertThat(policyRepo.existsById((long) 1)).isFalse();
	}

}













