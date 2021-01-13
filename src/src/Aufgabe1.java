import com.opencsv.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Aufgabe1 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("top-games-suffled.txt");
        FileWriter fw = new FileWriter("top-games-metacritic.txt");

        CSVParser parser = new CSVParserBuilder().withSeparator('*').build();
        CSVReader csv = new CSVReaderBuilder(fr).withCSVParser(parser).build();


        ArrayList<List<String>> lista = new ArrayList<>();
        String[] line;
        while ((line = csv.readNext()) != null) {
            List<String> list = Arrays.asList(line);
            //System.out.println(list);
            lista.add(list);
            String joined;
//            joined = String.join(";", list);
//                fw.write(joined);
//                fw.flush();
//                System.out.println();
//            }
            fw.close();
        }
        //lista.forEach(System.out::println);
        //System.out.println(lista.get(1).get(1));

        /**
         * Sortieren Sie die Daten nach Metacritic Punktzahl (absteigend) und Erscheinungsdatum (absteigend).
         * Speichern Sie die Ergebnislisten in anderen Dateien (top-games-metacritic.txt, top-games-date.txt)
         */

        ArrayList<String> lista_sortata = new ArrayList<>();

        lista.sort(Comparator.comparing(l -> l.get(1)));    // sortieren nach punktanzahl
        Collections.reverse(lista);
        System.out.println(lista);


    }
    }
