import com.opencsv.*;
import com.sun.jdi.IntegerValue;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Aufgabe1 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("top-games-suffled.txt");
        FileWriter fw = new FileWriter("top-games-metacritic.txt");
        FileWriter fw2 = new FileWriter("top-games-date.txt");
        FileWriter fw3 = new FileWriter("top-games-name.txt");
        FileWriter fw4 = new FileWriter("top-games-user.txt");





        CSVParser parser = new CSVParserBuilder().withSeparator('*').build();
        CSVReader csv = new CSVReaderBuilder(fr).withCSVParser(parser).build();


        ArrayList<List<String>> lista = new ArrayList<>();
        String[] line;
        while ((line = csv.readNext()) != null) {
            List<String> list = Arrays.asList(line);
            lista.add(list);
        }


        /**
         * Sortieren Sie die Daten nach Metacritic Punktzahl (absteigend) und Erscheinungsdatum (absteigend).
         * Speichern Sie die Ergebnislisten in anderen Dateien (top-games-metacritic.txt, top-games-date.txt)
         */

        ArrayList<List<String>> listaSortata = new ArrayList<>();
        listaSortata.addAll(lista);
        //System.out.println(listaSortata);

        listaSortata.sort(Comparator.comparing(l -> l.get(1)));    // sortieren nach punktanzahl
        Collections.reverse(listaSortata);
        //System.out.println(listaSortata);

        // Trennen Sie die Daten mit dem Hashtag-Zeichen (#) ab.
        String joined;
        for(List<String> el : listaSortata){
            joined=String.join("#",el.toString());
            fw.write(joined);
            fw.write('\n');
            fw.flush();
        }

        ArrayList<List<String>> listaSortata2 = new ArrayList<>();
        listaSortata2.addAll(lista);

        listaSortata2.sort(Comparator.comparing(l -> l.get(3)));    // sortieren nach jahr absteigend
        Collections.reverse(listaSortata2);
       // System.out.println(listaSortata2);

        String joined2;
        for(List<String> el : listaSortata2){
            joined=String.join("#",el.toString());
            fw2.write(joined);
            fw2.write('\n');
            fw2.flush();
        }


        /**
         *  Filtern Sie die Daten, deren Benutzer Punktzahl größer als 9 (top-games-user.txt) ist
         *  und deren Name mit D (top-games-name.txt) beginnt. Trennen Sie die Daten mit dem Hashtag-Zeichen (#) ab.
         */

        ArrayList<List<String>> listaFiltrata3 = new ArrayList<>();
        List<List<String>> listaFiltrata4;
        listaFiltrata3.addAll(lista);


        listaFiltrata4=listaFiltrata3.stream().filter(s->s.get(0).charAt(0) == 'D').collect(Collectors.toList());
        //listaFiltrata4.forEach(System.out::println);


        String joined3;
        for(List<String> el : listaFiltrata4){
            joined3=String.join("#",el.toString());
            fw3.write(joined3);
            fw3.write('\n');
            fw3.flush();
        }

        ArrayList<List<String>> listaFiltrata = new ArrayList<>();
        ArrayList<List<String>> listaFiltrata2;

        listaFiltrata.addAll(lista);
        listaFiltrata2= (ArrayList<List<String>>) listaFiltrata.stream().filter(s-> Float.parseFloat(s.get(2))>9).collect(Collectors.toList());
        //listaFiltrata2.forEach(System.out::println);

        String joined4;
        for(List<String> el : listaFiltrata2){
            joined4=String.join("#",el.toString());
            fw4.write(joined4);
            fw4.write('\n');
            fw4.flush();
        }

    }
    }
