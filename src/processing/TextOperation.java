package processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextOperation {

    private String date;
    private String point;

    public TextOperation() {
    }

    public void writeOperation() {

        try (PrintWriter outputStream = new PrintWriter(new FileWriter("points.txt", true))) {

            outputStream.print(this.point);
            for (int i = point.length(); i < 6; i++) {
                outputStream.print(" ");
            }
            outputStream.println("|" + getDate() + "|");

            outputStream.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Node> readPointsOperation() {
        List<Node> pointList = new ArrayList<>();
        String line;

        try (BufferedReader inputStream = new BufferedReader(new FileReader("points.txt"))) {

            while ((line = inputStream.readLine()) != null) {

                int i = 0;
                String str = "";
                Node tmp;

                while (line.charAt(i) != '|') {
                    str += line.charAt(i); 
                    i++;
                }

                tmp = new Node();
                tmp.setPoint(str);
                str = "";
                i++;

                while (line.charAt(i) != '|') {
                    str += line.charAt(i);
                    i++;
                }
                str += '\n';
                tmp.setTime(str);

                pointList.add(tmp);
            }

            inputStream.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pointList;
    }

    public List<Character> readHelpOperation() {
        List<Character> charList = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader("help.txt"))) {

            int character;
            while ((character = inputStream.read()) != -1) {
                charList.add((char) character);
            }
            inputStream.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return charList;
    }

    public String getDate() {
        SimpleDateFormat bicim2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date tarihSaat = new Date();
        date = bicim2.format(tarihSaat);
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

}
