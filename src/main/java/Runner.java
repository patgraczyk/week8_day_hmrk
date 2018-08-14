import db.DBFolder;
import db.DBHelper;
import db.DBOwner;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner = new Owner("Molly", "molski");
        DBHelper.save(owner);

        Folder folder = new Folder( "CodeClan", owner);
        Folder folder2 = new Folder("designs", owner);

        DBHelper.save(folder);
        DBHelper.save(folder2);

        folder2.setTitle("Graphics");
        DBHelper.update(folder2);

        File file = new File( ".ppt", 4, folder );
        File file1 = new File(".rb", 4, folder2);
        File file2 = new File(".xml", 4, folder);
        DBHelper.save(file);
        DBHelper.save(file1);
        DBHelper.save(file2);

        file1.setSize(24);
        DBHelper.update(file1);

        List<File> files = DBFolder.getFilesByFolder(folder);
        List<Folder> foldersByOwner = DBOwner.getFoldersByOwner(owner);
        List<Folder> folders = DBHelper.getAll(Folder.class);
        List<File> filesFound = DBHelper.getAll(File.class);

        Folder folderFound = DBHelper.findById(Folder.class, 1);
        File fileFound = DBHelper.findById(File.class, 2);

        DBHelper.delete(file1);
    }
}