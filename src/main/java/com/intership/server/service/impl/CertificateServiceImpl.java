package com.intership.server.service.impl;

import com.intership.server.service.CertificateService;
import com.intership.server.domain.Certificate;
import com.intership.server.repository.CertificateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Certificate}.
 */
@Service
@Transactional
public class CertificateServiceImpl implements CertificateService {

    private final Logger log = LoggerFactory.getLogger(CertificateServiceImpl.class);

    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    /**
     * Save a certificate.
     *
     * @param certificate the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Certificate save(Certificate certificate) {
        log.debug("Request to save Certificate : {}", certificate);
        return certificateRepository.save(certificate);
    }

    /**
     * Get all the certificates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Certificate> findAll(Pageable pageable) {
        log.debug("Request to get all Certificates");
        return certificateRepository.findAll(pageable);
    }


    /**
     * Get one certificate by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Certificate> findOne(Long id) {
        log.debug("Request to get Certificate : {}", id);
        return certificateRepository.findById(id);
    }

    /**
     * Delete the certificate by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Certificate : {}", id);
        certificateRepository.deleteById(id);
    }

    /**
     * 通过学生 ID 查找证书
     * @param stuId
     * @return
     */
    @Override
    public List<Certificate> findByStuId(Long stuId) {
        return certificateRepository.findByStuIdId(stuId);
    }
}
