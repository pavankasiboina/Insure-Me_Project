package com.pavan.InsureMe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface policyRepository extends JpaRepository<policy, Long> {

}
