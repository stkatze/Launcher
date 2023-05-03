import javax.imageio.IIOException;
import java.io.*;

public class Main {

    private static StringBuilder newLog = new StringBuilder();

    public static void main(String[] args) {
        newDir("Games", "src");
        newDir("Games", "res");
        newDir("Games", "savegames");
        newDir("Games", "temp");

        newDir("Games/src", "main");
        newDir("Games/src", "test");

        newFile("Games/src/main", "Main.java");
        newFile("Games/src/main", "Utils.java");

        newDir("Games/res", "drawables");
        newDir("Games/res", "vectors");
        newDir("Games/res", "icons");

        newFile("Games/temp/", "temp.txt");

        createLog();
    }

    public static void newDir(String dirPath, String dirName) {
        File dir = new File(dirPath + "/" + dirName);
        String log;
        if (dir.mkdir()) {
            log = "Папка " + dirName + " создана в директории " + dirPath;
        } else {
            log = "Ошибка! Не удалось создать папку " + dirName + " в директории " + dirPath;
        }
        newLog.append(log);
    }

    public static void newFile(String filePath, String fileName) {
        File file = new File(filePath + "/" + fileName);
        String log;
        try {
            if (file.createNewFile()) {
                log = "Файл " + fileName + " был создвн в директории " + filePath;
            } else {
                log = "Ошибка! Не удалось создать файл " + fileName + " в директории " + filePath;
            }
        } catch (IOException e) {
        }
        newLog.append(log);
    }


    public static void createLog() {
        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {
            writer.write(newLog.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

