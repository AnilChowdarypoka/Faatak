package com.Faatak.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Faatak.model.VisitorModel;
public interface VisitorDataDao extends JpaRepository <VisitorModel , Integer> {
	
	}
