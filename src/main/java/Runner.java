import db.DBFolder;
import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder = new Folder( "CodeClan");
        Folder folder2 = new Folder("designs");

        DBHelper.save(folder);
        DBHelper.save(folder2);

        File file = new File( ".ppt", 4, folder );
        File file1 = new File(".rb", 4, folder2);
        File file2 = new File(".xml", 4, folder);
        DBHelper.save(file);
        DBHelper.save(file1);
        DBHelper.save(file2);

        List<File> files = DBFolder.getFilesByFolder(folder);
    }
}