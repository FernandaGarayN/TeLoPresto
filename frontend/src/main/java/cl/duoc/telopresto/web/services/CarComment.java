package cl.duoc.telopresto.web.services;

public record CarComment(
    Integer id, // Set to null when creating a comment
    String text,
    int rate) {}
