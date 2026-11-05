package berlanga_diaz.crossvault.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Jaime Berlanga Diaz
 */
public class I18n {

    private static final Locale LOCALE_CA = Locale.forLanguageTag("ca-ES");
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("Bundle_ca", LOCALE_CA);

    public static String get(String key) {
        return BUNDLE.getString(key);
    }
}
