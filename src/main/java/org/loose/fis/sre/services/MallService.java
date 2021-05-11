package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Mall;
import java.util.Objects;
import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class MallService {
    private static ObjectRepository<Mall> MallRepository = MallService.GetRepository();   //repository-ul pentru Mall

    public static void initDatabaseMall() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Malls.db").toFile())
                .openOrCreate();

        MallRepository = database.getRepository(Mall.class);
    }

    public static void addMall(String name, String adress, String floors) throws UsernameAlreadyExistsException {
        checkMallDoesNotAlreadyExist(name);
        MallRepository.insert(new Mall(name, adress, floors));
    }

    private static void checkMallDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (Mall mall : MallRepository.find()) {
            if (Objects.equals(username, mall.getName()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static ObjectRepository<Mall> GetRepository() {
        return MallRepository;
    }
}
