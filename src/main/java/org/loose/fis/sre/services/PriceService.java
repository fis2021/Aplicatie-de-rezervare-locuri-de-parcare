package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Price;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class PriceService {

    private static ObjectRepository<Price> PriceRepository;

    public static void initDatabasePrice() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Price.db").toFile())
                .openOrCreate();

        PriceRepository = database.getRepository(Price.class);
    }

    public static void checkPriceDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (Price p : PriceRepository.find()) {
            if (Objects.equals(username, p.getNume()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static ObjectRepository<Price> getPriceRepository() {
        return PriceRepository;
    }
}
