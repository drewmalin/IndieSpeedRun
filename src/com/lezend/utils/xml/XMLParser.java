package com.lezend.utils.xml;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class XMLParser {
    private static BufferedReader br;
    public Node root;

    /** XMLParser() - Constructor for XMLParser object. Reads through an XML file and constructs a simple
     * tree to store the node data. Each node has a name (string), data (string), and set of n children
     * nodes.
     *
     * @author drewmalin
     * @param filename - The text name of the file to parse. Must be a valid XML file. The string passed
     * to this constructor must be in the form of a path relative to the calling package. (E.g. If the
     * file path is bin/com/res/file.xml, the string should be "/com/res/file.xml")
     */
    public XMLParser(String filename) {
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));

            //br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filename)));

        } catch (Exception e) {
            e.printStackTrace();
        }
        root = new Node();
        root.name = filename;
        root.data = null;
        parse();
    }

    /*
     * The beginning of the parsing routine. Starts parsing elements at the top
     * of an XML file. The "root" of the file is technically the file itself, and
     * thus it will have no data.
     */
    private void parse() {
        String strLine;
        try {
            while ((strLine = readLine(br)) != null) {
                Node child = new Node();
                root.children.add(child);
                persistElement(child, strLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Reads a line and prepares it to be read. First takes the string from the
     * buffered reader, trims off whitespace, passes over empty lines, and eats
     * up comments.
     */
    private String readLine(BufferedReader br) throws Exception {
        String strLine = null;

        strLine = br.readLine();
        if (strLine == null)
            return strLine;
        else {
            strLine = strLine.trim();
            if (strLine.isEmpty())
                return readLine(br);
            if (eatComments(strLine))
                return readLine(br);
        }

        return strLine;
    }

    /*
     * Parses and persists an XML element. Reads all standalone leaf elements (<a>1</a>)
     * in addition to recursing on new root elements (<a><b>1</b></a>).
     */
    private void persistElement(Node n, String contextLine) throws Exception {
        n.name = readElementName(contextLine);
        n.data = "";

        if (contextLine.contains("</" + n.name + ">")) {					//Data is on one line (<a>data</a>)
            n.data = readElementValue(contextLine);
        }
        else {
            String strLine = readLine(br);
            while (!strLine.contains("<") || !strLine.contains(">")) {		  //Data uses multiple lines (<a>data\ndata\ndata</a>)
                n.data += strLine + "\n";
                strLine = readLine(br);
            }
            while (strLine != null && !strLine.equals("</" + n.name + ">")) { //Data is nested (<a><b>data</b></a>)
                Node child = new Node();
                n.children.add(child);
                persistElement(child, strLine);
                strLine = readLine(br);
            }
        }
    }

    /*
     * Loops over a line until the current comment block has been eaten up.
     */
    private boolean eatComments(String strLine) throws Exception {
        if (strLine.contains("<!--")) {
            while (!strLine.contains("-->")) {
                strLine = br.readLine();
            }
            return true;
        }
        return false;
    }

    public void close() {
        try {
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readElementName(String s) {
        return s.substring(s.indexOf('<')+1, s.indexOf('>'));
    }

    private static String readElementValue(String s) {
        return s.substring(s.indexOf('>')+1, s.lastIndexOf('<'));
    }
}
