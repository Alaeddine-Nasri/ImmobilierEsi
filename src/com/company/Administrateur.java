package com.company;

import java.util.Objects;

public class Administrateur {
    private String identifiant;
    private String motdepasse;

    public Administrateur(String identifiant, String motdepasse) {
        this.identifiant = identifiant;
        this.motdepasse = motdepasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrateur that = (Administrateur) o;
        return Objects.equals(identifiant, that.identifiant) &&
                Objects.equals(motdepasse, that.motdepasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, motdepasse);
    }
}
