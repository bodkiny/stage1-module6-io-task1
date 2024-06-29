package com.epam.mjc.io;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ProfileParser {
    private ProfileParser() {
    }

    public static Profile parse(String params) {
        try {
            String[] lines = params.split("\n");
            String name = lines[0].split(" ")[1];
            Integer age = Integer.parseInt(lines[1].split(" ")[1]);
            String email = lines[2].split(" ")[1];
            Long phone = Long.parseLong(lines[3].split(" ")[1]);

            return new Profile(name, age, email, phone);
        } catch (NumberFormatException e) {
            Logger.getLogger("ProfileParser").log(Level.SEVERE, "Error parsing a number", e);
        }

        return null;
    }
}
