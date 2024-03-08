package com.vrpi.edtech.controller;
import com.vrpi.edtech.entity.EducationDetails;
import com.vrpi.edtech.service.EducationDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/education-details")
public class EducationDetailsController {

    private final EducationDetailsService educationDetailsService;

    public EducationDetailsController(EducationDetailsService educationDetailsService) {
        this.educationDetailsService = educationDetailsService;
    }

    @GetMapping("/{id}")
    public EducationDetails getEducationDetailsById(Long id) {
        return educationDetailsService.getEducationDetails(id);
    }

    @PostMapping("/create-education-details")
    public String createEducationDetails(EducationDetails educationDetails){
        return educationDetailsService.createEducationDetails(educationDetails);
    }

    @PutMapping("/update-education-details/{id}")
    public String updateEducationDetails(@RequestParam Long id, @RequestBody EducationDetails educationDetails) {
        return educationDetailsService.updateEducationDetails(id, educationDetails);
    }
}
