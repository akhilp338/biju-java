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
import net.guides.springboot2.springboot2jpacrudexample.model.PunchList;
import net.guides.springboot2.springboot2jpacrudexample.repository.PunchListRepository;

@RestController
@RequestMapping("/api/v1")
public class PunchListController {
	@Autowired
	private PunchListRepository punchlistRepository;

	@GetMapping("/punchlists")
	public List<PunchList> getAllpunchlists() {
		return punchlistRepository.findAll();
	}

	@GetMapping("/punchlists/{id}")
	public ResponseEntity<PunchList> getPunchListById(@PathVariable(value = "id") Long punchlistId)
			throws ResourceNotFoundException {
		PunchList punchlist = punchlistRepository.findById(punchlistId)
				.orElseThrow(() -> new ResourceNotFoundException("PunchList not found for this id :: " + punchlistId));
		return ResponseEntity.ok().body(punchlist);
	}

	@PostMapping("/punchlists")
	public PunchList createPunchList(@Valid @RequestBody PunchList punchlist) {
		return punchlistRepository.save(punchlist);
	}

	@PutMapping("/punchlists/{id}")
	public ResponseEntity<PunchList> updatePunchList(@PathVariable(value = "id") Long punchlistId,
			@Valid @RequestBody PunchList punchlistDetails) throws ResourceNotFoundException {
		PunchList punchlist = punchlistRepository.findById(punchlistId)
				.orElseThrow(() -> new ResourceNotFoundException("PunchList not found for this id :: " + punchlistId));

		punchlist.setActionBy(punchlistDetails.getActionBy());
		punchlist.setClosureEvidence(punchlistDetails.getClosureEvidence());
		punchlist.setComments(punchlistDetails.getComments());
		punchlist.setDateRaised(punchlistDetails.getDateRaised());
		punchlist.setDescription(punchlistDetails.getDescription());
		punchlist.setEquipment(punchlistDetails.getEquipment());
		punchlist.setOpenClose(punchlistDetails.getOpenClose());
		punchlist.setId(punchlistDetails.getId());
		punchlist.setPhotos(punchlistDetails.getPhotos());
		punchlist.setPlannedCompletionDate(punchlistDetails.getPlannedCompletionDate());
		punchlist.setProject(punchlistDetails.getProjectId());
		punchlist.setPunchPointCategory(punchlistDetails.getPunchPointCategory());
		punchlist.setPurchaseOrderNumber(punchlistDetails.getPurchaseOrderNumber());
		punchlist.setReportNumber(punchlistDetails.getReportNumber());
		punchlist.setSequenceNumber(punchlistDetails.getSequenceNumber());
		punchlist.setTagNumber(punchlistDetails.getTagNumber());

		final PunchList updatedPunchList = punchlistRepository.save(punchlist);
		return ResponseEntity.ok(updatedPunchList);
	}

	@DeleteMapping("/punchlists/{id}")
	public Map<String, Boolean> deletePunchList(@PathVariable(value = "id") Long punchlistId)
			throws ResourceNotFoundException {
		PunchList punchlist = punchlistRepository.findById(punchlistId)
				.orElseThrow(() -> new ResourceNotFoundException("PunchList not found for this id :: " + punchlistId));

		punchlistRepository.delete(punchlist);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
