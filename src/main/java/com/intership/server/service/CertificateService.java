package com.intership.server.service;

import com.intership.server.domain.Certificate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Certificate}.
 */
public interface CertificateService {

    /**
     * Save a certificate.
     *
     * @param certificate the entity to save.
     * @return the persisted entity.
     */
    Certificate save(Certificate certificate);

    /**
     * Get all the certificates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Certificate> findAll(Pageable pageable);


    /**
     * Get the "id" certificate.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Certificate> findOne(Long id);

    /**
     * Delete the "id" certificate.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * 通过学生 ID 查找证书
     * @param stuId
     * @return
     */
    List<Certificate> findByStuId(Long stuId);
}
