import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class Read_File {


    public Read_File(Vector<Computer> information, Vector<Vector<String>> computers) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Computers.txt"));
        String line;
        while ((line = br.readLine()) != null){
            String[] strArray = line.split(",");
            if (strArray[0].equals("Desktop PC")){
                Vector<String> temp = new Vector<>();
                Computer d = new Desktop(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4], parseInt(strArray[5]), parseInt(strArray[6]), parseInt(strArray[7]));
                information.add(d);
                temp.add(strArray[0]);
                temp.add(strArray[1]);
                temp.add(strArray[2]);
                temp.add(strArray[3]);
                temp.add(strArray[4]);
                temp.add(strArray[5]);
                temp.add(strArray[6]);
                temp.add("NULL");
                temp.add(strArray[7]);
                computers.add(temp);

            }else if (strArray[0].equals("Laptop")){
                Vector<String> temp = new Vector<>();
                Computer l = new Laptop(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4], parseInt(strArray[5]), parseInt(strArray[6]), Double.parseDouble(strArray[7]), parseInt(strArray[8]));
                information.add(l);
                temp.add(strArray[0]);
                temp.add(strArray[1]);
                temp.add(strArray[2]);
                temp.add(strArray[3]);
                temp.add(strArray[4]);
                temp.add(strArray[5]);
                temp.add(strArray[6]);
                temp.add(strArray[7]);
                temp.add(strArray[8]);
                computers.add(temp);
            }else if (strArray[0].equals("Tablet")){
                Vector<String> temp = new Vector<>();
                Computer t = new Tablet(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4], Double.parseDouble(strArray[5]), parseInt(strArray[6]));
                information.add(t);
                temp.add(strArray[0]);
                temp.add(strArray[1]);
                temp.add(strArray[2]);
                temp.add(strArray[3]);
                temp.add(strArray[4]);
                temp.add("NULL");
                temp.add("NULL");
                temp.add(strArray[5]);
                temp.add(strArray[6]);
                computers.add(temp);
            }
        }
    }


}
