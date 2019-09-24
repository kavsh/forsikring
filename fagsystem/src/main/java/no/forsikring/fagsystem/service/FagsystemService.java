package no.forsikring.fagsystem.service;

import no.forsikring.fagsystem.enums.AvtaleStatus;
import no.forsikring.fagsystem.model.AvtaleModel;
import no.forsikring.fagsystem.model.AvtaleRequestModel;
import no.forsikring.fagsystem.model.AvtaleResponseModel;
import no.forsikring.fagsystem.model.KundeModel;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class FagsystemService {

    private final static Logger LOGGER = getLogger(AvtaleService.class);

    private KundeService kundeService;
    private BrevService brevService;
    private AvtaleService avtaleService;

    @Autowired
    public FagsystemService(final KundeService kundeService, final BrevService brevService, final AvtaleService avtaleService) {
        this.kundeService = kundeService;
        this.brevService = brevService;
        this.avtaleService = avtaleService;
    }

    public AvtaleResponseModel opprettAvtale(final AvtaleRequestModel avtaleRequest) {
        KundeModel kunde = kundeService.opprettKunde(avtaleRequest);
        AvtaleModel avtale = avtaleService.opprettAvtale(avtaleRequest);
        try {
            brevService.sendBrev();
        } catch (Exception e) {
            LOGGER.info("Kunne ikke sende brev!");
            avtale.setAvtaleStatus(AvtaleStatus.IKKESEND);
        }

        return new AvtaleResponseModel(avtale.getAvtaleNummer().toString(), avtale.getAvtaleStatus());
    }
}
