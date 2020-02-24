import java.util.*;

public class DocumentManager {

  private static String excelExtension = "xlsx";
  private static String wordExtension = "docx";
  private static String powerpointExtension = "pptx";




  private Map<String, ArrayList<String>> documentMap = new HashMap<String, ArrayList<String>>();

  private String fileName;


  /////////////////////////////////////////
  // Bean class.
  ////////////////////////////////////////
  public DocumentManager(String fn) {
    if (fn.endsWith(excelExtension) || fileName.endsWith(wordExtension) || fileName.endsWith(powerpointExtension)) {
    fileName = fn;
    String extension = "";
    for (int i = 0; i < fileName.length()-1; i++) {
      if (fileName.charAt(i) == '.') {
        extension = fileName.substring(i+1, fileName.length());
        break;
      }
    }

    if (documentMap.get(extension) != null) {
      documentMap.get(extension).add(fileName);
    } else {
      ArrayList<String> filenames = new ArrayList<String>();
      filenames.add(fileName);
      documentMap.put(extension, filenames);
    }

    }
  }

  public ArrayList<String> getAllDocumentsForTExtension(String extension) {
    return documentMap.get(extension);
  }
  public int getDocumentStoredForExtension(String extension) {
    return documentMap.get(extension).size();
  }
  public boolean isDocumentTypeSupported(String extension) {
    return documentMap.containsKey(extension);
  }
  
}
