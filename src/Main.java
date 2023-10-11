import net.salesianos.Launcher.VowelLauncher;
import net.salesianos.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = Utils.getAllTextLineCounter("src\\lorem_ipsum.txt");
        ArrayList<Process> allProcesses = new ArrayList<>();

        Integer lineCounter = 0;
        String[] vocales = {"a", "e", "i", "o", "u"};

        Map<String, Integer> vowelCountMap = new HashMap<>();
        for (String vocal : vocales) {
            vowelCountMap.put(vocal, 0);
        }

        int totalVocales = 0;

        for (String line : lines) {
            lineCounter++;
            for (String vocal : vocales) {
                String outputFileName = "outputLine" + lineCounter + "_" + vocal + ".txt";
                Process javaProcess = VowelLauncher.initVowelCounter(line, vocal, outputFileName);
                allProcesses.add(javaProcess);
            }
        }

        for (Process process : allProcesses) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= lineCounter; i++) {
            for (String vocal : vocales) {
                String outputFileName = "outputLine" + i + "_" + vocal + ".txt";
                String outputFileRoute = "src/net/salesianos/outputs/" + outputFileName;
                Integer VowelsFromFile = Utils.getTotalVowelsFrom(outputFileRoute);

                vowelCountMap.put(vocal, vowelCountMap.get(vocal) + VowelsFromFile);

                totalVocales += VowelsFromFile;

                System.out.println("El fichero " + outputFileName + " tiene " + VowelsFromFile);

                File outputFile = new File(outputFileRoute);
                outputFile.delete();
            }
        }

        for (String vocal : vocales) {
            System.out.println("Total de " + vocal + ": " + vowelCountMap.get(vocal));
        }

        System.out.println("La cantidad de vocales son de : " + totalVocales);
    }
}

