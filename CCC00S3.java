import java.io.*;
import java.util.*;
/**
 * CCC '00 S3 - Surfing
 * Question type: Graph Theory, Regular Expressions
 * 2/2 on DMOJ
 * @author  Tommy Pang
 */
public class CCC00S3 {
    final static String CANT_STRING = "Can't surf from ";
    final static String CAN_STRING = "Can surf from ";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<String, List<String>> urlDoc = new HashMap<>();
    static Map<String, String> visitedURL = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String url = br.readLine();
            String doc;
            while (true) {
                List<String> arr = new ArrayList<>();
                doc = br.readLine();
                if (doc.equals("</HTML>")) break;
                if(!parseDoc(doc).isEmpty()) {
                    arr.addAll(parseDoc(doc));
                }
                if (!arr.isEmpty()) {
                    for (String item : arr) {
                        if(!url.equals(item)){
                            System.out.println("Link from " + url + " to " + item);
                        }
                    }
                }
                List<String> teampArr = urlDoc.get(url) == null ? new ArrayList<>() : urlDoc.get(url);
                teampArr.addAll(arr);
                urlDoc.put(url, teampArr);
            }

        }

        while (true) {
            String srcURL = br.readLine();
            if (srcURL.equals("The End")) return;
            String destURL = br.readLine();
            if (destURL.equals("The End")) return;

            if (isSurfable(srcURL, destURL)) {
                System.out.println(CAN_STRING + srcURL + " to " + destURL + ".");
            } else {
                System.out.println(CANT_STRING + srcURL + " to " + destURL + ".");
            }
        }

    }

    static List<String> parseDoc(String doc) {
        List<String> hrefList = new ArrayList<>();
        if (doc.contains("HREF")) {
            String[] line = doc.split("<A HREF=\"");
            for (int i = 1; i < line.length; i++) {
                hrefList.add(line[i].split("\"")[0]);
            }
        }
        return hrefList;
    }


    static boolean isSurfable(String source, String dest) {
        visitedURL.put(source,source);
        if (urlDoc.containsKey(source) && urlDoc.get(source).contains(dest)) {
            visitedURL.clear();
            return true;
        }
        if (urlDoc.containsKey(source)) {
            for (String item : urlDoc.get(source)) {
                if(!visitedURL.containsKey(item)) {
                    visitedURL.put(item,item);
                } else {
                    return false;
                }
                if (isSurfable(item, dest)) {
                    visitedURL.clear();
                    return true;
                }
            }
        }
        return false;
    }

}




