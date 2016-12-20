package pl.opms.be.utils.generator;

/**
 * Created by Dawid on 20.12.2016 at 00:20.
 */
import java.security.SecureRandom;
import java.math.BigInteger;

public final class PasswordGenerator {
    private SecureRandom random = new SecureRandom();

    public String next() {
        return new BigInteger(130, random).toString(32);
    }
}
