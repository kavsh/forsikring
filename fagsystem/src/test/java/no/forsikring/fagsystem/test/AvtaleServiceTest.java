package no.forsikring.fagsystem.test;

import no.forsikring.fagsystem.enums.ForsikringKategori;
import no.forsikring.fagsystem.model.AvtaleModel;
import no.forsikring.fagsystem.model.AvtaleRequestModel;
import no.forsikring.fagsystem.model.KundeModel;
import no.forsikring.fagsystem.service.AvtaleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class AvtaleServiceTest {

    @InjectMocks
    AvtaleService avtaleService;

    @Test
    public void serviceTest() {
        AvtaleModel avtaleModel = new AvtaleModel.Builder().withKundeNummer("123456798")
                .withKategori(ForsikringKategori.BOLIG)
                .withOpprettetDato(LocalDate.of(2018,01,01))
                .withUtloopsDato(LocalDate.of(2020,01,01))
                .withAvtaleNummer(java.util.Optional.of(1)).build();

        KundeModel kundeModel = new KundeModel.Builder()
                .withKundeNummer("1")
                .withEmail("test@yahoo.se")
                .withEtternavn("etternavn")
                .withFornavn("navn")
                .withFodselsDato(LocalDate.of(1997,01,01))
                .withForsikringskategori(ForsikringKategori.HELSE)
                .withTelNummer("123456789").build();

        AvtaleRequestModel avtaleRequestModel = new AvtaleRequestModel(avtaleModel, kundeModel);

        System.out.println(avtaleModel.getAvtaleNummer());
        System.out.println(avtaleService.opprettAvtale(avtaleRequestModel).getAvtaleNummer());
        Assert.assertEquals(avtaleService.opprettAvtale(avtaleRequestModel).getAvtaleNummer(), avtaleModel.getAvtaleNummer());
    }

}
