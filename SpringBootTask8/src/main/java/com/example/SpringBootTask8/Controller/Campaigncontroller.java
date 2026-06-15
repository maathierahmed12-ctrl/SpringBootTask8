package com.example.SpringBootTask8.Controller;

import com.example.SpringBootTask8.Entities.Campaign;
import com.example.SpringBootTask8.Services.CampaignManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class Campaigncontroller {


    @Autowired
    private CampaignManager campaignManager;
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignManager.getAllCampaigns();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
        return campaignManager.getCampaignById(id)
                .map(campaign -> ResponseEntity.ok().body(campaign))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody Campaign campaign) {
        Campaign savedCampaign = campaignManager.addCampaign(campaign);
        return new ResponseEntity<>(savedCampaign, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        campaignManager.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }
}
