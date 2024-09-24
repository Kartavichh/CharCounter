import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Character.toLowerCase;

public class Decryption {
   private String encryptionText;
    public Decryption(String encryptionText) {
        this.encryptionText = encryptionText;
    }

    public void setEncryptionText(String encryptionText) {
        this.encryptionText = encryptionText;
    }

    public String getEncryptionText() {
        return encryptionText;
    }

    @Override
    public String toString() {
        return "encryptionText = " + "'" + encryptionText + "'";
    }

    public Map<Character, Float> sortData(String encryptionText){
        encryptionText = encryptionText.replaceAll("[^A-Za-zА-Яа-я]", "");
        char[] chars = encryptionText.toCharArray();
        Map <Character, Float> counters = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            counters.compute(toLowerCase(chars[i]), (key, count) -> count == null ? 1 : count + 1);
        }
        counters.forEach((key, value) -> System.out.println(Arrays.toString(new Character[]{key}) + " - " + value + "/" + chars.length + " = " + value/chars.length));
        System.out.println(counters.toString());
        return counters;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decryption that = (Decryption) o;
        return Objects.equals(encryptionText, that.encryptionText);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(encryptionText);
    }
}
