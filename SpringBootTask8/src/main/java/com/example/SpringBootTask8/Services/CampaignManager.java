package com.example.SpringBootTask8.Services;

import com.example.SpringBootTask8.Entities.Campaign;
import com.example.SpringBootTask8.Repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignManager {

    @Autowired
    private CampaignRepository campaignRepository;
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
    public Optional<Campaign> getCampaignById(Long id) {
        return campaignRepository.findById(id);
    }
    public Campaign addCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}




