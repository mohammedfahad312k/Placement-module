package com.tns.certificate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.certificate.entities.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Integer>
{

}
