# Export

## CSV
Un fichier CSV est un fichier texte "à plat" chaque ligne correspondant à une ligne du tableau, chaque colonne est séparé par des ";"
Le contenu d'une cellule peut être entouré de double quote

## CSV amélioré
Créer un objet permettant d'améliorer l'export.

## XLSX
Workbook workbook = new XSSFWorkbook();
Sheet sheet = workbook.createSheet("Clients");
Row headerRow = sheet.createRow(0);
Cell cellPrenom = headerRow.createCell(0);
cellPrenom.setCellValue("Prénom");
workbook.write(fileOutputStream);
workbook.close();

## JSON
Utilisation de JACKSON
Créer un servie et lui inject un ObjectMapper

## XML

## PDF


