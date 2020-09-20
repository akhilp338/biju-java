package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Project;
import net.guides.springboot2.springboot2jpacrudexample.model.Project;
import net.guides.springboot2.springboot2jpacrudexample.repository.ProjectRepository;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;

	@GetMapping("/project")
	public List<Project> getAllproject() {
		return projectRepository.findAll();
	}

	@GetMapping("/project/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") Long projectId)
			throws ResourceNotFoundException {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("project not found for this id :: " + projectId));
		return ResponseEntity.ok().body(project);
	}

	@PostMapping("/project")
	public Project createProject(@Valid @RequestBody Project project) {
		return projectRepository.save(project);
	}

	@PutMapping("/project/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long projectId,
			@Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));
        project.setClient(projectDetails.getClient());
        project.setEndUser(projectDetails.getEndUser());
        project.setProjectName(projectDetails.getProjectName());
        project.setPurchaseOrderNumber(projectDetails.getPurchaseOrderNumber());
        project.setSupplier(projectDetails.getSupplier()); 
        project.setSupplierAddress(projectDetails.getSupplierAddress());
        project.setProjectId(projectDetails.getProjectId());
		final Project updatedProject = projectRepository.save(project);
		return ResponseEntity.ok(updatedProject);
	}

	@DeleteMapping("/project/{id}")
	public Map<String, Boolean> deleteProject(@PathVariable(value = "id") Long projectId)
			throws ResourceNotFoundException {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

		projectRepository.delete(project);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
