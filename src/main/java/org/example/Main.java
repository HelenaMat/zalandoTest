package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

        public static void main(String[] args) {
            String chromedriverVersion = getChromeDriverVersion();
            System.out.println("Chromedriver version: " + chromedriverVersion);
        }

        public static String getChromeDriverVersion() {
            try {
                Process process = Runtime.getRuntime().exec("chromedriver.exe --version");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = reader.readLine();
                return line != null ? line.trim() : "unknown";
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
    }

