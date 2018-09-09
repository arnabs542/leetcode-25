package string;

import java.util.*;

public class EncodeAndDecodeTinyURL {
    // hash code is not right to get the longUrl using shortUrl
    // shortUrl should be unique!
    public class Codec {
        List<String> urls = new ArrayList<String>();
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            urls.add(longUrl);
            return String.valueOf(urls.size()-1);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int index = Integer.valueOf(shortUrl);
            return (index<urls.size())?urls.get(index):"";
        }
    }

}
