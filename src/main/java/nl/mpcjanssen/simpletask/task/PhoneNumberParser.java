/**
 * LICENSE:
 *
 * Simpletask is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any
 * later version.
 *
 * Simpletask Touch is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with Simpletask.  If not, see
 * <http://www.gnu.org/licenses/>.
 *
 * @author Todo.txt contributors <todotxt@yahoogroups.com>
 * @author Mark Janssen
 * @license http://www.gnu.org/licenses/gpl.html
 * @copyright 2009-2013 Todo.txt contributors (http://todotxt.com)
 * @copyright 2013- Mark Janssen
 */

package nl.mpcjanssen.simpletask.task;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberParser {
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern
            .compile("\\s[0\\\\+]?[0-9,#]{4,}\\w");
    private static final PhoneNumberParser INSTANCE = new PhoneNumberParser();

    private PhoneNumberParser() {
    }

    @NonNull
    public static PhoneNumberParser getInstance() {
        return INSTANCE;
    }

    @NonNull
    public List<String> parse(@Nullable String inputText) {
        if (inputText == null) {
            return Collections.emptyList();
        }

        Matcher m = PHONE_NUMBER_PATTERN.matcher(inputText);
        List<String> matches = new ArrayList<>();
        while (m.find()) {
            matches.add(m.group().trim());
        }
        return matches;
    }
}
