package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("Passed File object is null");
        }

        if (!file.canRead()) {
            throw new IllegalArgumentException("Application cannot read passed File");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            sb.setLength(sb.length() - 1);

            return ProfileParser.parse(sb.toString());
        } catch (IOException e) {
            Logger.getLogger("FileReader").log(Level.SEVERE, "Error reading file", e);
        }

        return null;
    }
}
