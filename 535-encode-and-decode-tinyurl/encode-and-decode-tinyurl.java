class Codec {
    private Map<String, String> map = new HashMap<>();
    private static final String BASE_URL = "http://tinyurl.com/";
    private Random random = new Random();

    public String encode(String longUrl) {
        String key = generateKey();
        while (map.containsKey(key)) { 
            key = generateKey();
        }
        map.put(key, longUrl);
        return BASE_URL + key;
    }

    // decodes a shortened URL to its original URL
    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_URL, "");
        return map.get(key);
    }

    // helper method to generate a random 6-character key
    private String generateKey() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));