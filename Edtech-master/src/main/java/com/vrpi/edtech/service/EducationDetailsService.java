package com.vrpi.edtech.service;

import com.vrpi.edtech.entity.EducationDetails;
import com.vrpi.edtech.repo.EducationDetailsRepo;
import org.springframework.stereotype.Service;

@Service
public class EducationDetailsService {

    private final EducationDetailsRepo educationDetailsRepo;

    public EducationDetailsService(EducationDetailsRepo educationDetailsRepo) {
        this.educationDetailsRepo = educationDetailsRepo;
    }

    public String updateEducationDetails(Long id, EducationDetails educationDetails) {
        EducationDetails educationDetail = educationDetailsRepo.findById(id).orElse(null);
        assert educationDetail != null;
        educationDetail.setEducationLevel(educationDetails.getEducationLevel());
        educationDetail.setInstitutionName(educationDetails.getInstitutionName());
        educationDetail.setDegree(educationDetails.getDegree());
        educationDetail.setInstituteLocation(educationDetails.getInstituteLocation());
        educationDetail.setStartDate(educationDetails.getStartDate());
        educationDetail.setEndDate(educationDetails.getEndDate());
        educationDetail.setGrade(educationDetails.getGrade());
        educationDetailsRepo.save(educationDetail);
        return "Education Details Updated";
    }

    public String createEducationDetails(EducationDetails educationDetails) {
        educationDetailsRepo.save(educationDetails);
        return "Education Details Created";
    }

    public EducationDetails getEducationDetails(Long id) {
        return educationDetailsRepo.findById(id).orElse(null);
    }
}
