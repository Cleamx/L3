import java.util.*;
import java.util.zip.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ReadXLSX {
    public List<List<String>> readXLSX() throws Exception {
        ZipFile zipFile = new ZipFile("Liste_Pokemon.xlsx");

        // Lire les chaînes partagées
        ZipEntry sharedStringXML = zipFile.getEntry("xl/sharedStrings.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(zipFile.getInputStream(sharedStringXML));
        NodeList list = doc.getElementsByTagName("t");
        List<String> sharedStrings = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            sharedStrings.add(list.item(i).getTextContent());
        }

        // Lire les données de la feuille
        ZipEntry sheetXML = zipFile.getEntry("xl/worksheets/sheet1.xml");
        doc = dBuilder.parse(zipFile.getInputStream(sheetXML));
        NodeList rowNodes = doc.getElementsByTagName("row");

        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < rowNodes.getLength(); i++) {
            NodeList cellNodes = ((Element) rowNodes.item(i)).getElementsByTagName("c");
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cellNodes.getLength(); j++) {
                Element cellElement = (Element) cellNodes.item(j);
                String cellValue = getCellValue(cellElement, sharedStrings);
                row.add(cellValue);
            }
            data.add(row);
        }

        // Liste des types de Pokémon pour la vérification
        List<String> types = Arrays.asList("Normal", "Feu", "Eau", "Plante", "Électrik", "Glace", "Combat", "Poison",
                "Sol", "Vol", "Psy", "Insecte", "Roche", "Spectre", "Dragon", "Ténèbres", "Acier", "Fée");

        for (List<String> colonne : data) {
            // Si l'avant-dernier élément n'est pas un type, insérez un espace avant le
            // dernier élément
            if (!types.contains(colonne.get(colonne.size() - 2))) {
                colonne.add(colonne.size() - 1, " ");
            }
        }

        zipFile.close();
        data.remove(0);
        return data;
    }

    private static String getCellValue(Element cellElement, List<String> sharedStrings) {
        String cellValue = "";
        NodeList vNodes = cellElement.getElementsByTagName("v");
        if (vNodes.getLength() > 0) {
            String value = vNodes.item(0).getTextContent();
            if (cellElement.getAttribute("t").equals("s")) {
                int idx = Integer.parseInt(value);
                cellValue = sharedStrings.get(idx);
            } else {
                cellValue = value;
            }
        }
        return cellValue;
    }
}