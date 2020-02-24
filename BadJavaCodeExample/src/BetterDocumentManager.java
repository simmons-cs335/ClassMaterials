// Implementation of a better document manager.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BetterDocumentManager {

  private static final HashSet<String> DOC_TYPES = new HashSet<String>(){{add("xlsx"); add("docx"); add("pptx");}};
  private Map<String, ArrayList<String>> documentMap = new HashMap<String, ArrayList<String>>();


  /**
   * BetterDocumentManager Constructor
   *
   * @param fileName
   * @throws Exception
   */
  public BetterDocumentManager(String fileName) throws Exception {
    String docType = fileName.contains(".") ? fileName.split(".")[1] : null;
    if (docType == null || !DOC_TYPES.contains(docType)) {
      throw new Exception("Document type '" + docType  + "' is missing or unsupported.");
    } else {
      if (documentMap.containsKey(docType)) {
        documentMap.get(docType).add(fileName);
      } else {
        documentMap.put(docType, new ArrayList<String>(){{add(fileName); }});
      }
    }
  }

  /**
   * Returns a list of stored documents having the given extension.
   *
   * @param extension file extension (type)
   * @return a list if document names
   */
  public ArrayList<String> getAllDocumentsForTExtension(String extension) {
    return documentMap.get(extension);
  }

  /**
   * Returns number of stored documents of that type.
   *
   * @param extension file extension (type)
   * @return stored document count
   */
  public int getDocumentStoredForExtension(String extension) {
    return documentMap.get(extension).size();
  }

  /**
   * @param extension file extension (type)
   * @return true if document type is supported; false otherwise.
   */
  public boolean isDocumentTypeSupported(String extension) {
    return DOC_TYPES.contains(extension);
  }

}
