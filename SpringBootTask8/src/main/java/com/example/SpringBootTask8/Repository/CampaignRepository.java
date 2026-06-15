package com.example.SpringBootTask8.Repository;

import com.example.SpringBootTask8.Entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CampaignRepository {

    public interface campaignRepository extends JpaRepository<Campaign,Long>{

    }
}
