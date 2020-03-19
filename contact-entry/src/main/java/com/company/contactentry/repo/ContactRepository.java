package com.company.contactentry.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.contactentry.dto.ContactDTO;

@Repository
public interface ContactRepository extends JpaRepository<ContactDTO, Long> {
}
