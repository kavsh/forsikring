package no.forsikring.fagsystem.model;

import no.forsikring.fagsystem.enums.AvtaleStatus;
import no.forsikring.fagsystem.enums.ForsikringKategori;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AvtaleModel {
    @NotNull(message="kategori information kan ikke være tomt.")
    private ForsikringKategori kategori;
    private String kundeNummer;
    private Integer avtaleNummer;
    @NotNull(message="opprettetDato information kan ikke være tomt.")
    private LocalDate opprettetDato;
    @NotNull(message="utloopsDato information kan ikke være tomt.")
    private LocalDate utloopsDato;
    private AvtaleStatus avtaleStatus;
    private List<AvtaleModel> avtaler = new ArrayList<>();

    private AvtaleModel() {}

    public static class Builder {
        private ForsikringKategori kategori;
        private String kundeNummer;
        private Optional<Integer> avtaleNummer;
        private LocalDate opprettetDato;
        private LocalDate utloopsDato;
        private AvtaleStatus avtaleStatus;
        private List<AvtaleModel> avtaler;

        public Builder() {}

        public Builder withKategori(ForsikringKategori kategori) {
            this.kategori = kategori;
            return this;
        }

        public Builder withKundeNummer(String kundeNummer) {
            this.kundeNummer = kundeNummer;
            return this;
        }

        public Builder withAvtaleNummer(Optional<Integer> avtaleNummer) {
            this.avtaleNummer = Optional.ofNullable(avtaleNummer.orElse(1000));
            return this;
        }

        public Builder withOpprettetDato(LocalDate opprettetDato) {
            this.opprettetDato = opprettetDato;
            return this;
        }

        public Builder withUtloopsDato(LocalDate utloopsDato) {
            this.utloopsDato = utloopsDato;
            return this;
        }

        public Builder withAvtaleStatus(AvtaleStatus avtaleStatus) {
            this.avtaleStatus = avtaleStatus;
            return this;
        }

        public Builder withAvtaler(List<AvtaleModel> avtaler) {
            this.avtaler = avtaler;
            return this;
        }

        public AvtaleModel build() {
            AvtaleModel avtaleModel = new AvtaleModel();
            avtaleModel.kategori = this.kategori;
            avtaleModel.kundeNummer = this.kundeNummer;
            avtaleModel.avtaleNummer = this.avtaleNummer.orElse(1000);
            avtaleModel.avtaleStatus = this.avtaleStatus;
            avtaleModel.utloopsDato = this.utloopsDato;
            avtaleModel.opprettetDato = this.opprettetDato;
            avtaleModel.avtaler = avtaler;
            return avtaleModel;
        }
    }

    public ForsikringKategori getKategori() {
        return kategori;
    }

    public String getKundeNummer() {
        return kundeNummer;
    }

    public Integer getAvtaleNummer() {
        return avtaleNummer;
    }

    public LocalDate getOpprettetDato() {
        return opprettetDato;
    }

    public LocalDate getUtloopsDato() {
        return utloopsDato;
    }

    public AvtaleStatus getAvtaleStatus() {
        return avtaleStatus;
    }

    public void setAvtaleStatus(AvtaleStatus avtaleStatus) {
        this.avtaleStatus = avtaleStatus;
    }
}
