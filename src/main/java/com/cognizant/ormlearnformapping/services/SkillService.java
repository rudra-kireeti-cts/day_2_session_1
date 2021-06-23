package com.cognizant.ormlearnformapping.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearnformapping.model.Skill;
import com.cognizant.ormlearnformapping.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);
	
	//handson 4
	@Transactional
	public Skill get(int id) {

		LOGGER.info("GET by ID method in SkillService Start");

		return skillRepository.findById(id).get();
	}

	//handson 4
	@Transactional
	public void save(Skill skill) {

		LOGGER.info("save method in SkillService Start");

		skillRepository.save(skill);

		LOGGER.info("save method in SkillService End");

	}

}
