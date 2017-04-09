package wang7liang.test;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by wang7liang on 2017/4/9.
 */
public class GenerationRules {
    public static final void main(String[] args){
        File file = new File("C:\\Users\\wang7liang\\Desktop\\Sample2.xls");
        try {
            InputStream is = new FileInputStream(file);
            SpreadsheetCompiler converter = new SpreadsheetCompiler();
            String drl = converter.compile(is, InputType.XLS);
            System.out.println("\n\n" + drl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
