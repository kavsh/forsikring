package no.forsikring.fagsystem.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class BrevService {

    private final static Logger LOGGER = getLogger(BrevService.class);

    public BrevService(){}

    public void sendBrev() throws Exception {
        LOGGER.info("Sending brev til kunde");
        throw new Exception("Feil ved sending av avtale til kunde");
    }
}
