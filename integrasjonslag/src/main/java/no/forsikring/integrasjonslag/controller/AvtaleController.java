package no.forsikring.integrasjonslag.controller;

import no.forsikring.fagsystem.model.AvtaleRequestModel;
import no.forsikring.fagsystem.model.AvtaleResponseModel;
import no.forsikring.fagsystem.service.FagsystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value="fagsystem/api/v1/avtale/ny", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AvtaleController {
    private final FagsystemService fagsystemService;

    @Autowired
    public AvtaleController(final FagsystemService fagsystemService) {
        this.fagsystemService = fagsystemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvtaleResponseModel> opprettAvtale(@Valid @RequestBody final AvtaleRequestModel avtaleRequest) throws Exception {
        return new ResponseEntity<>(this.fagsystemService.opprettAvtale(avtaleRequest), OK);
    }
}
