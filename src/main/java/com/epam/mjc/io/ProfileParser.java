package com.epam.mjc.io;

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
            System.out.println("Error while trying to parse Profile parameters: " + e.getMessage());
        }

        return null;
    }
}
