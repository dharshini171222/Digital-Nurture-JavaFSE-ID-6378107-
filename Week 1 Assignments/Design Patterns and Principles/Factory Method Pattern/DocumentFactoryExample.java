public class DocumentFactoryExample {

    // Step 1: Document Interface
    interface Document {
        void open();
    }

    // Step 2: Concrete Document Classes
    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening Word Document...");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening PDF Document...");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening Excel Document...");
        }
    }

    // Step 3: Abstract Factory
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    // Step 4: Concrete Factory Classes
    static class WordFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Main Method to Test It
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PdfFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        Document doc1 = wordFactory.createDocument();
        Document doc2 = pdfFactory.createDocument();
        Document doc3 = excelFactory.createDocument();

        doc1.open();   
        doc2.open();   
        doc3.open();   
    }
}
