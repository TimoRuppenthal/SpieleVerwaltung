package de.shs.digitalisierung.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record SpielDaten(String name, String genre, String schwierigkeit, int errungenschaften) {
}