package com.aurea.trial.domain.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.aurea.trial.domain.RepositoryState;

import lombok.Data;

/**
 * Repository model.
 *
 * @author aSergeev
 *
 */
@Entity
@Data
public class Repository {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Repository state.
     */
    @Enumerated(EnumType.STRING)
    private RepositoryState state;

    /**
     * Repository name.
     */
    private String name;

    /**
     * URI to GitHub repository.
     */
    private String uri;

    /**
     * Repository registration date and time.
     */
    private Calendar registrationDate;

    /**
     * Start date and time of the last check of the repository.
     */
    private Calendar lastCheckStart;

    /**
     * Finish date and time of the last check of the repository.
     */
    private Calendar lastCheckFinish;

}
