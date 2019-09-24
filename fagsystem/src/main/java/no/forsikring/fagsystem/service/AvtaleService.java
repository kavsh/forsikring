package no.forsikring.fagsystem.service;

import no.forsikring.fagsystem.model.AvtaleModel;
import no.forsikring.fagsystem.model.AvtaleRequestModel;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class AvtaleService {

    private final static Logger LOGGER = getLogger(AvtaleService.class);

    private KundeService kundeService;
    private BrevService brevService;


    public AvtaleModel opprettAvtale(final AvtaleRequestModel avtaleRequest) {
        AvtaleModel avtaleModel = avtaleRequest.getAvtale();
        return new AvtaleModel.Builder()
                .withKategori(avtaleModel.getKategori())
                .withOpprettetDato(avtaleModel.getOpprettetDato())
                .withUtloopsDato(avtaleModel.getUtloopsDato())
                .withAvtaleNummer(Optional.ofNullable(avtaleModel.getAvtaleNummer())).build();

       /* return new AvtaleModel(avtaleModel.getKundeNummer(),
                avtaleModel.getForsikringsKategori(),
                avtaleModel.getOpprettet(),
                avtaleModel.getUtloopeDato(),
                avtaleModel.getAvtaleNummer() != null ? avtaleModel.getAvtaleNummer() : Integer.valueOf(1000));
*/
    }
}
