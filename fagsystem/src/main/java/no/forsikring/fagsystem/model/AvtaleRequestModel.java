package no.forsikring.fagsystem.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;

public class AvtaleRequestModel {
    @NotNull(message="Kunde information kan ikke være tomt.")
    private KundeModel kunde;

    private AvtaleModel avtale;

    public AvtaleRequestModel(){}

    public AvtaleRequestModel(AvtaleModel avtale, KundeModel kunde) {
        this.avtale = avtale;
        this.kunde = kunde;
    }

    public KundeModel getKunde() {
        return kunde;
    }

    public AvtaleModel getAvtale() {
        return avtale;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("avtale=", avtale)
                .append("kunde=", kunde).toString();
    }
}
