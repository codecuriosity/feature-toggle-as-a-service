package org.ft.datastore.services;

import lombok.AllArgsConstructor;
import org.ft.core.services.FeatureActivator;
import org.ft.core.services.FeatureDataStore;
import org.ft.datastore.repository.FeatureToggleRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class FeatureActivationJob implements FeatureActivator
{
    private final FeatureToggleRepository featureToggleRepository;

    private final RDBTenantStore rdbTenantStore;

    private final FeatureDataStore featureDataStore;

    @Scheduled(cron = "0 0 7,19 * * ?")
    public void activate ()
    {
        LocalDate localDate = LocalDate.now();
        List<String> featureList = featureToggleRepository.getFeatureIdsByActivationDate(
            localDate);
        featureDataStore.enableForAll(featureList);
    }
}
