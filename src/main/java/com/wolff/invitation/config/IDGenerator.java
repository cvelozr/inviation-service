package com.wolff.invitation.config;

import java.security.SecureRandom;

public class IDGenerator {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int ID_LENGTH = 7;
    private static final SecureRandom random = new SecureRandom();

    public static String generarID() {
        StringBuilder sb = new StringBuilder(ID_LENGTH);
        sb.append(":");
        for (int i = 0; i < ID_LENGTH-1; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
