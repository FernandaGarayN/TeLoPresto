package cl.duoc.newrentacar.api.endpoint.model;

public record CarComment(
        Integer id, // Set to null when creating a comment
        String text,
        int rate
) {
}
