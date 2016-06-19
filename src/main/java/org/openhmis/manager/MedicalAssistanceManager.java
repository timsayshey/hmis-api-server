package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientNoAssistanceReason;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpMedicalAssistanceDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpMedicalAssistance;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.MedicalAssistanceDTO;
import org.openhmis.dto.search.MedicalAssistanceSearchDTO;

public class MedicalAssistanceManager {
	private TmpMedicalAssistanceDAO tmpMedicalAssistanceDAO;

	public MedicalAssistanceManager() {
		this.tmpMedicalAssistanceDAO = new TmpMedicalAssistanceDAO();
	}

	public MedicalAssistanceManager(TmpMedicalAssistanceDAO tmpMedicalAssistanceDAO) {
		this.tmpMedicalAssistanceDAO = tmpMedicalAssistanceDAO;
	}

	public MedicalAssistanceDTO getMedicalAssistanceById(String medicalAssistanceId) {
		MedicalAssistanceDTO medicalAssistanceDTO = MedicalAssistanceManager.generateMedicalAssistanceDTO(tmpMedicalAssistanceDAO.getTmpMedicalAssistanceById(Integer.parseInt(medicalAssistanceId)));
		return medicalAssistanceDTO;
	}

	public List<MedicalAssistanceDTO> getMedicalAssistances(MedicalAssistanceSearchDTO searchDTO) {
		List<MedicalAssistanceDTO> medicalAssistanceDTOs = new ArrayList<MedicalAssistanceDTO>();

		// Collect the medicalAssistances
		List<TmpMedicalAssistance> tmpMedicalAssistances = tmpMedicalAssistanceDAO.getTmpMedicalAssistances(searchDTO);

		// For each medicalAssistance, collect and map the data
		for (Iterator<TmpMedicalAssistance> iterator = tmpMedicalAssistances.iterator(); iterator.hasNext();) {
			TmpMedicalAssistance tmpMedicalAssistance = iterator.next();
			MedicalAssistanceDTO medicalAssistanceDTO = MedicalAssistanceManager.generateMedicalAssistanceDTO(tmpMedicalAssistance);
			medicalAssistanceDTOs.add(medicalAssistanceDTO);
		}
		return medicalAssistanceDTOs;

	}

	public MedicalAssistanceDTO addMedicalAssistance(MedicalAssistanceDTO inputDTO) {
		// Generate a PathClient from the input
		TmpMedicalAssistance tmpMedicalAssistance = MedicalAssistanceManager.generateTmpMedicalAssistance(inputDTO);
		
		// Set Export fields
		tmpMedicalAssistance.setDateCreated(new Date());
		tmpMedicalAssistance.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpMedicalAssistanceDAO.save(tmpMedicalAssistance);
		inputDTO.setMedicalAssistanceId(tmpMedicalAssistance.getMedicalAssistanceId().toString());
		
		// Return the resulting VO
		return MedicalAssistanceManager.generateMedicalAssistanceDTO(tmpMedicalAssistance);
	}
	
	public MedicalAssistanceDTO updateMedicalAssistance(MedicalAssistanceDTO inputDTO) {
		// Generate a MedicalAssistance from the input
		TmpMedicalAssistance tmpMedicalAssistance = MedicalAssistanceManager.generateTmpMedicalAssistance(inputDTO);
		tmpMedicalAssistance.setMedicalAssistanceId(Integer.parseInt(inputDTO.getMedicalAssistanceId()));
		tmpMedicalAssistance.setDateUpdated(new Date());
		
		// Update the object
		tmpMedicalAssistanceDAO.update(tmpMedicalAssistance);
		
		// Return the resulting VO
		return MedicalAssistanceManager.generateMedicalAssistanceDTO(tmpMedicalAssistance);

	}
	
	public boolean deleteMedicalAssistance(String medicalAssistanceId) {
		TmpMedicalAssistance tmpMedicalAssistance = tmpMedicalAssistanceDAO.getTmpMedicalAssistanceById(Integer.parseInt(medicalAssistanceId));
		tmpMedicalAssistanceDAO.delete(tmpMedicalAssistance);
		return true;
	}
	
}
