package com.vrpi.edtech.service;

import com.vrpi.edtech.entity.InstructorEntity;
import com.vrpi.edtech.repo.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class InstructorService {


    @Autowired
    private InstructorRepository instructorRepository;

    public InstructorEntity addInstructor(InstructorEntity instructor) {
        Optional<InstructorEntity> existingInstructor = instructorRepository.findByEmail(instructor.getEmail());
        if (existingInstructor.isPresent()) {
            throw new InstructorAlreadyExistsException("Instructor with email " + instructor.getEmail() + " already exists");
        } else {
            instructor.setJoinedDate(new Date());
            return instructorRepository.save(instructor);
        }
    }

    // Other methods...

    // Custom exception class
    public static class InstructorAlreadyExistsException extends RuntimeException {
        public InstructorAlreadyExistsException(String message) {
            super(message);
        }
    }
    public InstructorEntity updateInstructor(Long id, InstructorEntity updatedInstructor) {
        Optional<InstructorEntity> existingInstructorOptional = instructorRepository.findById(id);
        if (existingInstructorOptional.isPresent()) {
            InstructorEntity existingInstructor = existingInstructorOptional.get();
            // Update existing instructor with new details
            existingInstructor.setFirstName(updatedInstructor.getFirstName());
            existingInstructor.setLastName(updatedInstructor.getLastName());
            existingInstructor.setEmail(updatedInstructor.getEmail());
            existingInstructor.setPassword(updatedInstructor.getPassword());
            existingInstructor.setPhone(updatedInstructor.getPhone());
            existingInstructor.setAddress(updatedInstructor.getAddress());
            existingInstructor.setUpdatedDate(new Date());
            return instructorRepository.save(existingInstructor);
        } else {
            // Handle case where instructor with given ID is not found
            throw new InstructorNotFoundException("Instructor with ID " + id + " not found");
        }
    }
    // Custom exception class for instructor not found
    public static class InstructorNotFoundException extends RuntimeException {
        public InstructorNotFoundException(String message) {
            super(message);
        }
    }
    public void deleteInstructor(Long id) {
        Optional<InstructorEntity> instructorOptional = instructorRepository.findById(id);
        if (instructorOptional.isPresent()) {
            instructorRepository.delete(instructorOptional.get());
        } else {
            throw new InstructorNotFoundException("Instructor with ID " + id + " not found");
        }
    }


}
