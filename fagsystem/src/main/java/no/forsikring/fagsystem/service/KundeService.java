package no.forsikring.fagsystem.service;

import no.forsikring.fagsystem.model.AvtaleRequestModel;
import no.forsikring.fagsystem.model.KundeModel;
import org.springframework.stereotype.Service;

@Service
public class KundeService {

    public KundeModel opprettKunde(AvtaleRequestModel avtaleRequest) {
        KundeModel kunde;
        if(null == (kunde = getKunde(avtaleRequest))) {
            kunde = new KundeModel.Builder()
            .withFornavn(avtaleRequest.getKunde().getFornavn())
            .withEtternavn(avtaleRequest.getKunde().getEtternavn())
            .withFodselsDato(avtaleRequest.getKunde().getFodselsDato())
            .withAvtaler(avtaleRequest.getKunde().getAvtaler())
            .withForsikringskategori(avtaleRequest.getKunde().getForsikringskategori())
            .withKundeNummer(avtaleRequest.getKunde().getKundeNummer().isEmpty() ? "1" : avtaleRequest.getKunde().getKundeNummer())
            .withEmail(avtaleRequest.getKunde().getEmail())
            .withTelNummer(avtaleRequest.getKunde().getTelNummer()).build();
        }
        return kunde;
    }

    public KundeModel getKunde(AvtaleRequestModel avtaleRequestModel) {
        // check om kunden eksisterer isf returnere kunden.
        return avtaleRequestModel.getKunde();
    }

}
