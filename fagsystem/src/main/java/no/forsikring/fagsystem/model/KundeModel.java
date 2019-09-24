package no.forsikring.fagsystem.model;

import no.forsikring.fagsystem.enums.ForsikringKategori;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class KundeModel {
    private String kundeNummer;
    private LocalDate fodselsDato;
    private String fornavn;
    private String etternavn;
    private String telNummer;
    private String email;
    private ForsikringKategori forsikringskategori;
    private List<AvtaleModel> avtaler = new ArrayList<>();

    private KundeModel() {}

    public static class Builder {
        private String kundeNummer;
        private LocalDate fodselsDato;
        private String fornavn;
        private String etternavn;
        private String telNummer;
        private String email;
        private ForsikringKategori forsikringskategori;
        private List<AvtaleModel> avtaler = new ArrayList<>();

        public Builder() {}

        public Builder withKundeNummer(String kundeNummer) {
            this.kundeNummer = kundeNummer;
            return this;
        }

        public Builder withFodselsDato(LocalDate dato) {
            this.fodselsDato = dato;
            return this;
        }

        public Builder withFornavn(String navn) {
            this.fornavn = navn;
            return this;
        }

        public Builder withEtternavn(String etternavn) {
            this.etternavn = etternavn;
            return this;
        }

        public Builder withTelNummer(String telNummer) {
            this.telNummer = telNummer;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withForsikringskategori(ForsikringKategori forsikringskategori) {
            this.forsikringskategori = forsikringskategori;
            return this;
        }

        public Builder withAvtaler(List<AvtaleModel> avtaler) {
            this.avtaler = avtaler;
            return this;
        }

        public KundeModel build() {
            KundeModel kundeModel = new KundeModel();
            kundeModel.kundeNummer= this.kundeNummer;
            kundeModel.fodselsDato = this.fodselsDato;
            kundeModel.fornavn = this.fornavn;
            kundeModel.etternavn = this.etternavn;
            kundeModel.telNummer = this.telNummer;
            kundeModel.email = this.email;
            kundeModel.avtaler = avtaler;
            return kundeModel;
        }
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getKundeNummer() {
        return kundeNummer;
    }

    public LocalDate getFodselsDato() {
        return fodselsDato;
    }

    public String getTelNummer() {
        return telNummer;
    }

    public String getEmail() {
        return email;
    }

    public List<AvtaleModel> getAvtaler() {
        return avtaler;
    }

    public ForsikringKategori getForsikringskategori() {
        return forsikringskategori;
    }

}
