package no.forsikring.fagsystem.model;

import no.forsikring.fagsystem.enums.AvtaleStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AvtaleResponseModel {

    @NotNull(message="Antale type kan ikke være tomt.")
    @Size(min=2, message="First name must not be less than 2 characters")
    private String avtaleNummer;

    @NotNull(message="")
    private AvtaleStatus avtaleStatus;

    @NotNull(message="Kunde information kan ikke være tomt.")
    @Size(min=10, message="Kunde information kan ikke være tomt")
    private KundeModel kunde;

    public AvtaleResponseModel(String avtaleNummer, AvtaleStatus avtaleStatus) {
        this.avtaleNummer = avtaleNummer;
        this.avtaleStatus = avtaleStatus;
    }

    public String getAvtaleNummer() {
        return avtaleNummer;
    }
    public AvtaleStatus getAvtaleStatus() {
        return avtaleStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("{")
                .append("avtalenummer=", avtaleNummer)
                .append("avtaleStatus=", avtaleStatus)
                .append("}").toString();
    }
}
